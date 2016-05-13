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
@XmlType(propOrder={"schoolName", "degree", "dateStart", "dateEnd"})
public class Education {

    private Date dateStart;
    private Date dateEnd;
    private String degree;
    private String schoolName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Education)) return false;

        Education education = (Education) o;

        if (getDateStart() != null ? !getDateStart().equals(education.getDateStart()) : education.getDateStart() != null)
            return false;
        if (getDateEnd() != null ? !getDateEnd().equals(education.getDateEnd()) : education.getDateEnd() != null)
            return false;
        if (getDegree() != null ? !getDegree().equals(education.getDegree()) : education.getDegree() != null)
            return false;
        if (getSchoolName() != null ? !getSchoolName().equals(education.getSchoolName()) : education.getSchoolName() != null)
            return false;
        return format != null ? format.equals(education.format) : education.format == null;

    }

    @Override
    public int hashCode() {
        int result = getDateStart() != null ? getDateStart().hashCode() : 0;
        result = 31 * result + (getDateEnd() != null ? getDateEnd().hashCode() : 0);
        result = 31 * result + (getDegree() != null ? getDegree().hashCode() : 0);
        result = 31 * result + (getSchoolName() != null ? getSchoolName().hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        return result;
    }
}
