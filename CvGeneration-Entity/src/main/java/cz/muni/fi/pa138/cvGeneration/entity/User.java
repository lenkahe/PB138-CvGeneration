package cz.muni.fi.pa138.cvGeneration.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * User of application.
 *
 * @author Lenka Heldova
 */
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @NotNull
    private String login;
    private String password;
    private String cvFileName;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCvFileName() {
        return cvFileName;
    }

    public void setCvFileName(String cvFileName) {
        this.cvFileName = cvFileName;
    }


}
