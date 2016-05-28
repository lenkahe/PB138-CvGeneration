package cz.muni.fi.pb138.cvGeneration.persistence.entity.item;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by galbavyj on 13.05.2016.
 */

@XmlType(propOrder={"preTitle", "firstName", "lastName", "postTitle", "address","phones", "emails"})
public class PersonalInfo {

    private String preTitle;
    private String firstName;
    private String lastName;
    private String postTitle;
    private Address address;
    private List<String> phones;
    private List<String> emails;


    public PersonalInfo(String preTitle, String firstName, String lastName, String postTitle,
                        Address address, List<String> phones, List<String> emails) {
        if(preTitle != null) this.preTitle = preTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        if(postTitle != null) this.postTitle = postTitle;
        this.address = address;
        this.phones = phones;
        this.emails = emails;
    }


    public PersonalInfo() {
    }

    public String getPreTitle() {
        return preTitle;
    }


    @XmlElement
    public void setPreTitle(String preTitle) {
        this.preTitle = preTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostTitle() {
        return postTitle;
    }

    @XmlElement
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public List<String> getPhones() {
        return phones;
    }

    @XmlElement
    public void setAddress(Address address) { this.address = address; }

    public Address getAddress() { return address; }


    @XmlElementWrapper
    @XmlElement(name = "phone")
    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<String> getEmails() {
        return emails;
    }


    @XmlElementWrapper
    @XmlElement(name = "email")
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return preTitle + firstName + " " + lastName + postTitle + "\n" +
                address.toString() + "\n" +
                phones + emails + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalInfo)) return false;

        PersonalInfo that = (PersonalInfo) o;

        if (getPreTitle() != null ? !getPreTitle().equals(that.getPreTitle()) : that.getPreTitle() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
            return false;
        if (getPostTitle() != null ? !getPostTitle().equals(that.getPostTitle()) : that.getPostTitle() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(that.getAddress()) : that.getAddress() != null) return false;
        if (getPhones() != null ? !getPhones().equals(that.getPhones()) : that.getPhones() != null) return false;
        return getEmails() != null ? getEmails().equals(that.getEmails()) : that.getEmails() == null;

    }

    @Override
    public int hashCode() {
        int result = getPreTitle() != null ? getPreTitle().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getPostTitle() != null ? getPostTitle().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getPhones() != null ? getPhones().hashCode() : 0);
        result = 31 * result + (getEmails() != null ? getEmails().hashCode() : 0);
        return result;
    }
}
