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

/**
 * Person
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-05T14:32:36.025401+02:00[Europe/Kiev]")
public class Person {
  public static final String SERIALIZED_NAME_NATURAL_PERSON = "naturalPerson";
  @SerializedName(SERIALIZED_NAME_NATURAL_PERSON)
  private NaturalPerson naturalPerson;

  public static final String SERIALIZED_NAME_LEGAL_PERSON = "legalPerson";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSON)
  private LegalPerson legalPerson;


  public Person naturalPerson(NaturalPerson naturalPerson) {
    
    this.naturalPerson = naturalPerson;
    return this;
  }

   /**
   * Get naturalPerson
   * @return naturalPerson
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public NaturalPerson getNaturalPerson() {
    return naturalPerson;
  }


  public void setNaturalPerson(NaturalPerson naturalPerson) {
    this.naturalPerson = naturalPerson;
  }


  public Person legalPerson(LegalPerson legalPerson) {
    
    this.legalPerson = legalPerson;
    return this;
  }

   /**
   * Get legalPerson
   * @return legalPerson
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public LegalPerson getLegalPerson() {
    return legalPerson;
  }


  public void setLegalPerson(LegalPerson legalPerson) {
    this.legalPerson = legalPerson;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(this.naturalPerson, person.naturalPerson) &&
        Objects.equals(this.legalPerson, person.legalPerson);
  }

  @Override
  public int hashCode() {
    return Objects.hash(naturalPerson, legalPerson);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    sb.append("    naturalPerson: ").append(toIndentedString(naturalPerson)).append("\n");
    sb.append("    legalPerson: ").append(toIndentedString(legalPerson)).append("\n");
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

