package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting,Integer>{
	
	@Query("From JobPosting where jobPostingStatus=:jobPostingStatus")
	List<JobPosting> getByStatus(boolean jobPostingStatus);
	
	@Query("From JobPosting where jobPostingStatus=true and employer.userId=:userId")
	List<JobPosting> getByUserIdStatusActive(int userId);
	
	@Query("From JobPosting where jobPostingStatus=true order by jobPostDate DESC")
	List<JobPosting> getAllStatusIsActiveSortedByDesc();
	
	@Query("From JobPosting where jobPostingStatus=true order by jobPostDate ASC")
	List<JobPosting> getAllStatusIsActiveSortedByAsc();
	
	@Transactional
    @Modifying
	@Query("Update JobPosting set jobPostingStatus=false where id=:id")
	void updateJobPostingStatusToInactive(int id);
	
	@Transactional
    @Modifying
	@Query("Update JobPosting set jobPostingStatus=true where id=:id")
	void updateJobPostingStatusToActive(int id);

}
