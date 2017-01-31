package domain.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Melious on 15.11.2016.
 */

@XmlRootElement
@Entity
@Table(name = "account")
@NamedQueries({
        @NamedQuery(name = "account.all", query = "SELECT a FROM Account a"),
        @NamedQuery(name = "account.id", query = "SELECT a FROM Account a WHERE a.id=:id")
})
public class Account implements IHaveId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private Profile profile;
    private int profileId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Profile getProfile() {return profile;}

    public void setProfile(Profile profile) {this.profile = profile;}

    public int getProfileId() {return profileId;}

    public void setProfileId(int profileId) {this.profileId = profileId;}
}
