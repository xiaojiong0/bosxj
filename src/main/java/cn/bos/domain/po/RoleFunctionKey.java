package cn.bos.domain.po;

import javax.persistence.Table;

@Table(name = "role_function")
public class RoleFunctionKey {
    private String roleId;

    private String functionId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId == null ? null : functionId.trim();
    }
}