package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name="user_id")

public class JobSeeker extends User {
	
	
	@Column(name="user_id",insertable = false,updatable = false)
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="tcno")
	private String tcno;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	public JobSeeker() {}
	
	

	public JobSeeker( int userId,
			String firstName, String lastName, String tcno, Date birthDate) {
		
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tcno = tcno;
		this.birthDate = birthDate;
	}



	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = user_id;
	}

	public String getFirst_name() {
		return firstName;
	}

	public void setFirst_name(String firstName) {
		this.firstName = firstName;
	}

	public String getLast_name() {
		return lastName;
	}

	public void setLast_name(String lastName) {
		this.lastName = lastName;
	}

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public Date getBirth_date() {
		return birthDate;
	}

	public void setBirth_date(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	
}
