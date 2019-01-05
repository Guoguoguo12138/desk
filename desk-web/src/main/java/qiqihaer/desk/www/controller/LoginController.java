package qiqihaer.desk.www.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qiqihaer.desk.www.entity.User;
import qiqihaer.desk.www.service.UserService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    private final static Logger log = Logger.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> doLogin(Model model,
                                      @RequestParam(value = "userid",required = false) String userid){
        Map map = new HashMap<String,Object>();
        User user = userService.login(userid);
        if (user!=null){
            log.info("用户登录登录成功");
            map.put("login","success");
        }else {
            log.info("用户登录登录失败");
            map.put("login","fail");
        }
        return map;
    }
}