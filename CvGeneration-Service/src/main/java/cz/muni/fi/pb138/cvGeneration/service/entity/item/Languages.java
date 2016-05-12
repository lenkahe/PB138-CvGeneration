package cz.muni.fi.pb138.cvGeneration.service.entity.item;

/**
 * Created by lenkahe on 12.5.2016.
 */
public class Languages {
    private String language;
    private String level;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

        if (getLanguage() != null ? !getLanguage().equals(languages.getLanguage()) : languages.getLanguage() != null)
            return false;
        return getLevel() != null ? getLevel().equals(languages.getLevel()) : languages.getLevel() == null;

    }

    @Override
    public int hashCode() {
        int result = getLanguage() != null ? getLanguage().hashCode() : 0;
        result = 31 * result + (getLevel() != null ? getLevel().hashCode() : 0);
        return result;
    }
}
