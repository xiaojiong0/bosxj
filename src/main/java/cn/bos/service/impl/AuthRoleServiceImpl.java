package cn.bos.service.impl;

import cn.bos.domain.po.AuthRole;
import cn.bos.domain.po.RoleFunction;
import cn.bos.domain.uipojo.EasyUIDataGridResult;
import cn.bos.mapper.AuthRoleMapper;
import cn.bos.mapper.RoleFunctionMapper;
import cn.bos.service.AuthRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AuthRoleServiceImpl implements AuthRoleService {
    @Autowired
    AuthRoleMapper authRoleMapper;
    @Autowired
    RoleFunctionMapper roleFunctionMapper;


    @Override
    public EasyUIDataGridResult pageQuery(Integer page, Integer row) {
        PageHelper.startPage(page, row);
        List<AuthRole> list = authRoleMapper.select(new AuthRole());
        EasyUIDataGridResult result=new EasyUIDataGridResult();
        result.setRows(list);
        PageInfo<AuthRole> pageInfo=new PageInfo<AuthRole>(list);
        result.setTotal(pageInfo.getTotal());

        return result;
    }

    @Override
    public List<Map<String, String>> queryAll() {
        List<AuthRole> list = authRoleMapper.select(new AuthRole());
        List<Map<String, String>> l=new ArrayList<Map<String, String>>();
        for (AuthRole authRole : list) {
            Map map=new  HashMap<String,String>();
            map.put("id",authRole.getId());
            map.put("name",authRole.getName());
            map.put("description",authRole.getDescription());
            l.add(map);
        }

        return l;
    }

    @Override
    public int insert(AuthRole authRole,String ids) throws Exception {
        int a = authRoleMapper.insert(authRole);
        String[] strings = ids.split(",");
        for (String string : strings) {
            int insert = roleFunctionMapper.insert(new RoleFunction(authRole.getId(), Long.valueOf(string)));
            if (insert==0){
                throw new Exception("菜单插入失败");
            }
        }
        return a;
    }

    @Override
    public int deleteAuthRoles(String ids) {
        ids=ids.substring(0,ids.length()-1);
//        int i = authRoleMapper.bachDeleteids(ids);
        return 0;
    }
}
