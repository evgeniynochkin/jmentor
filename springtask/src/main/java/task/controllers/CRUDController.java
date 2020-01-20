package task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import task.model.UserDataSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import task.service.UserService;
import java.util.List;

@Controller
public class CRUDController {

    private UserService usi;

    @Autowired
    public void setUsi(UserService usi) {
        this.usi = usi;
    }

    @RequestMapping(value = {"/", "/index"})
    public String viewHomePage(Model model){
        List<UserDataSet> uList = usi.findAllUsers();
        model.addAttribute("usersList", uList);
        return "index";
    }

    @RequestMapping("/insert")
    public String addUser(Model model) {
        UserDataSet uds = new UserDataSet();
        model.addAttribute("user", uds);
        return "NewEditUserForm";
    }

    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("user") UserDataSet uds)  {
        usi.addUser(uds);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editUser(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("NewEditUserForm");
        UserDataSet usd = usi.getUserById(id);
        mav.addObject("user", usd);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") long id) {
        usi.removeUser(id);
        return "redirect:/";
    }
}
