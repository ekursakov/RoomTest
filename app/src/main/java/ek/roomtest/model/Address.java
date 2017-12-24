package ek.roomtest.model;

public class Address {
    public String city;
    public String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
               "city='" + city + '\'' +
               ", street='" + street + '\'' +
               '}';
    }
}
