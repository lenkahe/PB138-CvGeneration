package cz.muni.fi.pb138.cvGeneration.service.entity.item;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by galbavyj on 13.05.2016.
 */

@XmlType(propOrder={"pretitle", "firstName", "lastName", "postTitle", "address","phones", "emails"})
public class PersonalInfo {

    private String pretitle;
    private String firstName;
    private String lastName;
    private String postTitle;
    private Address address;
    private List<String> phones;
    private List<String> emails;

    public String getPretitle() {
        return pretitle;
    }


    @XmlElement
    public void setPretitle(String pretitle) {
        this.pretitle = pretitle;
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
        return pretitle + firstName + " " + lastName + postTitle + "\n" +
                address.toString() + "\n" +
                phones + emails + "\n";
    }
}
