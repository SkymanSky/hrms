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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cv_schools")
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class JobSeekerCvSchool {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="job_seeker_id")
	private int jobSeekerid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="deparment")
	private String deparment;
	
	@Column(name="start_year")
	private int startYear;
	
	@Column(name="end_year")
	private int endYear;
	
	//@Column(name="curriculum_vitae_id")
	//private String curriculumVitaeId;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;

}
