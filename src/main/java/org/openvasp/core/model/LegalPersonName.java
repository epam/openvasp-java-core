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
 * LegalPersonName
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-05T14:32:36.025401+02:00[Europe/Kiev]")
public class LegalPersonName {
  public static final String SERIALIZED_NAME_NAME_IDENTIFIERS = "nameIdentifiers";
  @SerializedName(SERIALIZED_NAME_NAME_IDENTIFIERS)
  private List<LegalPersonNameId> nameIdentifiers = null;

  public static final String SERIALIZED_NAME_LOCAL_NAME_IDENTIFIERS = "localNameIdentifier";
  @SerializedName(SERIALIZED_NAME_LOCAL_NAME_IDENTIFIERS)
  private List<LocalLegalPersonNameId> localNameIdentifiers = null;

  public static final String SERIALIZED_NAME_PHONETIC_NAME_IDENTIFIERS = "phoneticNameIdentifiers";
  @SerializedName(SERIALIZED_NAME_PHONETIC_NAME_IDENTIFIERS)
  private List<LocalLegalPersonNameId> phoneticNameIdentifiers = null;


  public LegalPersonName nameIdentifiers(List<LegalPersonNameId> nameIdentifiers) {
    
    this.nameIdentifiers = nameIdentifiers;
    return this;
  }

  public LegalPersonName addNameIdentifiersItem(LegalPersonNameId nameIdentifiersItem) {
    if (this.nameIdentifiers == null) {
      this.nameIdentifiers = new ArrayList<LegalPersonNameId>();
    }
    this.nameIdentifiers.add(nameIdentifiersItem);
    return this;
  }

   /**
   * Get nameIdentifiers
   * @return nameIdentifiers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<LegalPersonNameId> getNameIdentifiers() {
    return nameIdentifiers;
  }


  public void setNameIdentifiers(List<LegalPersonNameId> nameIdentifiers) {
    this.nameIdentifiers = nameIdentifiers;
  }


  public LegalPersonName localNameIdentifiers(List<LocalLegalPersonNameId> localNameIdentifiers) {
    
    this.localNameIdentifiers = localNameIdentifiers;
    return this;
  }

  public LegalPersonName addLocalNameIdentifiersItem(LocalLegalPersonNameId localNameIdentifiersItem) {
    if (this.localNameIdentifiers == null) {
      this.localNameIdentifiers = new ArrayList<LocalLegalPersonNameId>();
    }
    this.localNameIdentifiers.add(localNameIdentifiersItem);
    return this;
  }

   /**
   * Get localNameIdentifiers
   * @return localNameIdentifiers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<LocalLegalPersonNameId> getLocalNameIdentifiers() {
    return localNameIdentifiers;
  }


  public void setLocalNameIdentifiers(List<LocalLegalPersonNameId> localNameIdentifiers) {
    this.localNameIdentifiers = localNameIdentifiers;
  }


  public LegalPersonName phoneticNameIdentifiers(List<LocalLegalPersonNameId> phoneticNameIdentifiers) {
    
    this.phoneticNameIdentifiers = phoneticNameIdentifiers;
    return this;
  }

  public LegalPersonName addPhoneticNameIdentifiersItem(LocalLegalPersonNameId phoneticNameIdentifiersItem) {
    if (this.phoneticNameIdentifiers == null) {
      this.phoneticNameIdentifiers = new ArrayList<LocalLegalPersonNameId>();
    }
    this.phoneticNameIdentifiers.add(phoneticNameIdentifiersItem);
    return this;
  }

   /**
   * Get phoneticNameIdentifiers
   * @return phoneticNameIdentifiers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<LocalLegalPersonNameId> getPhoneticNameIdentifiers() {
    return phoneticNameIdentifiers;
  }


  public void setPhoneticNameIdentifiers(List<LocalLegalPersonNameId> phoneticNameIdentifiers) {
    this.phoneticNameIdentifiers = phoneticNameIdentifiers;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LegalPersonName legalPersonName = (LegalPersonName) o;
    return Objects.equals(this.nameIdentifiers, legalPersonName.nameIdentifiers) &&
        Objects.equals(this.localNameIdentifiers, legalPersonName.localNameIdentifiers) &&
        Objects.equals(this.phoneticNameIdentifiers, legalPersonName.phoneticNameIdentifiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nameIdentifiers, localNameIdentifiers, phoneticNameIdentifiers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LegalPersonName {\n");
    sb.append("    nameIdentifiers: ").append(toIndentedString(nameIdentifiers)).append("\n");
    sb.append("    localNameIdentifiers: ").append(toIndentedString(localNameIdentifiers)).append("\n");
    sb.append("    phoneticNameIdentifiers: ").append(toIndentedString(phoneticNameIdentifiers)).append("\n");
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
