package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employers")
@PrimaryKeyJoinColumn(name="user_id")
public class Employer extends User{
	
	@Column(name="user_id",insertable = false,updatable = false)
	private int user_id;
	
	@Column(name="company_name")
	private String company_name;
	
	@Column(name="web_site")
	private String web_site;
	
	@Column(name="telno")
	private String telno;
	
	public Employer() {}

	public Employer(int id, int user_no, String email, String password, String password_validate, int user_id,
			String company_name, String web_site, String telno) {
		super(id, user_no, email, password, password_validate);
		this.user_id = user_id;
		this.company_name = company_name;
		this.web_site = web_site;
		this.telno = telno;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getWebsite() {
		return web_site;
	}

	public void setWebsite(String website) {
		this.web_site = website;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	
}
