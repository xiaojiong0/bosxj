package cn.bos.domain.po;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "auth_function")
public class AuthFunction {
    private Long id;

    private String name;

    private String code;

    private String description;

    private String page;

    private String generatemenu;

    private Integer zindex;

    private String pid;
    @Transient
    private AuthFunction authFunction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }

    public String getGeneratemenu() {
        return generatemenu;
    }

    public void setGeneratemenu(String generatemenu) {
        this.generatemenu = generatemenu == null ? null : generatemenu.trim();
    }

    public Integer getZindex() {
        return zindex;
    }

    public void setZindex(Integer zindex) {
        this.zindex = zindex;
    }

    public AuthFunction getAuthFunction() {
        return authFunction;
    }

    public void setAuthFunction(AuthFunction authFunction) {
        this.authFunction = authFunction;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}