package web.monitor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * \* User: gzy
 * \* Date: 2017/1/18
 * \* Time: 16:24
 * \* Description:
 * \
 */
@Controller
@RequestMapping("/admin/monitor/ehcache")
public class EhcacheMonitorController {

    @RequestMapping()
    public String index(Model model) {
        //model.addAttribute("cacheManager", cacheManager);
        return "admin/monitor/ehcache/index";
    }
}
