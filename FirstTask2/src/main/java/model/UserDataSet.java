package model;

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

    public UserDataSet() {}

    public void setId(Integer id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setLogin(String login) { this.login = login; }

    public void setPassword(String password) { this.password = password; }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getLogin() { return login; }

    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "model.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password=" + password +
                '}';
    }
}
