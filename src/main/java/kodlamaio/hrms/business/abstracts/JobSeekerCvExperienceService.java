package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCvExperience;

public interface JobSeekerCvExperienceService {
	Result add(JobSeekerCvExperience JobSeekerCvExperience);
	DataResult<List<JobSeekerCvExperience>> getJobSeekerAllExperiencesSortedByAsc(int jobSeekerid);
}
