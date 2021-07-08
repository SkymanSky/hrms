package kodlamaio.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobSeekerCvSkill;

public interface JobSeekerCvSkillDao extends JpaRepository<JobSeekerCvSkill, Integer>{
	
	@Query("From JobSeekerCvSkill where jobSeekerid=:jobSeekerid")
	List<JobSeekerCvSkill> findByJobSeekerId(int jobSeekerid);
	

}
