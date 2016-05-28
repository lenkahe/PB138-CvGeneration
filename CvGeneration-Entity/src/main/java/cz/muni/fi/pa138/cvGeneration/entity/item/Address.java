package cz.muni.fi.pa138.cvGeneration.entity.item;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by galbavyj on 13.05.2016.
 */
@XmlType(propOrder={"street", "city", "postalCode"})
public class Address {

    private String street;
    private String city;
    private String postalCode;

    public Address(String street, String city, String postalCode){
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Address(){}


    public String getStreet() {
        return street;
    }

    @XmlElement
    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    @XmlElement
    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @XmlElement
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        return postalCode != null ? postalCode.equals(address.postalCode) : address.postalCode == null;

    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return street + " " + city  + " " + postalCode;
    }
}
