package org.openvasp.core;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.openvasp.core.model.*;

public class IvmsTest {
    public static void main(String[] args) {
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

        // orginator 1 name id
        LegalPersonNameId origi1NameId = new LegalPersonNameId();
        origi1NameId.setLegalPersonName("VASP A");
        origi1NameId.setLegalPersonNameIdentifierType(LegalPersonNameId.LegalPersonNameIdentifierTypeEnum.LEGL);

        // assign orginator 1 name with id
        LegalPersonName origi1PersonName = new LegalPersonName();
        origi1PersonName.addNameIdentifiersItem(origi1NameId);

        // assign NationalIdentification
        NationalIdentification nationalIdentification = new NationalIdentification();
        nationalIdentification.setNationalIdentifier("506700T7Z685VUOZL877");
        nationalIdentification.setNationalIdentifierType(NationalIdentification.NationalIdentifierTypeEnum.LEIX);

        // orginator 1 is a legal person
        LegalPerson orginator1LegalPerson = new LegalPerson();
        orginator1LegalPerson.setName(origi1PersonName);
        orginator1LegalPerson.setNationalIdentification(nationalIdentification);

        // assign orginator 1 to person object
        Person orginator1Person = new Person();
        orginator1Person.setLegalPerson(orginator1LegalPerson);

        // assign originator and beneficiary data to identity payload
        IdentityPayload privateInfo = new IdentityPayload();
        privateInfo.setOriginator(originator);
        privateInfo.setBeneficiary(beneficiary);
        privateInfo.setOriginatingVasp(orginator1Person);

        IVMS101 ivms101 = new IVMS101();
        ivms101.setIdentityPayload(privateInfo);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(ivms101));
    }
}