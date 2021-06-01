package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import kodlamaio.hrms.entities.concretes.JobSeekerCvSchool;

public interface JobSeekerCvSchoolDao extends JpaRepository<JobSeekerCvSchool, Integer> {
	
	@Query("From JobSeekerCvSchool where jobSeekerid=:jobSeekerid order by endYear aSC")
	List<JobSeekerCvSchool> getJobSeekerAllSchoolsSortedByAsc(int jobSeekerid);
}
