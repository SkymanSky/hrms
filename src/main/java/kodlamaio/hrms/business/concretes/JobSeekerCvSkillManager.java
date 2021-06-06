package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCvSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvSkillDao;
import kodlamaio.hrms.entities.concretes.JobSeekerCvSkill;

@Service
public class JobSeekerCvSkillManager implements JobSeekerCvSkillService{

	private JobSeekerCvSkillDao jobSeekerCvSkillDao;

	@Autowired
	public JobSeekerCvSkillManager(JobSeekerCvSkillDao jobSeekerCvSkillDao) {
		super();
		this.jobSeekerCvSkillDao = jobSeekerCvSkillDao;
	}

	@Override
	public Result add(JobSeekerCvSkill jobSeekerCvSkill) {
		this.jobSeekerCvSkillDao.save(jobSeekerCvSkill);
		return new SuccessResult("Skills added to your cv.");
	}

	@Override
	public DataResult<JobSeekerCvSkill> findByJobSeekerId(int jobSeekerid) {
		
		return new SuccessDataResult<JobSeekerCvSkill>(this.jobSeekerCvSkillDao.findByJobSeekerId(jobSeekerid));
	}
	
	
}
