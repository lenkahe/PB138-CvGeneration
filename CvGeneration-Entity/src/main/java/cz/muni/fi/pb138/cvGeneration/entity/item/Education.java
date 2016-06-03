package cz.muni.fi.pb138.cvGeneration.entity.item;


import cz.muni.fi.pb138.cvGeneration.entity.DateAdapter;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Created by lenkahe on 12.5.2016.
 */
@XmlType(propOrder={"schoolName","fieldOfStudy", "grade", "dateStart", "dateEnd"})
public class Education {

    private String schoolName;
    private String fieldOfStudy;
    private String grade;
    private Date dateStart;
    private Date dateEnd;

    public Education(String schoolName, String fieldOfStudy, String grade, Date dateStart, Date dateEnd) {
        this.schoolName = schoolName;
        this.fieldOfStudy = fieldOfStudy;
        if (grade != null) this.grade = grade;
        this.dateStart = dateStart;
        if (dateEnd != null) this.dateEnd = dateEnd;
    }

    public Education() {
    }

    public Date getDateStart() {
        return dateStart;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Education)) return false;

        Education education = (Education) o;

        if (!getSchoolName().equals(education.getSchoolName())) return false;
        if (!getFieldOfStudy().equals(education.getFieldOfStudy())) return false;
        if (getGrade() != null ? !getGrade().equals(education.getGrade()) : education.getGrade() != null) return false;
        if (!getDateStart().equals(education.getDateStart())) return false;
        return getDateEnd() != null ? getDateEnd().equals(education.getDateEnd()) : education.getDateEnd() == null;

    }

    @Override
    public int hashCode() {
        int result = getSchoolName().hashCode();
        result = 31 * result + getFieldOfStudy().hashCode();
        result = 31 * result + (getGrade() != null ? getGrade().hashCode() : 0);
        result = 31 * result + getDateStart().hashCode();
        result = 31 * result + (getDateEnd() != null ? getDateEnd().hashCode() : 0);
        return result;
    }
}