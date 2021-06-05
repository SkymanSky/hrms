package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer>{
	
	@Query("From CurriculumVitae where jobSeekerId=:jobSeekerId")
	CurriculumVitae findByJobSeekerId(int jobSeekerId);
	
	@Query("Select cv.jobSeekerId, jse.companyName From CurriculumVitae cv Inner Join JobSeekerCvExperience jse where jobSeekerId=:jobSeekerId")
	List<CurriculumVitae> getAllByJobSeekerId(int jobSeekerId);
}
