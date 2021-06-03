package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCvExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvExperienceDao;
import kodlamaio.hrms.entities.concretes.JobSeekerCvExperience;

@Service
public class JobSeekerCvExperienceManager implements JobSeekerCvExperienceService {

	private JobSeekerCvExperienceDao jobSeekerCvExperienceDao;
	@Autowired
	public JobSeekerCvExperienceManager(JobSeekerCvExperienceDao jobSeekerCvExperienceDao) {
		super();
		this.jobSeekerCvExperienceDao = jobSeekerCvExperienceDao;
	}

	@Override
	public Result add(JobSeekerCvExperience JobSeekerCvExperience) {
		this.jobSeekerCvExperienceDao.save(JobSeekerCvExperience);
		return new SuccessResult("Your job experience added successfully.");
	}

	@Override
	public DataResult<List<JobSeekerCvExperience>> getJobSeekerAllExperiencesSortedByAsc(int jobSeekerid) {
		
		return new SuccessDataResult<List<JobSeekerCvExperience>>(this.jobSeekerCvExperienceDao.getJobSeekerAllExperiencesSortedByAsc(jobSeekerid),"Job experiences listed.");
	}

}
