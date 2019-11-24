package task.model;

import javax.persistence.*;

@Entity
@Table (name = "users")
public class UserDataSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name", unique = true)
    private String name;

    @Column (name = "login")
    private String login;

    @Column (name = "password")
    private String password;

    @Column (name = "role", unique = true)
    private String role;

    public UserDataSet() {}

    public void setId(Integer id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setLogin(String login) { this.login = login; }

    public void setPassword(String password) { this.password = password; }

    public void setRole(String role) { this.role = role; }

    public int getId() { return id; }

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
