package cn.bos.service;

import cn.bos.domain.po.AuthRole;
import cn.bos.domain.uipojo.EasyUIDataGridResult;

import java.util.List;
import java.util.Map;

public interface AuthRoleService {

    EasyUIDataGridResult pageQuery(Integer page, Integer rows);

    List<Map<String,String>> queryAll();

    int insert(AuthRole authRole,String ids) throws Exception;

    int deleteAuthRoles(String ids);
}
