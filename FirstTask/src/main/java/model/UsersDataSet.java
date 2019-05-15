package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Evgeniy Nochkin
 * @since 1.1
 * Структура таблицы User
 */

@Entity
@Table(name = "USERS")
public class UsersDataSet {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "LOGIN", unique = true, updatable = false)
    private String login;

    @Column(name = "PASSWORD", unique = true, updatable = true)
    private String password;

    @Column(name = "NAME", unique = false, updatable = true)
    private String name;

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet() {}


    public void setId(long id) { this.id = id; }

    public void setLogin(String login) { this.login = login; }

    public void setPassword(String password) { this.password = password; }

    public void setName(String name) { this.name = name; }

    public long getId() { return id; }

    public String getLogin() { return login; }

    public String getPassword() { return password; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "UsersDataSet{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
