package cn.bos.controller.testController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/file/import/export")
public class ImportandExport {
    @RequestMapping("")
    @ResponseBody
    public String exportImport(){

        return "success";
    }

}
