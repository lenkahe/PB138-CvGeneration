package cz.muni.fi.pb138.cvGeneration.entity.item;

import javax.xml.bind.annotation.XmlType;

/**
 * Skill of person
 *
 * @author Lenka Heldova, galbavyj
 */
@XmlType(propOrder={"skillName", "level"})
public class Skill {
    private String skillName;
    private String level;

    public Skill(String skillName, String level) {
        this.skillName = skillName;
        this.level = level;
    }

    public Skill() {
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
        if (!(o instanceof Skill)) return false;

        Skill skill = (Skill) o;

        if (getSkillName() != null ? !getSkillName().equals(skill.getSkillName()) : skill.getSkillName() != null)
            return false;
        return getLevel() != null ? getLevel().equals(skill.getLevel()) : skill.getLevel() == null;

    }

    @Override
    public int hashCode() {
        int result = getSkillName() != null ? getSkillName().hashCode() : 0;
        result = 31 * result + (getLevel() != null ? getLevel().hashCode() : 0);
        return result;
    }
}
