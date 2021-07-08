package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDetailDto;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {

	@Query("From CurriculumVitae where jobSeekerId=:jobSeekerId")
	CurriculumVitae findByJobSeekerId(int jobSeekerId);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobSeekerCvDetailDto(cv.id,cv.jobSeekerId, jss.name, jse.companyName,jse.startYearExperience,jse.endYearExperience)"
			+ " From CurriculumVitae cv"
			+ " Inner Join cv.jobSeekerCvSchools jss"
			+ " Inner Join cv.jobSeekerCvExperiences jse"
			+ " where cv.jobSeekerId=:jobSeekerId")
	List<JobSeekerCvDetailDto> getByJobSeekerId(int jobSeekerId);

}
