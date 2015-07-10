package com.springapp.mvc.Person;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class Person {

    @Size(min=5, max=30)
    private String firstName;

    @Size(min=2, max=30)

    private String lastName;

    @NotEmpty @Email
//    @JsonIgnore
    private String email;

    @NotNull @Size(min=10, max=100)
//    @JsonIgnore
    private String comments;

//    private List<String> pastComments;


    public Person() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


//    public List<String> getPastComments() {
//        return pastComments;
//    }
//
//    public void setPastComments(List<String> pastComments) {
//        this.pastComments = pastComments;
//    }
//
//    public void addPastComments(String comments){
//        this.pastComments.add(comments);
//    }

    public String toString(){
        return "Person [ firstName =" + firstName + ", lastName = " + lastName + ", Email =" + email + ", Comments = " + comments +"]";
    }



}
