package com.Module11;

public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lasName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lasName;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public void setLasName(String lasName) {
        this.lastName = lasName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
