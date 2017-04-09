package org.stpaul.model;

import org.stpaul.configuration.TransactionalEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "GUEST")
public class Guest extends TransactionalEntity {
    @Column(name = "FIRST_NAME")
    //@NotNull
    private String firstName;

    @Column(name = "LAST_NAME")
    //@NotNull
    private String lastName;

    @Column(name = "STATE")
    //@NotNull
    private String state;

    @Column(name = "CITY")
    //@NotNull
    private String city;

    @Column(name = "ZIP_CODE")
    //@NotNull
    private Long zipCode;

    @Column(name = "ADDRESS")
    //@NotNull
    private String address;

    @Column(name = "PHONE_NUMBER")
    //@NotNull
    private Long phoneNumber;

    @Column(name = "HOME_CHURCH")
    //@NotNull
    private String homeChurch;

    @Column(name = "COMMUNION_DATE")
    //@NotNull
    private String communionDate;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomeChurch() {
        return homeChurch;
    }

    public void setHomeChurch(String homeChurch) {
        this.homeChurch = homeChurch;
    }

    public String getCommunionDate() {
        return communionDate;
    }

    public void setCommunionDate(String communionDate) {
        this.communionDate = communionDate;
    }
}
