package cz.muni.fi.pb138.cvGeneration.persistence.entity;

import cz.muni.fi.pb138.cvGeneration.persistence.entity.item.*;

import javax.xml.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Personal information
 *
 * @author Lenka Heldova
 */

@XmlRootElement
@XmlType(propOrder={"personalInfo","passwordHash", "employments","education",
        "languages", "skills", "certificates", "hobbies"})
public class Person {

    private PersonalInfo personalInfo;
    private String passwordHash;
    private List<String> certificates;
    private List<String> hobbies;
    private List<Employments> employments;
    private List<Education> education;
    private List<Languages> languages;
    private List<Skills> skills;

    public static DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    public String getPasswordHash() {
        return passwordHash;
    }

    @XmlAttribute
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }




    public List<String> getCertificates() {
        return certificates;
    }

    @XmlElementWrapper
    @XmlElement(name = "certificate")
    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    @XmlElementWrapper
    @XmlElement(name = "hobby")
    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Employments> getEmployments() {
        return employments;
    }

    @XmlElementWrapper
    @XmlElement(name = "employment")
    public void setEmployments(List<Employments> employments) {
        this.employments = employments;
    }

    public List<Education> getEducation() {
        return education;
    }

    @XmlElementWrapper
    @XmlElement(name = "employment")
    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    @XmlElementWrapper
    @XmlElement(name = "language")
    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    @XmlElementWrapper
    @XmlElement(name = "skill")
    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }


    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    @Override
    public String toString() {
        return personalInfo.toString() + employments.toString();
    }
}
