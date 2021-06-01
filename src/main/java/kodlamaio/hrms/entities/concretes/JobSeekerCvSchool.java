package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cv_schools")
@PrimaryKeyJoinColumn(name="id")

public class JobSeekerCvSchool {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="job_seeker_id")
	private int jobSeekerid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="start_year")
	private int startYear;
	
	@Column(name="end_year")
	private int endYear;

}
