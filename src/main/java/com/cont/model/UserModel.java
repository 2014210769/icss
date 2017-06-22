package com.cont.model;
import com.cont.utils.SuperModel;
/**
 * Created by lq on 2017/5/18.
 */
public class UserModel extends SuperModel {
	private long id;
	private String  u_name;
	private String  u_cname;
	private String  u_password;
	private int  u_gender;
	private long  u_role_id;
	private String  u_phone;
	private String  u_address;
	private int  u_status;
	private String  ceate_time;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_cname() {
		return u_cname;
	}
	public void setU_cname(String u_cname) {
		this.u_cname = u_cname;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public int getU_gender() {
		return u_gender;
	}
	public void setU_gender(int u_gender) {
		this.u_gender = u_gender;
	}
	public long getU_role_id() {
		return u_role_id;
	}
	public void setU_role_id(long u_role_id) {
		this.u_role_id = u_role_id;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public int getU_status() {
		return u_status;
	}
	public void setU_status(int u_status) {
		this.u_status = u_status;
	}
	public String getCeate_time() {
		return ceate_time;
	}
	public void setCeate_time(String ceate_time) {
		this.ceate_time = ceate_time;
	}
	
	
}
