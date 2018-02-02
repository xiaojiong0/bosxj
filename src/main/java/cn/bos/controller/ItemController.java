package cn.bos.controller;

import cn.bos.mapper.ItemMapper;
import cn.bos.domain.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ItemController {
    @Autowired
    ItemMapper itemMapper;

    @RequestMapping("/AA/zz")
    @ResponseBody
    public Item home() {
        System.out.println(123);
        Item item=itemMapper.selectByPrimaryKey(536563L);

        return item;
    }

    @RequestMapping("/")
    public String index(){
        return "login";
    }
}
