package cn.xj.annotation.poi;

import cn.xj.annotation.poi.annotation.ExcelField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 患者信息
 * @author zxp
 *
 */

public class User {
    
	@ExcelField(title="姓名", type=0, sort=0)
	private String xm; // 姓名
	
	@ExcelField(title="性别", type=0, sort=1)
	private String sexName;//性别名称
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@ExcelField(title="出生日期", type=0, sort=2)
	private Date csrq; // 出生日期
	
	@ExcelField(title="手机号码",type=0,sort=3)
	private String sjhm; // 手机号码


	private Dog dog;


	public User() {
	}

	public User(String xm, String sexName, Date csrq, String sjhm) {
		this.xm = xm;
		this.sexName = sexName;
		this.csrq = csrq;
		this.sjhm = sjhm;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public Date getCsrq() {
		return csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public String getSjhm() {
		return sjhm;
	}

	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}

	@Override
	public String toString() {
		return "User{" +
				"xm='" + xm + '\'' +
				", sexName='" + sexName + '\'' +
				", csrq=" + csrq +
				", sjhm='" + sjhm + '\'' +
				'}';
	}
}