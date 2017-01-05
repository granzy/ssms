package web.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gzy on 2016/12/30.
 */
@Controller
public class LoginFormController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model){
        return "front/login";
    }
}
