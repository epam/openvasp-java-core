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
 * NaturalPerson
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-05T14:32:36.025401+02:00[Europe/Kiev]")
public class NaturalPerson {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private NaturalPersonName name;

  public static final String SERIALIZED_NAME_GEOGRAPHIC_ADDRESSES = "geographicAddress";
  @SerializedName(SERIALIZED_NAME_GEOGRAPHIC_ADDRESSES)
  private List<Address> geographicAddresses = null;

  public static final String SERIALIZED_NAME_NATIONAL_IDENTIFICATION = "nationalIdentification";
  @SerializedName(SERIALIZED_NAME_NATIONAL_IDENTIFICATION)
  private NationalIdentification nationalIdentification;

  public static final String SERIALIZED_NAME_CUSTOMER_IDENTIFICATION = "customerIdentification";
  @SerializedName(SERIALIZED_NAME_CUSTOMER_IDENTIFICATION)
  private String customerIdentification;

  public static final String SERIALIZED_NAME_DATE_AND_PLACE_OF_BIRTH = "dateAndPlaceOfBirth";
  @SerializedName(SERIALIZED_NAME_DATE_AND_PLACE_OF_BIRTH)
  private DateAndPlaceOfBirth dateAndPlaceOfBirth;

  public static final String SERIALIZED_NAME_COUNTRY_OF_RESIDENCE = "countryOfResidence";
  @SerializedName(SERIALIZED_NAME_COUNTRY_OF_RESIDENCE)
  private String countryOfResidence;


  public NaturalPerson name(NaturalPersonName name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public NaturalPersonName getName() {
    return name;
  }


  public void setName(NaturalPersonName name) {
    this.name = name;
  }


  public NaturalPerson geographicAddresses(List<Address> geographicAddresses) {
    
    this.geographicAddresses = geographicAddresses;
    return this;
  }

  public NaturalPerson addGeographicAddressesItem(Address geographicAddressesItem) {
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


  public NaturalPerson nationalIdentification(NationalIdentification nationalIdentification) {
    
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


  public NaturalPerson customerIdentification(String customerIdentification) {
    
    this.customerIdentification = customerIdentification;
    return this;
  }

   /**
   * Get customerIdentification
   * @return customerIdentification
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCustomerIdentification() {
    return customerIdentification;
  }


  public void setCustomerIdentification(String customerIdentification) {
    this.customerIdentification = customerIdentification;
  }


  public NaturalPerson dateAndPlaceOfBirth(DateAndPlaceOfBirth dateAndPlaceOfBirth) {
    
    this.dateAndPlaceOfBirth = dateAndPlaceOfBirth;
    return this;
  }

   /**
   * Get dateAndPlaceOfBirth
   * @return dateAndPlaceOfBirth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public DateAndPlaceOfBirth getDateAndPlaceOfBirth() {
    return dateAndPlaceOfBirth;
  }


  public void setDateAndPlaceOfBirth(DateAndPlaceOfBirth dateAndPlaceOfBirth) {
    this.dateAndPlaceOfBirth = dateAndPlaceOfBirth;
  }


  public NaturalPerson countryOfResidence(String countryOfResidence) {
    
    this.countryOfResidence = countryOfResidence;
    return this;
  }

   /**
   * Get countryOfResidence
   * @return countryOfResidence
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCountryOfResidence() {
    return countryOfResidence;
  }


  public void setCountryOfResidence(String countryOfResidence) {
    this.countryOfResidence = countryOfResidence;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NaturalPerson naturalPerson = (NaturalPerson) o;
    return Objects.equals(this.name, naturalPerson.name) &&
        Objects.equals(this.geographicAddresses, naturalPerson.geographicAddresses) &&
        Objects.equals(this.nationalIdentification, naturalPerson.nationalIdentification) &&
        Objects.equals(this.customerIdentification, naturalPerson.customerIdentification) &&
        Objects.equals(this.dateAndPlaceOfBirth, naturalPerson.dateAndPlaceOfBirth) &&
        Objects.equals(this.countryOfResidence, naturalPerson.countryOfResidence);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, geographicAddresses, nationalIdentification, customerIdentification, dateAndPlaceOfBirth, countryOfResidence);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NaturalPerson {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    geographicAddresses: ").append(toIndentedString(geographicAddresses)).append("\n");
    sb.append("    nationalIdentification: ").append(toIndentedString(nationalIdentification)).append("\n");
    sb.append("    customerIdentification: ").append(toIndentedString(customerIdentification)).append("\n");
    sb.append("    dateAndPlaceOfBirth: ").append(toIndentedString(dateAndPlaceOfBirth)).append("\n");
    sb.append("    countryOfResidence: ").append(toIndentedString(countryOfResidence)).append("\n");
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

