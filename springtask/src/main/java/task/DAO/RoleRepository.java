package task.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import task.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
