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
 * BeneficiaryVasp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class BeneficiaryVasp {
  public static final String SERIALIZED_NAME_BENEFICIARY_VASP = "beneficiaryVASP";
  @SerializedName(SERIALIZED_NAME_BENEFICIARY_VASP)
  private Person beneficiaryVasp;


  public BeneficiaryVasp beneficiaryVasp(Person beneficiaryVasp) {
    
    this.beneficiaryVasp = beneficiaryVasp;
    return this;
  }

   /**
   * Get beneficiaryVasp
   * @return beneficiaryVasp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Person getBeneficiaryVasp() {
    return beneficiaryVasp;
  }


  public void setBeneficiaryVasp(Person beneficiaryVasp) {
    this.beneficiaryVasp = beneficiaryVasp;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BeneficiaryVasp beneficiaryVasp = (BeneficiaryVasp) o;
    return Objects.equals(this.beneficiaryVasp, beneficiaryVasp.beneficiaryVasp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(beneficiaryVasp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BeneficiaryVasp {\n");
    sb.append("    beneficiaryVasp: ").append(toIndentedString(beneficiaryVasp)).append("\n");
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

