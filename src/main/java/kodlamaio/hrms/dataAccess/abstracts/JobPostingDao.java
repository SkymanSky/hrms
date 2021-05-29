package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting,Integer>{
	
	@Query("From JobPosting where jobPostingStatus=:jobPostingStatus")
	List<JobPosting> getByStatus(boolean jobPostingStatus);
	
	@Query("From JobPosting where jobPostingStatus=true and employer.userId=:userId")
	List<JobPosting> getByUserIdStatusActive(int userId);

}
