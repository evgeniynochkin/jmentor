package spring.controllers;

import exceptions.DBException;
import model.UserDataSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class CRUDController {

    private UserService usi = new UserServiceImpl();

    @RequestMapping("/")
    public ModelAndView home() throws DBException, SQLException {
        ModelAndView mv = new ModelAndView("index");
        List<UserDataSet> uList = usi.findAllUsers();
        mv.addObject("usersList", uList);
        return mv;
    }

    @RequestMapping("/insert")
    public String addUser(Map<String, Object> model) throws DBException, SQLException {
        UserDataSet uds = new UserDataSet();
        model.put("user", uds);
        return "NewUserForm";
    }

    @RequestMapping("/edit")
    public ModelAndView editUser(@RequestParam int id) throws DBException, SQLException {
        ModelAndView mv = new ModelAndView("EditUserForm");
        UserDataSet uds = usi.getUserById(id);
        uds.setRole("user");
        mv.addObject("user", uds);
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") UserDataSet uds) throws DBException, SQLException {
        if (uds.getId() != 0) {
            usi.updateUser(uds, uds.getId());
        } else {
            uds.setRole("user");
            usi.addUser(uds);
        }
        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String removeUser(@ModelAttribute("user") UserDataSet uds) throws DBException, SQLException {
        usi.removeUser(uds.getId());
        return "redirect:/";
    }
}
