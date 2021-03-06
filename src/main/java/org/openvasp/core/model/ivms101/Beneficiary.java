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

import java.util.ArrayList;
import java.util.List;

/**
 * Beneficiary
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Beneficiary {
  public static final String SERIALIZED_NAME_BENEFICIARY_PERSONS = "beneficiaryPersons";
  @SerializedName(SERIALIZED_NAME_BENEFICIARY_PERSONS)
  private List<Person> beneficiaryPersons = null;

  public static final String SERIALIZED_NAME_ACCOUNT_NUMBERS = "accountNumber";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBERS)
  private List<String> accountNumbers = null;


  public Beneficiary beneficiaryPersons(List<Person> beneficiaryPersons) {
    
    this.beneficiaryPersons = beneficiaryPersons;
    return this;
  }

  public Beneficiary addBeneficiaryPersonsItem(Person beneficiaryPersonsItem) {
    if (this.beneficiaryPersons == null) {
      this.beneficiaryPersons = new ArrayList<Person>();
    }
    this.beneficiaryPersons.add(beneficiaryPersonsItem);
    return this;
  }

   /**
   * Get beneficiaryPersons
   * @return beneficiaryPersons
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Person> getBeneficiaryPersons() {
    return beneficiaryPersons;
  }


  public void setBeneficiaryPersons(List<Person> beneficiaryPersons) {
    this.beneficiaryPersons = beneficiaryPersons;
  }


  public Beneficiary accountNumbers(List<String> accountNumbers) {
    
    this.accountNumbers = accountNumbers;
    return this;
  }

  public Beneficiary addAccountNumbersItem(String accountNumbersItem) {
    if (this.accountNumbers == null) {
      this.accountNumbers = new ArrayList<String>();
    }
    this.accountNumbers.add(accountNumbersItem);
    return this;
  }

   /**
   * Get accountNumbers
   * @return accountNumbers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getAccountNumbers() {
    return accountNumbers;
  }


  public void setAccountNumbers(List<String> accountNumbers) {
    this.accountNumbers = accountNumbers;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Beneficiary beneficiary = (Beneficiary) o;
    return Objects.equals(this.beneficiaryPersons, beneficiary.beneficiaryPersons) &&
        Objects.equals(this.accountNumbers, beneficiary.accountNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(beneficiaryPersons, accountNumbers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Beneficiary {\n");
    sb.append("    beneficiaryPersons: ").append(toIndentedString(beneficiaryPersons)).append("\n");
    sb.append("    accountNumbers: ").append(toIndentedString(accountNumbers)).append("\n");
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

