package task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import task.DAO.RoleRepository;
import task.DAO.UserDataSetRepository;
import task.model.Role;
import task.model.UserDataSet;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserDataSetRepository udsRepository;

    @Autowired
    RoleRepository roleRepository;

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean saveUser(UserDataSet uds) {
        UserDataSet udsNew = udsRepository.findUserDataSetByLogin(uds.getLogin());

        if (udsNew != null) {
            return false;
        }

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(1L));
        uds.setRoles(roles);
        udsRepository.save(uds);
        return true;
    }

    public void removeUser(long id) {
        udsRepository.deleteById(id);
    }

    public UserDataSet getUserById(long id) {
        return udsRepository.findById(id).get();
    }

    public UserDataSet findUserDataSetByLogin(String login) {
        UserDataSet uds = udsRepository.findUserDataSetByLogin(login);

        return uds;
    }

    public List<UserDataSet> findAllUsers() {
        List<UserDataSet> usersList = udsRepository.findAll();

        if(usersList.size()>0) {
            return usersList;
        } else {
            return new ArrayList<UserDataSet>();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDataSet uds = udsRepository.findByUsername(name);

        if (uds == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return uds;
    }
}
