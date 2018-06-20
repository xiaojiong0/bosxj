package cn.bos.domain.po;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description:	RoleFunction
 * @Author:			xj	
 * @CreateDate:		2018-3-11 18:12:02
 */
@Table(name = "role_function")
public class RoleFunction implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name = "role_id")
	private Long roleid;
	@Column(name = "function_id")
	private Long functionid;

	public RoleFunction(Long id, Long aLong) {
		roleid=id;
		functionid=aLong;
	}

	public RoleFunction() {
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public Long getFunctionid() {
		return functionid;
	}

	public void setFunctionid(Long functionid) {
		this.functionid = functionid;
	}
}
