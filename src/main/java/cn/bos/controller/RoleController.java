package cn.bos.controller;

import cn.bos.domain.po.AuthRole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {

    @RequestMapping("/addRole")
    public String addRole(String ids,AuthRole authRole){



        return "pages/admin/role";
    }
}
