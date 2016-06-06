package cz.muni.fi.pb138.cvGeneration.entity.item;



import javax.xml.bind.annotation.XmlType;

import java.text.SimpleDateFormat;


/**
 * Work experience of person
 *
 * @author Lenka Heldova, galbavyj
 */
@XmlType(propOrder={"company", "position", "dateStart", "dateEnd", "description"})
public class Employment {

    private String company;
    private String dateStart;
    private String dateEnd;
    private String position;
    private String description;

    public Employment(String company, String position, String dateStart, String dateEnd, String description) {
        this.dateStart = dateStart;
        if (dateEnd != null) this.dateEnd = dateEnd;
        this.company = company;
        this.position = position;
        if (description != null) this.description = description;
    }
    SimpleDateFormat format = new SimpleDateFormat("d.M.yyyy");

    public Employment() {
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employment)) return false;

        Employment that = (Employment) o;

        if (getDateStart() != null ? !getDateStart().equals(that.getDateStart()) : that.getDateStart() != null)
            return false;
        if (getDateEnd() != null ? !getDateEnd().equals(that.getDateEnd()) : that.getDateEnd() != null) return false;
        if (getCompany() != null ? !getCompany().equals(that.getCompany()) : that.getCompany() != null) return false;
        if (getPosition() != null ? !getPosition().equals(that.getPosition()) : that.getPosition() != null)
            return false;
        return getDescription() != null ? getDescription().equals(that.getDescription()) : that.getDescription() == null;

    }

    @Override
    public int hashCode() {
        int result = getDateStart() != null ? getDateStart().hashCode() : 0;
        result = 31 * result + (getDateEnd() != null ? getDateEnd().hashCode() : 0);
        result = 31 * result + (getCompany() != null ? getCompany().hashCode() : 0);
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return company + " " + format.format(dateStart)  + "-" + format.format(dateEnd);
    }
}
