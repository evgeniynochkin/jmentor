package task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MyErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = ERROR_PATH)
    public String error(WebRequest request, HttpServletRequest httpServletRequest) {
        Map<String, Object> attrs = this.errorAttributes.getErrorAttributes(request, false);

        Integer status = (Integer) attrs.get("status");
        if (status != null && status == 403) {
            httpServletRequest.setAttribute("unauthorized", true);
        }

        return "/login";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
