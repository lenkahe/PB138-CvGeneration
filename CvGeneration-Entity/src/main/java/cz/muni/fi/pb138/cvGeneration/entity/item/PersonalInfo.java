package cz.muni.fi.pb138.cvGeneration.entity.item;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Personal information of person
 *
 * @author galbavyj
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

    public PersonalInfo() {
    }


    public PersonalInfo(Map<String, String[]> htmlParams) {
        Address address = new Address();
        address.setStreet(getStringValue(htmlParams, "street"));
        address.setCity(getStringValue(htmlParams, "city"));
        address.setPostalCode(getStringValue(htmlParams, "postal-code"));
        this.setPreTitle(getStringValue(htmlParams, "pre-title"));
        this.setFirstName(getStringValue(htmlParams, "first-name"));
        this.setLastName(getStringValue(htmlParams, "last-name"));
        this.setPostTitle(getStringValue(htmlParams, "post-title"));
        this.setAddress(address);
        this.setPhones(getListValue(htmlParams, "phone"));
        this.setEmails(getListValue(htmlParams, "email"));
    }


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


    private String getStringValue(Map<String, String[]> params, String key){
        if (params.containsKey(key)) {
            return params.get(key)[0];
        }
        return null;
    }
    private List<String> getListValue(Map<String, String[]> params, String key){
        String[] values;
        List<String> dataList = new ArrayList<String>();

        for(String s: params.keySet()){
            if(s.startsWith(key)){
                values = params.get(s);
                for(String str : values) {
                    if (str != null && str.length() > 0) {
                        dataList.add(str);
                    }
                }
            }
        }
        return dataList;
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
