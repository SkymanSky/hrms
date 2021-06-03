package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="cv_experiences")
@PrimaryKeyJoinColumn(name="id")
public class JobSeekerCvExperience {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@Column(name="job_seeker_id")
	//private int jobSeekerid;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="position_description")
	private String positionDescription;
	
	@Column(name="start_year")
	private int startYearExperience;
	
	@Column(name="end_year")
	private int endYearExperience;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private CurriculumVitae curriculumVitae;


}
