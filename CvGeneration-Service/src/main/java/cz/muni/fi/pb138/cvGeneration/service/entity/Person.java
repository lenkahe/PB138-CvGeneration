package cz.muni.fi.pb138.cvGeneration.service.entity;

import cz.muni.fi.pb138.cvGeneration.service.entity.item.Education;
import cz.muni.fi.pb138.cvGeneration.service.entity.item.Employments;
import cz.muni.fi.pb138.cvGeneration.service.entity.item.Languages;
import cz.muni.fi.pb138.cvGeneration.service.entity.item.Skills;

import java.util.List;

/**
 * Personal information
 *
 * @author Lenka Heldova
 */
public class Person {
    private String pretitle;
    private String firstName;
    private String lastName;
    private String postTitle;
    private String street;
    private String city;
    private String postalCode;
    private String passwordHash;
    private List<String> phones;
    private List<String> emails;
    private List<String> certificates;
    private List<String> hobbies;
    private List<Employments> employments;
    private List<Education> education;
    private List<Languages> languages;
    private List<Skills> skills;

    public String getPretitle() {
        return pretitle;
    }

    public void setPretitle(String pretitle) {
        this.pretitle = pretitle;
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

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Employments> getEmployments() {
        return employments;
    }

    public void setEmployments(List<Employments> employments) {
        this.employments = employments;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }
}
