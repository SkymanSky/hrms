package kodlamaio.hrms.entities.concretes;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name="curriculum_vitae")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitae"})

public class CurriculumVitae {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="curriculum_vitae_id")
	private int id;
	
	@Column(name="job_seeker_id")
	private int jobSeekerId;
	
	@Column(name="image_path")
	private String imagePath;
	
	@Column(name="github_profile")
	private String githubProfile;
	
	@Column(name="linkedin_profile")
	private String linkedinProfile;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@OneToMany(targetEntity = JobSeekerCvExperience.class, mappedBy = "curriculumVitae", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JobSeekerCvExperience> jobSeekerCvExperiences;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<JobSeekerCvSchool> jobSeekerCvSchools;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<JobSeekerCvLanguage> jobSeekerCvLanguages;
	
	@OneToMany(mappedBy="curriculumVitae")
	private List<JobSeekerCvSkill> jobSeekerCvSkills;

}
