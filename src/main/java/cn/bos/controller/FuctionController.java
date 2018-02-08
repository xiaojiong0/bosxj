package cn.bos.controller;

import cn.bos.domain.po.AuthFunction;
import cn.bos.domain.uipojo.EasyUIDataGridResult;
import cn.bos.service.FuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("fuction")
public class FuctionController {

    @Autowired
    FuctionService fuctionService;

    @RequestMapping("pageQuery")
    @ResponseBody
    public EasyUIDataGridResult pageQuery(Integer page,Integer rows){

        EasyUIDataGridResult result = fuctionService.pageQuery(page, rows);
        return result;
    }


    @RequestMapping("queryCombox")
    @ResponseBody
    public List<Map<String,String>> queryCombox(){

        List<Map<String,String>> result = fuctionService.queryAll();
        return result;
    }

    @RequestMapping("addFuction")
    public String addFuction(AuthFunction authFunction){
        fuctionService.insert(authFunction);

        return "pages/admin/function";
    }

    @RequestMapping("deleteFuction")
    @ResponseBody
    public String deleteFuction(String ids){
        int i = fuctionService.deleteFuctions(ids);
        System.out.println(i);
        return "success";
    }

}
