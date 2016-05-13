package cz.muni.fi.pb138.cvGeneration.service.jaxb;

import cz.muni.fi.pb138.cvGeneration.persistence.dao.CvDaoImpl;
import cz.muni.fi.pb138.cvGeneration.persistence.entity.Person;
import cz.muni.fi.pb138.cvGeneration.persistence.entity.item.*;


import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

/**
 * Temporery class used for testing XMLConverter
 *
 * Created by galbavyj on 13.05.2016.
 */
public class XMLTry {


    public static void main(String[] args) throws ParseException {



        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat formatyear = new SimpleDateFormat("yyyy");


        Employments emp1 = new Employments();
        Employments emp2 = new Employments();
        Education edu1 = new Education();
        Education edu2 = new Education();
        Languages lang1 = new Languages();
        Languages lang2 = new Languages();
        Skills sk1 = new Skills();
        Skills sk2 = new Skills();
        Address address = new Address();

        List<Employments> employments = new ArrayList<>();
        List<Education> educations = new ArrayList<>();
        List<Languages> languages = new ArrayList<>();
        List<Skills> skills = new ArrayList<>();
        List<String> mails = new ArrayList<>();
        List<String> phones = new ArrayList<>();
        List<String> certificates = new ArrayList<>();
        List<String> hobbies = new ArrayList<>();
        PersonalInfo personalInfo = new PersonalInfo();


        edu2.setSchoolName("FI MUNI");
        edu2.setDateStart(formatyear.parse("2011"));
        edu2.setDegree("1");

        edu1.setSchoolName("SOŠ Spišská Nová Ves");
        edu1.setDateStart(formatyear.parse("1994"));
        edu1.setDateEnd(formatyear.parse("2000"));

        lang1.setLanguage("English");
        lang1.setLevel("advanced");

        lang2.setLanguage("Slovak");
        lang2.setLevel("native");

        sk1.setSkillName("XML");
        sk1.setLevel("advanced");

        sk2.setSkillName("Windows");
        sk2.setLevel("basic");


        emp1.setCompany("Portos.sro");
        emp1.setDateStart(format.parse("12.11.1994"));
        emp1.setDateEnd(format.parse("1.1.1999"));
        emp1.setDescription("nic moc");
        emp1.setPosition("Tester");

        emp2.setCompany("Opera.as");
        emp2.setDateStart(format.parse("12.11.2000"));
        emp2.setDateEnd(format.parse("5.5.2001"));
        emp2.setDescription("bolo dobre ale dávno žil na svete Slovák slávno");
        emp2.setPosition("Zámočník");




        employments.add(emp1);
        employments.add(emp2);
        mails.add("uml@xml.sk");
        mails.add("popo@kate.petl");
        phones.add("0918153578");
        phones.add("+42191153578");
        certificates.add("ABC");
        certificates.add("CBA");
        hobbies.add("eating");
        hobbies.add("sleeping");
        educations.add(edu1);
        educations.add(edu2);
        languages.add(lang1);
        languages.add(lang2);
        skills.add(sk1);
        skills.add(sk2);

        Person person = new Person();
        personalInfo.setPretitle("Ing.");
        personalInfo.setFirstName("Jozef");
        personalInfo.setLastName("Blažko");
        personalInfo.setPostTitle("Ph.D.");
        personalInfo.setPhones(phones);
        personalInfo.setEmails(mails);
        address.setStreet("Kalinčiakova");
        address.setCity("Brno");
        address.setPostalCode("97405");
        personalInfo.setAddress(address);
        person.setPasswordHash("86vgd4168sa4sdsdf646");
        person.setHobbies(hobbies);
        person.setCertificates(certificates);
        person.setEmployments(employments);
        person.setEducation(educations);
        person.setLanguages(languages);
        person.setSkills(skills);
        person.setPersonalInfo(personalInfo);


        XMLConverter.createXML(person);

        String nameOfFile = person.getPersonalInfo().getFirstName() + person.getPasswordHash();
        File file = new File("C:\\projects\\" + nameOfFile +".xml");
        XMLConverter.createPerson(file);

    }

}
