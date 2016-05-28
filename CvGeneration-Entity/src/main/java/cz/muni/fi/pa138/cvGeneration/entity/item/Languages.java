package cz.muni.fi.pa138.cvGeneration.entity.item;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by lenkahe on 12.5.2016.
 */

@XmlType(propOrder={"languageName", "level"})
public class Languages {
    private String languageName;
    private String level;

    public Languages(String languageName, String level) {
        this.level = level;
        this.languageName = languageName;
    }

    public Languages() {
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Languages)) return false;

        Languages languages = (Languages) o;

        if (getLanguageName() != null ? !getLanguageName().equals(languages.getLanguageName()) : languages.getLanguageName() != null)
            return false;
        return getLevel() != null ? getLevel().equals(languages.getLevel()) : languages.getLevel() == null;

    }

    @Override
    public int hashCode() {
        int result = getLanguageName() != null ? getLanguageName().hashCode() : 0;
        result = 31 * result + (getLevel() != null ? getLevel().hashCode() : 0);
        return result;
    }
}
