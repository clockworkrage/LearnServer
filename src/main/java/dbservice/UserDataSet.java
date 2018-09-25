package dbservice;

import java.io.Serializable;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "userByName", query = "select u from userdata u where u.username = :username"),
        @NamedQuery(name = "deleteByName", query = "delete from userdata u where u.username = :username")

})

@Entity(name="userdata")
@Table(name = "userdata")
public class UserDataSet implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    public UserDataSet() {

    }
    public UserDataSet(String username, String email, String password, long score) {
        this.id         =   -1;
        this.username   =   username;
        this.email      =   email;
        this.password   =   password;
    }


    public String getName() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }





}