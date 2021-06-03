package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="curriculum_vitae")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class CurriculumVitae {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_seeker_id")
	private int jobSeekerid;
	
	@Column(name="image_path")
	private String imagePath;
	
	@Column(name="github_profile")
	private String githubProfile;
	
	@Column(name="linkedin_profile")
	private String linkedinProfile;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<JobSeekerCvExperience> jobSeekerCvExperiences;
	

}
