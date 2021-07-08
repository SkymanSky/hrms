package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCvSkill;

public interface JobSeekerCvSkillService {
	Result add(JobSeekerCvSkill jobSeekerCvSkill);
	DataResult<List<JobSeekerCvSkill>> findByJobSeekerId(int jobSeekerid);
	Result update(JobSeekerCvSkill jobSeekerCvSkill);
	
}
