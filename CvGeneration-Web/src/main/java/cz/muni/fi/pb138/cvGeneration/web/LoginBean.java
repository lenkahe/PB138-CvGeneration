package cz.muni.fi.pb138.cvGeneration.web;

/**
 * Created by Marek Perichta on 28.05.2016.
 *
 * Bean for retrieving username and password.
 */
public class LoginBean {
    private String username;

    private String password;

    public String getPassword()
    {
        return this.password;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
