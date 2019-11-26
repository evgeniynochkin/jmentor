package task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import task.model.UserDataSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import task.service.UserService;
import task.service.UserServiceImpl;

import java.util.List;
import java.util.Map;

@Controller
public class CRUDController {

    private UserService usi;

    @Autowired
    public void setUsi(UserService usi) {
        this.usi = usi;
    }

    @RequestMapping("/")
//    public ModelAndView allUsers() {
//        ModelAndView mv = new ModelAndView("index");
//        List<UserDataSet> uList = usi.findAllUsers();
//        mv.addObject("usersList", uList);
//        return mv;
//    }
    public String getIndex() {
        return "index";
    }

    @RequestMapping("/insert")
    public String addUser(Map<String, Object> model) {
        UserDataSet uds = new UserDataSet();
        model.put("user", uds);
        return "NewUserForm";
    }

    @RequestMapping("/edit")
    public ModelAndView editUser(@RequestParam int id) {
        ModelAndView mv = new ModelAndView("EditUserForm");
        UserDataSet uds = usi.getUserById(id);
        uds.setRole("user");
        mv.addObject("user", uds);
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") UserDataSet uds) {
        if (uds.getId() != 0) {
            usi.updateUser(uds);
        } else {
            uds.setRole("user");
            usi.addUser(uds);
        }
        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String removeUser(@ModelAttribute("user") UserDataSet uds) {
        usi.removeUser(uds.getId());
        return "redirect:/";
    }
}
