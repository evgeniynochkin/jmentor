package task.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="u_role")
public class Role implements GrantedAuthority {

    @Id
    private long id;

    @Column
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<UserDataSet> users;

    public Role() {}

    public Role(Long id) { this.id = id; }

    public Role(Long id, String nsme) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setUsers(Set<UserDataSet> uds) { this.users = uds; }

    public Long getId() { return id; }

    public String getName() { return name; }

    public Set<UserDataSet> getUsers() { return users; }

    @Override
    public String getAuthority() { return getName(); }
}
