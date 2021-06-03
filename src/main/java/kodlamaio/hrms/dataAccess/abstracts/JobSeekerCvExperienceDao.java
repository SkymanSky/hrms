package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobSeekerCvExperience;

public interface JobSeekerCvExperienceDao extends JpaRepository<JobSeekerCvExperience, Integer> {
	@Query("From JobSeekerCvExperience where jobSeekerid=:jobSeekerid order by endYearExperience ASC")
	List<JobSeekerCvExperience> getJobSeekerAllExperiencesSortedByAsc(int jobSeekerid);
}
