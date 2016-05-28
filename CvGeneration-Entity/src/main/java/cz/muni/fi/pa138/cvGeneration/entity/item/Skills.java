package cz.muni.fi.pa138.cvGeneration.entity.item;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by lenkahe on 12.5.2016.
 */
@XmlType(propOrder={"skillName", "level"})
public class Skills {
    private String skillName;
    private String level;

    public Skills(String skillName, String level) {
        this.skillName = skillName;
        this.level = level;
    }

    public Skills() {
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
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
        if (!(o instanceof Skills)) return false;

        Skills skills = (Skills) o;

        if (getSkillName() != null ? !getSkillName().equals(skills.getSkillName()) : skills.getSkillName() != null)
            return false;
        return getLevel() != null ? getLevel().equals(skills.getLevel()) : skills.getLevel() == null;

    }

    @Override
    public int hashCode() {
        int result = getSkillName() != null ? getSkillName().hashCode() : 0;
        result = 31 * result + (getLevel() != null ? getLevel().hashCode() : 0);
        return result;
    }
}
