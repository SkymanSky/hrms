package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	
	
}
