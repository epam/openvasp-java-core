package org.openvasp.core.lnurl;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;


/**
 * Lnurl service class for generating, encoding/decodings LNURLs.
 * Details: https://github.com/fiatjaf/lnurl-rfc
 *
 * JavaScript's implementation: https://www.npmjs.com/package/lnurl
 *
 * Bech32 specification: https://github.com/bitcoin/bips/blob/master/bip-0173.mediawiki#Bech32
 * Library for work with Bech32: https://github.com/bitcoinj/bitcoinj
 *
 * Online encoder/decoder https://lnurl.fiatjaf.com/codec/
 */
public class Lnurl {

    /**
     * Generate new LNURL.
     * @param baseUrl Bse URL.
     * @return Newly generated LNURL.
     */
    public static String generateNewUrl(String baseUrl) {
        String secret = Lnurl.getRandomHexString(12);
        return String.format("%s?q=%s&tag=travelRuleInquiry", baseUrl, secret);
    }

    /**
     * Encode LNURL with Bech32 encoding.
     * @param lnurl
     * @return
     */
    public static String encodeUrl(String lnurl) {
        byte[] data = convertBytes(lnurl.getBytes(StandardCharsets.US_ASCII), 8, 5, true);
        return Bech32.encode(Bech32.Encoding.BECH32, "lnurl", data).toUpperCase();
    }

    /**
     * Decoded encoded LNURL.
     * @param encoded Encoded LNURL.
     * @return Decoded LNURL.
     */
    public static String decodeUrl(String encoded) {
        byte[] data = Bech32.decode(encoded).data;
        return new String(convertBytes(data, 5, 8, false));
    }

    /**
     * Generate random hex string
     * @param numchars String length.
     * @return Generated hex string.
     */
    public static String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }

    /**
     * Convert array of bytes to new array with given base.
     * @param data Input data.
     * @param inBits Number of input bits.
     * @param outBits Number of out bits.
     * @param pad Use pad or no.
     * @return Converted array of bytes with new base.
     */
    public static byte[] convertBytes(byte[] data, int inBits, int outBits, boolean pad) {
        int value = 0;
        int bits = 0;
        int maxV = (1 << outBits) - 1;
        byte[] result = new byte[1024];
        int bi = 0;
        for (int i = 0; i < data.length; ++i) {
            value = (value << inBits) | data[i];
            bits += inBits;
            while (bits >= outBits) {
                bits -= outBits;
                result[bi++] = (byte)((value >> bits) & maxV);
            }
        }
        if (pad) {
            if (bits > 0) {
                result[bi++] = (byte)((value << (outBits - bits)) & maxV);
            }
        }
        else {
            if (bits >= inBits)
                throw new RuntimeException("Excess padding");
            if (((value << (outBits - bits)) & maxV) != 0)
                throw new RuntimeException("Non-zero padding");
        }
        return Arrays.copyOfRange(result, 0, bi);
    }
}
