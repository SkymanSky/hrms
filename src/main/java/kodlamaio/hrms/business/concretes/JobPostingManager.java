package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {
	
	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(),"Job Positions Listed");
	}

	@Override
	public Result add(JobPosting jobPosting) {

		if(jobPosting.getJobDescription()!=""
			&& jobPosting.getCityId()!=0 && jobPosting.getOpenPositionQuantity()!=0 && jobPosting.getJobPostDate()!=null) {
			
			this.jobPostingDao.save(jobPosting);
			return new SuccessResult("JobPosting added to system.");
		}else {
			return new ErrorResult("Please fill all required areas.");
		}
	}

	@Override
	public DataResult<List<JobPosting>> getByStatus(boolean jobPostingStatus) {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByStatus(jobPostingStatus),"Job Positions Listed");
	}


	@Override
	public DataResult<List<JobPosting>> getByUserIdStatusActive(int userId) {
		//jobPostingStatus=true;
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByUserIdStatusActive(userId),"Active Jobs Listed By Company Name");
	}

}
