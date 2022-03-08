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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * NaturalPersonNameId
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-05T14:32:36.025401+02:00[Europe/Kiev]")
public class NaturalPersonNameId {
  public static final String SERIALIZED_NAME_PRIMARY_IDENTIFIER = "primaryIdentifier";
  @SerializedName(SERIALIZED_NAME_PRIMARY_IDENTIFIER)
  private String primaryIdentifier;

  public static final String SERIALIZED_NAME_SECONDARY_IDENTIFIER = "secondaryIdentifier";
  @SerializedName(SERIALIZED_NAME_SECONDARY_IDENTIFIER)
  private String secondaryIdentifier;

  /**
   * Gets or Sets nameIdentifierType
   */
  @JsonAdapter(NameIdentifierTypeEnum.Adapter.class)
  public enum NameIdentifierTypeEnum {
    ALIA("ALIA"),
    
    BIRT("BIRT"),
    
    MAID("MAID"),
    
    LEGL("LEGL"),
    
    MISC("MISC");

    private String value;

    NameIdentifierTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static NameIdentifierTypeEnum fromValue(String value) {
      for (NameIdentifierTypeEnum b : NameIdentifierTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<NameIdentifierTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final NameIdentifierTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public NameIdentifierTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return NameIdentifierTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_NAME_IDENTIFIER_TYPE = "nameIdentifierType";
  @SerializedName(SERIALIZED_NAME_NAME_IDENTIFIER_TYPE)
  private NameIdentifierTypeEnum nameIdentifierType;


  public NaturalPersonNameId primaryIdentifier(String primaryIdentifier) {
    
    this.primaryIdentifier = primaryIdentifier;
    return this;
  }

   /**
   * Get primaryIdentifier
   * @return primaryIdentifier
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getPrimaryIdentifier() {
    return primaryIdentifier;
  }


  public void setPrimaryIdentifier(String primaryIdentifier) {
    this.primaryIdentifier = primaryIdentifier;
  }


  public NaturalPersonNameId secondaryIdentifier(String secondaryIdentifier) {
    
    this.secondaryIdentifier = secondaryIdentifier;
    return this;
  }

   /**
   * Get secondaryIdentifier
   * @return secondaryIdentifier
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSecondaryIdentifier() {
    return secondaryIdentifier;
  }


  public void setSecondaryIdentifier(String secondaryIdentifier) {
    this.secondaryIdentifier = secondaryIdentifier;
  }


  public NaturalPersonNameId nameIdentifierType(NameIdentifierTypeEnum nameIdentifierType) {
    
    this.nameIdentifierType = nameIdentifierType;
    return this;
  }

   /**
   * Get nameIdentifierType
   * @return nameIdentifierType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public NameIdentifierTypeEnum getNameIdentifierType() {
    return nameIdentifierType;
  }


  public void setNameIdentifierType(NameIdentifierTypeEnum nameIdentifierType) {
    this.nameIdentifierType = nameIdentifierType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NaturalPersonNameId naturalPersonNameId = (NaturalPersonNameId) o;
    return Objects.equals(this.primaryIdentifier, naturalPersonNameId.primaryIdentifier) &&
        Objects.equals(this.secondaryIdentifier, naturalPersonNameId.secondaryIdentifier) &&
        Objects.equals(this.nameIdentifierType, naturalPersonNameId.nameIdentifierType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(primaryIdentifier, secondaryIdentifier, nameIdentifierType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NaturalPersonNameId {\n");
    sb.append("    primaryIdentifier: ").append(toIndentedString(primaryIdentifier)).append("\n");
    sb.append("    secondaryIdentifier: ").append(toIndentedString(secondaryIdentifier)).append("\n");
    sb.append("    nameIdentifierType: ").append(toIndentedString(nameIdentifierType)).append("\n");
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

