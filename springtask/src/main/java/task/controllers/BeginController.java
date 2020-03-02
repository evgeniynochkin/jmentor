package task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import task.model.UserDataSet;
import task.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
public class BeginController {

    @Autowired
    private UserServiceImpl usi;

    @GetMapping("/registration")
    public String login(Model model) {
        model.addAttribute("user", new UserDataSet());
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") @Valid UserDataSet uds, BindingResult bindingResult, Model model) {

        if (!uds.getPassword().equals(uds.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }

        if (!usi.saveUser(uds)) {
            model.addAttribute("loginError", "Логин уже существует");
            return "registration";
        }

        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            usi.saveUser(uds);
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
}