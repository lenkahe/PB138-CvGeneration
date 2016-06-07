package cz.muni.fi.pb138.cvGeneration.entity;

import cz.muni.fi.pb138.cvGeneration.entity.item.*;

import javax.xml.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    private List<String> setListValueFromMap(Map<String, String[]> params, String key){
        String[] values;
        List<String> dataList = new ArrayList<String>();

        for(String s: params.keySet()){
            if(s.startsWith(key)){
                values = params.get(s);
                dataList.addAll(Arrays.asList(values));
            }
        }
        return dataList;
    }

    private void setLangValueFromMap(Map<String, String[]> params,
                                     String key, String key2){

        List<Language> languages = new ArrayList<Language>();

        List<String> languageNames = setListValueFromMap(params, key);
        List<String> levels = setListValueFromMap(params, key2);

        for (int i = 0; i < languageNames.size(); i++ ) {
            if (languageNames.get(i).length() > 0) {
                languages.add(new Language(languageNames.get(i), levels.get(i)));
            }

        }
        if (languages.size() > 0) {
            this.setLanguages(languages);
        } else{
            this.setLanguages(null);
        }

    }

    private void setSkillValueFromMap(Map<String, String[]> params,
                                      String key, String key2){

        List<Skill> skills = new ArrayList<Skill>();

        List<String> skillNames = setListValueFromMap(params, key);
        List<String> levels = setListValueFromMap(params, key2);

        for (int i = 0; i < skillNames.size(); i++ ) {
            if (skillNames.get(i).length() > 0) {
                skills.add(new Skill(skillNames.get(i), levels.get(i)));
            }
        }
        if(skills.size() > 0) {
            this.setSkills(skills);
        } else{
            this.setSkills(null);
        }

    }

    private void setEducationValueFromMap (Map<String, String[]> params, String key) {
        List<Education> edu = new ArrayList<>();

        List<String> schools = setListValueFromMap(params, key + "name" );
        List<String> fieldsOfStudy = setListValueFromMap(params, key + "fieldOfStudy" );
        List<String> since = setListValueFromMap(params, key + "since" );
        List<String> to = setListValueFromMap(params, key + "to" );
        List<String> grades = setListValueFromMap(params, key + "grade" );


        for (int i = 0; i < schools.size(); i++ ) {
            if (schools.get(i).length() > 0) {
                edu.add(new Education(schools.get(i), fieldsOfStudy.get(i), grades.get(i), since.get(i), to.get(i)));
            }
        }
        if (edu.size() > 0) {
            this.setEducation(edu);
        } else{
            this.setEducation(null);
        }

    }

    private void setEmploymentValueFromMap (Map<String, String[]> params, String key) {
        List<Employment> emp = new ArrayList<>();

        List<String> companies  = setListValueFromMap(params, key + "nameC" );
        List<String> positions = setListValueFromMap(params, key + "position" );
        List<String> since = setListValueFromMap(params, key + "sinceC" );
        List<String> to = setListValueFromMap(params, key + "toC" );
        List<String> notes = setListValueFromMap(params, key + "note" );


        for (int i = 0; i < companies.size(); i++ ) {
            if (companies.get(i).length() > 0) {
                emp.add(new Employment(companies.get(i), positions.get(i), since.get(i), to.get(i), notes.get(i)));
            }
        }
        if (emp.size() > 0) {
            this.setEmployments(emp);
        } else{
            this.setEmployments(null);
        }

    }

    public void setAdditionalInfo (Map <String, String[]> params) {
        setSkillValueFromMap(params, "s_skill", "s_level");
        setLangValueFromMap(params, "l_language", "l_level");
        setEducationValueFromMap(params, "e_");
        setEmploymentValueFromMap(params, "c_");

        List <String> certificates = setListValueFromMap(params, "certificate");
        certificates.removeAll(Arrays.asList("", null));
        if (certificates.size() > 0) {
            setCertificates(certificates);
        } else {
            setCertificates(null);
        }
        List <String> hobbies = setListValueFromMap(params, "hobbies");
        hobbies.removeAll(Arrays.asList("", null));
        if (hobbies.size() > 0) {
            setHobbies(hobbies);
        } else {
            setHobbies(null);
        }

    }

}
