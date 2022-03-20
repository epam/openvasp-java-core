package org.openvasp.core.lnurl;

import org.bitcoinj.core.Bech32;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;


/**
 * Server class encapsulates LNURL server work.
 * Details: https://github.com/fiatjaf/lnurl-rfc
 *
 * JavaScript's implementation: https://www.npmjs.com/package/lnurl
 *
 * Bech32 specification: https://github.com/bitcoin/bips/blob/master/bip-0173.mediawiki#Bech32
 * Library for work with Bech32: https://github.com/bitcoinj/bitcoinj
 */
public class Server {
    // Server host.
    private final String host;
    // Server port.
    private final Integer port;

    /**
     * Constructor with host and port.
     * @param host Server host name.
     * @param port Server port.
     */
    public Server(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    /**
     * Constructor for empty port.
     * @param host Server host name.
     */
    public Server(String host) {
        this(host, null);
    }

    /**
     * Generate new LNURL.
     * @return Newly generated LNURL.
     */
    public String generateNewUrl() {
        String secret = getRandomHexString(12);
        if (port != null) {
            return String.format("https://%s:%d/api?q=%s", host, port, secret);
        }
        return String.format("https://%s/api?q=%s", host, secret);
    }

    /**
     * Encode LNRUL with Bech32 encoding.
     * @param lnurl
     * @return
     */
    public String encodeUrl(String lnurl) {
        byte[] data = convertBytes(lnurl.getBytes(StandardCharsets.US_ASCII), 8, 5, true);
        return Bech32.encode(Bech32.Encoding.BECH32, "lnurl", data);
    }

    /**
     * Decoded encoded LNURL.
     * @param encoded Encoded LNURL.
     * @return Decoded LNURL.
     */
    public String decodeUrl(String encoded) {
        byte[] data = Bech32.decode(encoded).data;
        return new String(convertBytes(data, 5, 8, false));
    }

    /**
     * Generate random hex string
     * @param numchars String length.
     * @return Generated hex string.
     */
    private String getRandomHexString(int numchars){
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

    public static void main(String[] args) {
        Server server = new Server("beneficiary.com");
        String lnurl = server.generateNewUrl();
        String encodedUrl = server.encodeUrl(lnurl);
        System.out.println(encodedUrl);
        String url = server.decodeUrl(encodedUrl);
        System.out.println(url);
    }
}
