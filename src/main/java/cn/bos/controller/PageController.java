package cn.bos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/{path}/{path1}")
    public String pageReturn(@PathVariable String path,@PathVariable String path1){

        return "pages/"+path+"/"+path1;
    }

}
