package org.openvasp.core.model.ivms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.openvasp.core.model.ivms101.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Ivms101Test {
    @Test
    void generateIvms101() {
        // Originator
        // originator name id
        NaturalPersonNameId orgNameId = new NaturalPersonNameId();
        orgNameId.setPrimaryIdentifier("Post");
        orgNameId.setSecondaryIdentifier("Johnny");
        orgNameId.setNameIdentifierType(NaturalPersonNameId.NameIdentifierTypeEnum.LEGL);

        // geographic address
        Address address = new Address();
        address.setAddressType(Address.AddressTypeEnum.GEOG);
        address.setStreetName("Potential Street");
        address.setBuildingNumber("123");
        address.setBuildingName("Cheese Hut");
        address.setPostCode("91361");
        address.setTownName("Thousand Oaks");
        address.setCountrySubDivision("California");
        address.setCountry("US");

        // assign two name id to originator name
        NaturalPersonName orgPersonName = new NaturalPersonName();
        orgPersonName.addNameIdentifiersItem(orgNameId);


        // assign name, national id, country to originator natural person
        NaturalPerson originatingNaturalPerson = new NaturalPerson();
        originatingNaturalPerson.setName(orgPersonName);
        originatingNaturalPerson.addGeographicAddressesItem(address);
        originatingNaturalPerson.setCustomerIdentification("1002390");

        // assign originator to person object
        Person originatingPerson = new Person();
        originatingPerson.setNaturalPerson(originatingNaturalPerson);

        // assign originator person and account id to originator
        Originator originator = new Originator();
        originator.addOriginatorPersonsItem(originatingPerson);
        originator.addAccountNumbersItem("1BvBMSEYstWetqTFn5Au4m4GFg7xJaNVN2");

        // Beneficiary
        // beneficiary 1 name id
        LegalPersonNameId bene1NameId = new LegalPersonNameId();
        bene1NameId.setLegalPersonName("ABC Limited");
        bene1NameId.setLegalPersonNameIdentifierType(LegalPersonNameId.LegalPersonNameIdentifierTypeEnum.LEGL);

        // assign beneficiary 1 name with id
        LegalPersonName bene1PersonName = new LegalPersonName();
        bene1PersonName.addNameIdentifiersItem(bene1NameId);

        // beneficiary 1 is a legal person
        LegalPerson beneficiary1LegalPerson = new LegalPerson();
        beneficiary1LegalPerson.setName(bene1PersonName);

        // assign beneficiary 1 to person object
        Person beneficiary1Person = new Person();
        beneficiary1Person.setLegalPerson(beneficiary1LegalPerson);

        // beneficiary 2 name id
        LegalPersonNameId bene2NameId = new LegalPersonNameId();
        bene2NameId.setLegalPersonName("CBA Trading");
        bene2NameId.setLegalPersonNameIdentifierType(LegalPersonNameId.LegalPersonNameIdentifierTypeEnum.TRAD);

        // assign beneficiary 2 name with id
        LegalPersonName bene2PersonName = new LegalPersonName();
        bene2PersonName.addNameIdentifiersItem(bene2NameId);

        // beneficiary 2 is a legal person
        LegalPerson beneficiary2LegalPerson = new LegalPerson();
        beneficiary2LegalPerson.setName(bene2PersonName);

        // assign beneficiary 2 to person object
        Person beneficiary2Person = new Person();
        beneficiary2Person.setLegalPerson(beneficiary2LegalPerson);

        NaturalPersonNameId benNameId = new NaturalPersonNameId();
        benNameId.setPrimaryIdentifier("MachuPichu");
        benNameId.setSecondaryIdentifier("Freddie");
        benNameId.setNameIdentifierType(NaturalPersonNameId.NameIdentifierTypeEnum.LEGL);

        // assign two name id to originator name
        NaturalPersonName benPersonName = new NaturalPersonName();
        benPersonName.addNameIdentifiersItem(benNameId);

        // assign name, national id, country to originator natural person
        NaturalPerson benNaturalPerson = new NaturalPerson();
        benNaturalPerson.setName(benPersonName);

        // assign originator to person object
        Person benPerson = new Person();
        benPerson.setNaturalPerson(benNaturalPerson);

        // assign both persons to beneficiary object
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.addBeneficiaryPersonsItem(benPerson);
        beneficiary.addAccountNumbersItem("1BVMFfPXJy2TY1x6wm8gow3N5Amw4Etm5h");

        // originator 1 name id
        LegalPersonNameId origi1NameId = new LegalPersonNameId();
        origi1NameId.setLegalPersonName("VASP A");
        origi1NameId.setLegalPersonNameIdentifierType(LegalPersonNameId.LegalPersonNameIdentifierTypeEnum.LEGL);

        // assign originator 1 name with id
        LegalPersonName origi1PersonName = new LegalPersonName();
        origi1PersonName.addNameIdentifiersItem(origi1NameId);

        // assign NationalIdentification
        NationalIdentification nationalIdentification = new NationalIdentification();
        nationalIdentification.setNationalIdentifier("506700T7Z685VUOZL877");
        nationalIdentification.setNationalIdentifierType(NationalIdentification.NationalIdentifierTypeEnum.LEIX);

        // originator 1 is a legal person
        LegalPerson originator1LegalPerson = new LegalPerson();
        originator1LegalPerson.setName(origi1PersonName);
        originator1LegalPerson.setNationalIdentification(nationalIdentification);

        // assign originator 1 to person object
        Person originator1Person = new Person();
        originator1Person.setLegalPerson(originator1LegalPerson);

        // assign originator and beneficiary data to identity payload
        IdentityPayload privateInfo = new IdentityPayload();
        privateInfo.setOriginator(originator);
        privateInfo.setBeneficiary(beneficiary);
        privateInfo.setOriginatingVasp(originator1Person);

        Ivms101 ivms1 = new Ivms101();
        ivms1.setIdentityPayload(privateInfo);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Ivms101 ivms2 = gson.fromJson(getResource("json-test-data/ivms101/ivms101.json"), Ivms101.class);
        String ivmsStr1 = gson.toJson(ivms1);
        String ivmsStr2 = gson.toJson(ivms2);

        Assertions.assertEquals(ivmsStr1, ivmsStr2);
    }

    public String getResource(String resource) {
        StringBuilder json = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(resource)),
                            StandardCharsets.UTF_8));
            String str;
            while ((str = in.readLine()) != null)
                json.append(str);
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("Caught exception reading resource " + resource, e);
        }
        return json.toString();
    }
}