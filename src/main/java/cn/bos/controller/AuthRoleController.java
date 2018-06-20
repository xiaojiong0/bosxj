package cn.bos.controller;


import cn.bos.domain.po.AuthRole;
import cn.bos.domain.uipojo.EasyUIDataGridResult;
import cn.bos.service.AuthRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/authRole/")
public class AuthRoleController {

    @Autowired
    AuthRoleService authRoleService;

    @RequestMapping("pageQuery")
    @ResponseBody
    public EasyUIDataGridResult pageQuery(Integer page,Integer rows){

        EasyUIDataGridResult result = authRoleService.pageQuery(page, rows);
        return result;
    }


    @RequestMapping("queryCombox")
    @ResponseBody
    public List<Map<String,String>> queryCombox(){

        List<Map<String,String>> result = authRoleService.queryAll();
        return result;
    }

    @RequestMapping("addAuthRole")
    public String addAuthRole(AuthRole authRole,String functions){
        try {
            int insert = authRoleService.insert(authRole,functions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pages/admin/role";
    }

    @RequestMapping("deleteAuthRole")
    @ResponseBody
    public String deleteAuthRole(String ids){
        int i = authRoleService.deleteAuthRoles(ids);
        System.out.println(i);
        return "success";
    }

}
