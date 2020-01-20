package task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.DAO.UserDataSetRepository;
import task.model.UserDataSet;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDataSetRepository repository;

    public void addUser(UserDataSet uds) {
        repository.save(uds);
    }

    public void removeUser(long id) {
        repository.deleteById(id);
    }


    public UserDataSet getUserById(long id) {
        return repository.findById(id).get();
    }

    public List<UserDataSet> findAllUsers() {
        List<UserDataSet> usersList = repository.findAll();

        if(usersList.size()>0) {
            return usersList;
        } else {
            return new ArrayList<UserDataSet>();
        }
    }
}
