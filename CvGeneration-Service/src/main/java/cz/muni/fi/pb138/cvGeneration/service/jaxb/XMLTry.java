package cz.muni.fi.pb138.cvGeneration.service.jaxb;

import cz.muni.fi.pa138.cvGeneration.entity.Person;
import cz.muni.fi.pa138.cvGeneration.entity.item.*;
import org.xmldb.api.base.XMLDBException;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

/**
 * Temporary class used for testing XmlConverterImpl
 *
 * Created by galbavyj on 13.05.2016.
 */
public class XMLTry {


    public static void main(String[] args) throws ParseException, XMLDBException {



        DateFormat format = new SimpleDateFormat("d.M.yyyy");
        DateFormat formatYear = new SimpleDateFormat("yyyy");


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
        List<Education> education = new ArrayList<>();
        List<Languages> languages = new ArrayList<>();
        List<Skills> skills = new ArrayList<>();
        List<String> mails = new ArrayList<>();
        List<String> phones = new ArrayList<>();
        List<String> certificates = new ArrayList<>();
        List<String> hobbies = new ArrayList<>();
        PersonalInfo personalInfo = new PersonalInfo();


        edu2.setSchoolName("FI MUNI");
        edu2.setDateStart(formatYear.parse("2011"));
        edu2.setGrade("1");
        edu2.setFieldOfStudy("Niečo dobrého");

        edu1.setSchoolName("SOŠ Spišská Nová Ves");
        edu1.setDateStart(formatYear.parse("1994"));
        edu1.setDateEnd(formatYear.parse("2000"));
        edu1.setGrade("3");
        edu1.setFieldOfStudy("aplikovaná záhradkárčina");

        lang1.setLanguageName("English");
        lang1.setLevel("advanced");

        lang2.setLanguageName("Slovak");
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
        certificates.add("Shhbc");
        certificates.add("Lečo");
        hobbies.add("eating");
        hobbies.add("sleeping");
        education.add(edu1);
        education.add(edu2);
        languages.add(lang1);
        languages.add(lang2);
        skills.add(sk1);
        skills.add(sk2);

        Person person = new Person();
        personalInfo.setPreTitle("Ing.");
        personalInfo.setFirstName("Jozef");
        personalInfo.setLastName("Blažko");
        personalInfo.setPostTitle("Ph.D.");
        personalInfo.setPhones(phones);
        personalInfo.setEmails(mails);
        address.setStreet("Kalinčiakova");
        address.setCity("Brno");
        address.setPostalCode("97405");
        personalInfo.setAddress(address);
        person.setHobbies(hobbies);
        person.setCertificates(certificates);
        person.setEmployments(employments);
        person.setEducation(education);
        person.setLanguages(languages);
        person.setSkills(skills);
        person.setPersonalInfo(personalInfo);

        Person p2 = new Person();
        List<String> m2 = new ArrayList<>();
        List<String> ph2 = new ArrayList<>();

        Education minSchool = new Education("Gymnázium Šurany", "Rybárčenie", "4", format.parse("11.11.2011"), format.parse("12.12.2012"));
        Employments minEmp = new Employments("Rybník s.r.o.", "Vedúci rybár", format.parse("11.11.2015"), format.parse("15.1.2016"), "Lovenie rýb v zátoke korytnačiek.");
        Languages minLang = new Languages("English", "basic");
        Languages lan1 = new Languages("Slovak", "native");
        Languages lan2 = new Languages("Polish", "advance");



        List<Employments> minEmps = new ArrayList<>();
        List<Education> minSchools = new ArrayList<>();
        List<Languages> minLangs = new ArrayList<>();


        List<String> hobs = new ArrayList<>();
        hobs.add("člnkovanie");
        hobs.add("rybačka");
        hobs.add("streľba z harpúny");
        hobs.add("pitie piva");



        minEmps.add(minEmp);
        minSchools.add(minSchool);
        minLangs.add(minLang);
        minLangs.add(lan1);
        minLangs.add(lan2);


        m2.add("jano.potocny@gmail.com");
        ph2.add("+42189465451");

        p2.setPersonalInfo(new PersonalInfo(null,"Jano", "Potočný",null,
                new Address("Hofmann 21", "Berlin", "970 51"), ph2, m2));
        p2.setEducation(minSchools);
        p2.setEmployments(minEmps);
        p2.setLanguages(minLangs);
        p2.setHobbies(hobs);
        p2.setSkills(skills);


        XmlConverterImpl converter = new XmlConverterImpl();

        String name = converter.createXML(p2);
        converter.createXML(person);
        //System.out.println(name);

        //Person person1 = converter.createPerson(name);
        //System.out.println(person1);

    }

}
