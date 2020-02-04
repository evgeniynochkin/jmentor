package task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import task.model.UserDataSet;
import task.service.UserServiceImpl;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/admin")
    public String usersList(Model model) {
       List<UserDataSet> usersList = userService.findAllUsers();
       model.addAttribute("usersList", usersList);
       return "admin";
    }
}
