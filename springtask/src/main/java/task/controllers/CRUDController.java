package task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.model.UserDataSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import task.service.UserService;

import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView allUsers() {
        ModelAndView mv = new ModelAndView("index");
        List<UserDataSet> uList = usi.findAllUsers();
        mv.addObject("usersList", uList);
        return mv;
    }

    @RequestMapping("/insert")
    public String addUser(Map<String, Object> model) {
        UserDataSet uds = new UserDataSet();
        model.put("user", uds);
        return "NewUserForm";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDataSet user = new UserDataSet();
        user = usi.getUserById(id);
        ModelAndView mv = new ModelAndView("EditUserForm");
        mv.addObject("user", user);
        return mv;
    }

//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public ModelAndView editUser(@ModelAttribute("user") UserDataSet user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/");
//        usi.updateUser(user);
//        return modelAndView;
//    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") UserDataSet user) {
        if (user.getId() != 0) {
            usi.updateUser(user);
        } else {
            user.setRole("user");
            usi.addUser(user);
        }
        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String removeUser(@ModelAttribute("user") UserDataSet uds) {
        usi.removeUser(uds.getId());
        return "redirect:/";
    }
}
