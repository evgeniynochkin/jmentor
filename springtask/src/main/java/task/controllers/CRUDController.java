package task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import task.model.UserDataSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import task.service.UserServiceImpl;

import java.util.List;

@Controller
public class CRUDController {

    private UserServiceImpl usi;

    @Autowired
    public void setUsi(UserServiceImpl usi) {
        this.usi = usi;
    }

    @RequestMapping(value = {"/", "/index"})
    public String viewHomePage(Model model){
        //List<UserDataSet> uList = usi.findAllUsers();
        //model.addAttribute("usersList", uList);
        return "index";
    }

    @RequestMapping("/admin/insert")
    public String addUser(Model model) {
        UserDataSet uds = new UserDataSet();
        model.addAttribute("user", uds);
        return "AdminForm";
    }

    @RequestMapping("/admin/save")
    public String saveUser(@ModelAttribute("user") UserDataSet uds)  {
        usi.saveUser(uds);
        return "redirect:/";
    }

    @RequestMapping("/admin/edit/{id}")
    public ModelAndView editUser(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("AdminForm");
        UserDataSet usd = usi.getUserById(id);

        mav.addObject("user", usd);
        return mav;
    }

    @RequestMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") long id) {
        usi.removeUser(id);
        return "redirect:/";
    }
}
