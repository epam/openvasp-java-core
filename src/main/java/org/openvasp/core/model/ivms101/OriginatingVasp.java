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

/**
 * OriginatingVasp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class OriginatingVasp {
  public static final String SERIALIZED_NAME_ORIGINATING_VASP = "originatingVASP2";
  @SerializedName(SERIALIZED_NAME_ORIGINATING_VASP)
  private Person originatingVasp;


  public OriginatingVasp originatingVasp(Person originatingVasp) {
    
    this.originatingVasp = originatingVasp;
    return this;
  }

   /**
   * Get originatingVasp
   * @return originatingVasp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Person getOriginatingVasp() {
    return originatingVasp;
  }


  public void setOriginatingVasp(Person originatingVasp) {
    this.originatingVasp = originatingVasp;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OriginatingVasp originatingVasp = (OriginatingVasp) o;
    return Objects.equals(this.originatingVasp, originatingVasp.originatingVasp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originatingVasp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OriginatingVasp {\n");
    sb.append("    originatingVasp: ").append(toIndentedString(originatingVasp)).append("\n");
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
