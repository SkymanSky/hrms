package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDetailDto;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	JobSeeker findByTcno(String tcNo);
	JobSeeker findByEmail(String email);
	//@Query("Select new kodlamaio.hrms.entities.dtos.JobSeekerCvDetailDto(jse.jobSeekerid, jse.companyName, jse.positionDescription, jse.startYearExperience, jse.endYearExperience) From JobSeekerCvExperience js Inner Join js.jobSeekerCvExperiences jse")
	//List<JobSeekerCvDetailDto> getJobSeekerWithExperienceDetails();
	
	@Query(value="select js.user_id,cve.job_seeker_id,cve.company_name,cve.position_description,cve.start_year,cve.end_year\r\n"
			+ "from job_seekers js, cv_experiences cve\r\n"
			+ "WHERE js.user_id=cve.job_seeker_id", nativeQuery = true)
	List<JobSeekerCvDetailDto> getJobSeekerWithExperienceDetails();
	
	@Query("From JobSeeker where userId=:userId")
	JobSeeker findByJobSeekerId(int userId);
}
