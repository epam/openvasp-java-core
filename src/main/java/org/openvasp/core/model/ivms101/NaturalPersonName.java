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


package org.openvasp.core.model.ivms101;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * NaturalPersonName
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@Entity
public class NaturalPersonName {
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public static final String SERIALIZED_NAME_NAME_IDENTIFIERS = "nameIdentifier";
  @SerializedName(SERIALIZED_NAME_NAME_IDENTIFIERS)
  @OneToMany(cascade = {CascadeType.ALL})
  @JoinColumn(name = "name_id")
  private List<NaturalPersonNameId> nameIdentifiers = null;

  public static final String SERIALIZED_NAME_LOCAL_NAME_IDENTIFIERS = "localNameIdentifier";
  @SerializedName(SERIALIZED_NAME_LOCAL_NAME_IDENTIFIERS)
  @OneToMany(cascade = {CascadeType.ALL})
  @JoinColumn(name = "local_name_id")
  private List<LocalNaturalPersonNameId> localNameIdentifiers = null;

  public static final String SERIALIZED_NAME_PHONETIC_NAME_IDENTIFIERS = "phoneticNameIdentifier";
  @SerializedName(SERIALIZED_NAME_PHONETIC_NAME_IDENTIFIERS)
  @OneToMany(cascade = {CascadeType.ALL})
  @JoinColumn(name = "phonetic_name_id")
  private List<LocalNaturalPersonNameId> phoneticNameIdentifiers = null;


  public NaturalPersonName nameIdentifiers(List<NaturalPersonNameId> nameIdentifiers) {
    
    this.nameIdentifiers = nameIdentifiers;
    return this;
  }

  public NaturalPersonName addNameIdentifiersItem(NaturalPersonNameId nameIdentifiersItem) {
    if (this.nameIdentifiers == null) {
      this.nameIdentifiers = new ArrayList<NaturalPersonNameId>();
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

  public List<NaturalPersonNameId> getNameIdentifiers() {
    return nameIdentifiers;
  }


  public void setNameIdentifiers(List<NaturalPersonNameId> nameIdentifiers) {
    this.nameIdentifiers = nameIdentifiers;
  }


  public NaturalPersonName localNameIdentifiers(List<LocalNaturalPersonNameId> localNameIdentifiers) {
    
    this.localNameIdentifiers = localNameIdentifiers;
    return this;
  }

  public NaturalPersonName addLocalNameIdentifiersItem(LocalNaturalPersonNameId localNameIdentifiersItem) {
    if (this.localNameIdentifiers == null) {
      this.localNameIdentifiers = new ArrayList<LocalNaturalPersonNameId>();
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

  public List<LocalNaturalPersonNameId> getLocalNameIdentifiers() {
    return localNameIdentifiers;
  }


  public void setLocalNameIdentifiers(List<LocalNaturalPersonNameId> localNameIdentifiers) {
    this.localNameIdentifiers = localNameIdentifiers;
  }


  public NaturalPersonName phoneticNameIdentifiers(List<LocalNaturalPersonNameId> phoneticNameIdentifiers) {
    
    this.phoneticNameIdentifiers = phoneticNameIdentifiers;
    return this;
  }

  public NaturalPersonName addPhoneticNameIdentifiersItem(LocalNaturalPersonNameId phoneticNameIdentifiersItem) {
    if (this.phoneticNameIdentifiers == null) {
      this.phoneticNameIdentifiers = new ArrayList<LocalNaturalPersonNameId>();
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

  public List<LocalNaturalPersonNameId> getPhoneticNameIdentifiers() {
    return phoneticNameIdentifiers;
  }


  public void setPhoneticNameIdentifiers(List<LocalNaturalPersonNameId> phoneticNameIdentifiers) {
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
    NaturalPersonName naturalPersonName = (NaturalPersonName) o;
    return Objects.equals(this.nameIdentifiers, naturalPersonName.nameIdentifiers) &&
        Objects.equals(this.localNameIdentifiers, naturalPersonName.localNameIdentifiers) &&
        Objects.equals(this.phoneticNameIdentifiers, naturalPersonName.phoneticNameIdentifiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nameIdentifiers, localNameIdentifiers, phoneticNameIdentifiers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NaturalPersonName {\n");
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

