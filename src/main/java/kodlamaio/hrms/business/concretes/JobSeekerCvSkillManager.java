package kodlamaio.hrms.business.concretes;

import java.util.List;

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
	public DataResult<List<JobSeekerCvSkill>> findByJobSeekerId(int jobSeekerid) {
		
		return new SuccessDataResult<List<JobSeekerCvSkill>>(this.jobSeekerCvSkillDao.findByJobSeekerId(jobSeekerid),"Yetenekler listelendi.");
	}

	@Override
	public Result update(JobSeekerCvSkill jobSeekerCvSkill) {
		this.jobSeekerCvSkillDao.save(jobSeekerCvSkill);
		return new SuccessResult("Job Experience updateed");
		
		
	}
	
	
}
