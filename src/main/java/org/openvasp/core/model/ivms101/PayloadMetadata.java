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
import java.util.ArrayList;
import java.util.List;

/**
 * PayloadMetadata
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class PayloadMetadata {
  /**
   * Gets or Sets transliterationMethod
   */
  @JsonAdapter(TransliterationMethodEnum.Adapter.class)
  public enum TransliterationMethodEnum {
    ARAB("ARAB"),
    
    ARAN("ARAN"),
    
    ARMN("ARMN"),
    
    CYRL("CYRL"),
    
    DEVA("DEVA"),
    
    GEOR("GEOR"),
    
    GREK("GREK"),
    
    HANI("HANI"),
    
    HEBR("HEBR"),
    
    KANA("KANA"),
    
    KORE("KORE"),
    
    THAI("THAI"),
    
    OTHR("OTHR");

    private String value;

    TransliterationMethodEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TransliterationMethodEnum fromValue(String value) {
      for (TransliterationMethodEnum b : TransliterationMethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TransliterationMethodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TransliterationMethodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TransliterationMethodEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TransliterationMethodEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TRANSLITERATION_METHOD = "transliteration_method";
  @SerializedName(SERIALIZED_NAME_TRANSLITERATION_METHOD)
  private List<TransliterationMethodEnum> transliterationMethod = null;


  public PayloadMetadata transliterationMethod(List<TransliterationMethodEnum> transliterationMethod) {
    
    this.transliterationMethod = transliterationMethod;
    return this;
  }

  public PayloadMetadata addTransliterationMethodItem(TransliterationMethodEnum transliterationMethodItem) {
    if (this.transliterationMethod == null) {
      this.transliterationMethod = new ArrayList<TransliterationMethodEnum>();
    }
    this.transliterationMethod.add(transliterationMethodItem);
    return this;
  }

   /**
   * Get transliterationMethod
   * @return transliterationMethod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<TransliterationMethodEnum> getTransliterationMethod() {
    return transliterationMethod;
  }


  public void setTransliterationMethod(List<TransliterationMethodEnum> transliterationMethod) {
    this.transliterationMethod = transliterationMethod;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayloadMetadata payloadMetadata = (PayloadMetadata) o;
    return Objects.equals(this.transliterationMethod, payloadMetadata.transliterationMethod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transliterationMethod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayloadMetadata {\n");
    sb.append("    transliterationMethod: ").append(toIndentedString(transliterationMethod)).append("\n");
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

