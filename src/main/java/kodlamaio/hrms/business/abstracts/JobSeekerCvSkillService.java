package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCvSkill;

public interface JobSeekerCvSkillService {
	Result add(JobSeekerCvSkill jobSeekerCvSkill);
	DataResult<JobSeekerCvSkill> findByJobSeekerId(int jobSeekerid);
	
}
