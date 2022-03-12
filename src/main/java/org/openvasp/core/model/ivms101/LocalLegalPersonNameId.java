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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * LocalLegalPersonNameId
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class LocalLegalPersonNameId {
  public static final String SERIALIZED_NAME_LEGAL_PERSON_NAME = "legalPersonName";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSON_NAME)
  private String legalPersonName;

  /**
   * Gets or Sets legalPersonNameIdentifierType
   */
  @JsonAdapter(LegalPersonNameIdentifierTypeEnum.Adapter.class)
  public enum LegalPersonNameIdentifierTypeEnum {
    LEGL("LEGL"),
    
    SHRT("SHRT"),
    
    TRAD("TRAD");

    private String value;

    LegalPersonNameIdentifierTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LegalPersonNameIdentifierTypeEnum fromValue(String value) {
      for (LegalPersonNameIdentifierTypeEnum b : LegalPersonNameIdentifierTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<LegalPersonNameIdentifierTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LegalPersonNameIdentifierTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LegalPersonNameIdentifierTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return LegalPersonNameIdentifierTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_LEGAL_PERSON_NAME_IDENTIFIER_TYPE = "legalPersonNameIdentifierType";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSON_NAME_IDENTIFIER_TYPE)
  private LegalPersonNameIdentifierTypeEnum legalPersonNameIdentifierType;


  public LocalLegalPersonNameId legalPersonName(String legalPersonName) {
    
    this.legalPersonName = legalPersonName;
    return this;
  }

   /**
   * Get legalPersonName
   * @return legalPersonName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getLegalPersonName() {
    return legalPersonName;
  }


  public void setLegalPersonName(String legalPersonName) {
    this.legalPersonName = legalPersonName;
  }


  public LocalLegalPersonNameId legalPersonNameIdentifierType(LegalPersonNameIdentifierTypeEnum legalPersonNameIdentifierType) {
    
    this.legalPersonNameIdentifierType = legalPersonNameIdentifierType;
    return this;
  }

   /**
   * Get legalPersonNameIdentifierType
   * @return legalPersonNameIdentifierType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public LegalPersonNameIdentifierTypeEnum getLegalPersonNameIdentifierType() {
    return legalPersonNameIdentifierType;
  }


  public void setLegalPersonNameIdentifierType(LegalPersonNameIdentifierTypeEnum legalPersonNameIdentifierType) {
    this.legalPersonNameIdentifierType = legalPersonNameIdentifierType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocalLegalPersonNameId localLegalPersonNameId = (LocalLegalPersonNameId) o;
    return Objects.equals(this.legalPersonName, localLegalPersonNameId.legalPersonName) &&
        Objects.equals(this.legalPersonNameIdentifierType, localLegalPersonNameId.legalPersonNameIdentifierType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(legalPersonName, legalPersonNameIdentifierType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocalLegalPersonNameId {\n");
    sb.append("    legalPersonName: ").append(toIndentedString(legalPersonName)).append("\n");
    sb.append("    legalPersonNameIdentifierType: ").append(toIndentedString(legalPersonNameIdentifierType)).append("\n");
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

