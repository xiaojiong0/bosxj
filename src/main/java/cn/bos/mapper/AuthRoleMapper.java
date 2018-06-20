package cn.bos.mapper;

import cn.bos.domain.po.AuthRole;
import com.github.abel533.mapper.Mapper;

public interface AuthRoleMapper extends Mapper<AuthRole> {

    void insertAuthRole(AuthRole authRole);

    AuthRole findRoleContainFun()
}
