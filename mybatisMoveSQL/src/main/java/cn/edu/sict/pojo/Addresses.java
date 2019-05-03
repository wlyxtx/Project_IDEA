package cn.edu.sict.pojo;

import java.io.Serializable;

public class Addresses implements Serializable {
    private Integer addrid;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Addresses() {
    }

    public Addresses( String street, String city, String state, String zip, String country,Integer addrid) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.addrid = addrid;
    }

    public Integer getAddrid() {
        return addrid;
    }

    public void setAddrid(Integer addrid) {
        this.addrid = addrid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "addrid=" + addrid +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
