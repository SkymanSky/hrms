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
	private int userId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site")
	private String webSite;
	
	@Column(name="telno")
	private String telno;
	
	public Employer() {}

	public Employer(int id, int userNo, String email, String password, String passwordValidate, int userId,
			String companyName, String webSite, String telno) {
		super(id, userNo, email, password, passwordValidate);
		this.userId = userId;
		this.companyName = companyName;
		this.webSite = webSite;
		this.telno = telno;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	

	
}
