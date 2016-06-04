package cz.muni.fi.pb138.cvGeneration.entity;

import cz.muni.fi.pb138.cvGeneration.entity.item.*;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Personal information
 *
 * @author Lenka Heldova, galbavyj
 */

@XmlRootElement
@XmlType(propOrder={"personalInfo", "employments","education",
        "languages", "skills", "certificates", "hobbies"})
public class Person {

    private PersonalInfo personalInfo;
    private List<String> certificates;
    private List<String> hobbies;
    private List<Employment> employments;
    private List<Education> education;
    private List<Language> languages;
    private List<Skill> skills;
    private String userLogin;

    public Person() {
    }

    public String getUserLogin() {
        return userLogin;
    }

    @XmlAttribute
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
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

    public List<Employment> getEmployments() {
        return employments;
    }

    @XmlElementWrapper(name = "employments")
    @XmlElement(name = "employment")
    public void setEmployments(List<Employment> employments) {
        this.employments = employments;
    }

    public List<Education> getEducation() {
        return education;
    }

    @XmlElementWrapper
    @XmlElement(name = "school")
    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    @XmlElementWrapper
    @XmlElement(name = "language")
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    @XmlElementWrapper
    @XmlElement(name = "skill")
    public void setSkills(List<Skill> skills) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!getPersonalInfo().equals(person.getPersonalInfo())) return false;
        if (getCertificates() != null ? !getCertificates().equals(person.getCertificates()) : person.getCertificates() != null)
            return false;
        if (getHobbies() != null ? !getHobbies().equals(person.getHobbies()) : person.getHobbies() != null)
            return false;
        if (getEmployments() != null ? !getEmployments().equals(person.getEmployments()) : person.getEmployments() != null)
            return false;
        if (getEducation() != null ? !getEducation().equals(person.getEducation()) : person.getEducation() != null)
            return false;
        if (getLanguages() != null ? !getLanguages().equals(person.getLanguages()) : person.getLanguages() != null)
            return false;
        return getSkills() != null ? getSkills().equals(person.getSkills()) : person.getSkills() == null;

    }

    @Override
    public int hashCode() {
        int result = getPersonalInfo().hashCode();
        result = 31 * result + (getCertificates() != null ? getCertificates().hashCode() : 0);
        result = 31 * result + (getHobbies() != null ? getHobbies().hashCode() : 0);
        result = 31 * result + (getEmployments() != null ? getEmployments().hashCode() : 0);
        result = 31 * result + (getEducation() != null ? getEducation().hashCode() : 0);
        result = 31 * result + (getLanguages() != null ? getLanguages().hashCode() : 0);
        result = 31 * result + (getSkills() != null ? getSkills().hashCode() : 0);
        return result;
    }
}
