package cz.muni.fi.pb138.cvGeneration.entity.item;

import javax.xml.bind.annotation.XmlType;

/**
 * Language
 *
 * @author Lenka Heldova, galbavyj
 */

@XmlType(propOrder={"languageName", "level"})
public class Language {
    private String languageName;
    private String level;

    public Language(String languageName, String level) {
        this.level = level;
        this.languageName = languageName;
    }

    public Language() {
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
        if (!(o instanceof Language)) return false;

        Language language = (Language) o;

        if (getLanguageName() != null ? !getLanguageName().equals(language.getLanguageName()) : language.getLanguageName() != null)
            return false;
        return getLevel() != null ? getLevel().equals(language.getLevel()) : language.getLevel() == null;

    }

    @Override
    public int hashCode() {
        int result = getLanguageName() != null ? getLanguageName().hashCode() : 0;
        result = 31 * result + (getLevel() != null ? getLevel().hashCode() : 0);
        return result;
    }
}
