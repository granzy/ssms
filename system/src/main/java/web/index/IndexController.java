package web.index;

import base.annotation.CurrentUser;
import domain.resource.Menu;
import domain.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.resource.ResourceService;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* User: gzy
 * \* Date: 2017/1/17
 * \* Time: 11:33
 * \* Description:
 * \
 */
@Controller
@RequestMapping("/admin")
public class IndexController {

    @Resource
    private ResourceService resourceService;

    @RequestMapping("/index")
    public String index(@CurrentUser User user, Model model){

        List<Menu> menus = resourceService.findMenus(user);
        model.addAttribute("menus", menus);

        return "admin/index/index";
    }

}
