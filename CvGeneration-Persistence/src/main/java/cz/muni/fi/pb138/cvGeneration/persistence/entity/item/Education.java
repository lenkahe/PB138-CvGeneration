package cz.muni.fi.pb138.cvGeneration.persistence.entity.item;


import cz.muni.fi.pb138.cvGeneration.persistence.entity.DateAdapter;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenkahe on 12.5.2016.
 */
@XmlType(propOrder={"schoolName","fieldOfStudy", "degree", "dateStart", "dateEnd"})
public class Education {

    private Date dateStart;
    private Date dateEnd;
    private String degree;
    private String schoolName;
    private String fieldOfStudy;

    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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

        if (!getDateStart().equals(education.getDateStart())) return false;
        if (!getDateEnd().equals(education.getDateEnd())) return false;
        if (!getDegree().equals(education.getDegree())) return false;
        if (!getSchoolName().equals(education.getSchoolName())) return false;
        if (!getFieldOfStudy().equals(education.getFieldOfStudy())) return false;
        return format.equals(education.format);

    }

    @Override
    public int hashCode() {
        int result = getDateStart().hashCode();
        result = 31 * result + getDateEnd().hashCode();
        result = 31 * result + getDegree().hashCode();
        result = 31 * result + getSchoolName().hashCode();
        result = 31 * result + getFieldOfStudy().hashCode();
        result = 31 * result + format.hashCode();
        return result;
    }
}
