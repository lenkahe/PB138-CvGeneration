package cz.muni.fi.pb138.cvGeneration.service.entity.item;

import cz.muni.fi.pb138.cvGeneration.service.jaxb.DateAdapter;

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


}
