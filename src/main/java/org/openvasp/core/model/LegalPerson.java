/*
 * Bridge
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 2
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openvasp.core.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * LegalPerson
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-05T14:32:36.025401+02:00[Europe/Kiev]")
public class LegalPerson {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private LegalPersonName name;

  public static final String SERIALIZED_NAME_GEOGRAPHIC_ADDRESSES = "geographicAddresses";
  @SerializedName(SERIALIZED_NAME_GEOGRAPHIC_ADDRESSES)
  private List<Address> geographicAddresses = null;

  public static final String SERIALIZED_NAME_CUSTOMER_NUMBER = "customerNumber";
  @SerializedName(SERIALIZED_NAME_CUSTOMER_NUMBER)
  private String customerNumber;

  public static final String SERIALIZED_NAME_NATIONAL_IDENTIFICATION = "nationalIdentification";
  @SerializedName(SERIALIZED_NAME_NATIONAL_IDENTIFICATION)
  private NationalIdentification nationalIdentification;

  public static final String SERIALIZED_NAME_COUNTRY_OF_REGISTRATION = "countryOfRegistration";
  @SerializedName(SERIALIZED_NAME_COUNTRY_OF_REGISTRATION)
  private String countryOfRegistration;


  public LegalPerson name(LegalPersonName name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public LegalPersonName getName() {
    return name;
  }


  public void setName(LegalPersonName name) {
    this.name = name;
  }


  public LegalPerson geographicAddresses(List<Address> geographicAddresses) {
    
    this.geographicAddresses = geographicAddresses;
    return this;
  }

  public LegalPerson addGeographicAddressesItem(Address geographicAddressesItem) {
    if (this.geographicAddresses == null) {
      this.geographicAddresses = new ArrayList<Address>();
    }
    this.geographicAddresses.add(geographicAddressesItem);
    return this;
  }

   /**
   * Get geographicAddresses
   * @return geographicAddresses
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Address> getGeographicAddresses() {
    return geographicAddresses;
  }


  public void setGeographicAddresses(List<Address> geographicAddresses) {
    this.geographicAddresses = geographicAddresses;
  }


  public LegalPerson customerNumber(String customerNumber) {
    
    this.customerNumber = customerNumber;
    return this;
  }

   /**
   * Get customerNumber
   * @return customerNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCustomerNumber() {
    return customerNumber;
  }


  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }


  public LegalPerson nationalIdentification(NationalIdentification nationalIdentification) {
    
    this.nationalIdentification = nationalIdentification;
    return this;
  }

   /**
   * Get nationalIdentification
   * @return nationalIdentification
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public NationalIdentification getNationalIdentification() {
    return nationalIdentification;
  }


  public void setNationalIdentification(NationalIdentification nationalIdentification) {
    this.nationalIdentification = nationalIdentification;
  }


  public LegalPerson countryOfRegistration(String countryOfRegistration) {
    
    this.countryOfRegistration = countryOfRegistration;
    return this;
  }

   /**
   * Get countryOfRegistration
   * @return countryOfRegistration
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCountryOfRegistration() {
    return countryOfRegistration;
  }


  public void setCountryOfRegistration(String countryOfRegistration) {
    this.countryOfRegistration = countryOfRegistration;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LegalPerson legalPerson = (LegalPerson) o;
    return Objects.equals(this.name, legalPerson.name) &&
        Objects.equals(this.geographicAddresses, legalPerson.geographicAddresses) &&
        Objects.equals(this.customerNumber, legalPerson.customerNumber) &&
        Objects.equals(this.nationalIdentification, legalPerson.nationalIdentification) &&
        Objects.equals(this.countryOfRegistration, legalPerson.countryOfRegistration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, geographicAddresses, customerNumber, nationalIdentification, countryOfRegistration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LegalPerson {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    geographicAddresses: ").append(toIndentedString(geographicAddresses)).append("\n");
    sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
    sb.append("    nationalIdentification: ").append(toIndentedString(nationalIdentification)).append("\n");
    sb.append("    countryOfRegistration: ").append(toIndentedString(countryOfRegistration)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

