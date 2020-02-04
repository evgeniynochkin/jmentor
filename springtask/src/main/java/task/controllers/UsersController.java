package task.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import task.model.UserDataSet;

@Controller
public class UsersController {

    @GetMapping(value = "/news")
    public ModelAndView news() {
        ModelAndView mav = new ModelAndView();
        UserDataSet user = (UserDataSet) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("user", user);
        mav.setViewName("news");
        return mav;
    }
}
