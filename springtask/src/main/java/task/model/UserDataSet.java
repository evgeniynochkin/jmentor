package task.model;

import javax.persistence.*;

@Entity
@Table (name = "userslist", schema="public")
public class UserDataSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "name", unique = true)
    private String name;

    @Column (name = "login")
    private String login;

    @Column (name = "password")
    private String password;

    @Column (name = "role", unique = true)
    private String role;

    public UserDataSet() {}

    public UserDataSet(String login, String password) {
        this.name = login;
        this.login = login;
        this.password = password;
        this.role = "user";
    }

    public UserDataSet(String name, String login, String password, String role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public void setId(long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setLogin(String login) { this.login = login; }

    public void setPassword(String password) { this.password = password; }

    public void setRole(String role) { this.role = role; }

    public long getId() { return id; }

    public String getName() { return name; }

    public String getLogin() { return login; }

    public String getPassword() { return password; }

    public String getRole() { return role; }

    @Override
    public String toString() {
        return "model.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", role=" + role +
                '}';
    }
}
