package com.scrolltest.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"first name",
"last name",
"age",
"id",
"Address",
"Gender"
})
public class Person {

@JsonProperty("first name")
private String firstName;
@JsonProperty("last name")
private String lastName;
@JsonProperty("age")
private Integer age;
@JsonProperty("id")
private Integer id;
@JsonProperty("Address")
private String address;
@JsonProperty("Gender")
private String gender;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("first name")
public String getFirstName() {
return firstName;
}

@JsonProperty("first name")
public void setFirstName(String firstName) {
this.firstName = firstName;
}

@JsonProperty("last name")
public String getLastName() {
return lastName;
}

@JsonProperty("last name")
public void setLastName(String lastName) {
this.lastName = lastName;
}

@JsonProperty("age")
public Integer getAge() {
return age;
}

@JsonProperty("age")
public void setAge(Integer age) {
this.age = age;
}

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("Address")
public String getAddress() {
return address;
}

@JsonProperty("Address")
public void setAddress(String address) {
this.address = address;
}

@JsonProperty("Gender")
public String getGender() {
return gender;
}

@JsonProperty("Gender")
public void setGender(String gender) {
this.gender = gender;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}