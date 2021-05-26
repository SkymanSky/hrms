package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name="user_id")

public class JobSeeker extends User {
	
	
	@Column(name="user_id",insertable = false,updatable = false)
	private int user_id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="tcno")
	private String tcno;
	
	@Column(name="birth_date")
	private Date birth_date;
	
	public JobSeeker() {}
	
	

	public JobSeeker( int user_id,
			String first_name, String last_name, String tcno, Date birth_date) {
		
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.tcno = tcno;
		this.birth_date = birth_date;
	}



	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	
	
	
}
