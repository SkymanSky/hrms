package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
//		if(jobPosting.getJobDescription()!=""
//			&& jobPosting.getCityId()!=0 && jobPosting.getOpenPositionQuantity()!=0 && jobPosting.getJobPostDate()!=null) {
//			
			this.jobPostingDao.save(jobPosting);
			return new SuccessResult("JobPosting added to system.");
//		}else {
//			return new ErrorResult("Please fill all required areas.");
//		}
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

	@Override
	public DataResult<List<JobPosting>> getAllSortedDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC,"jobPostDate");
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(sort),"All Jobs Sorted By Job Post Date - Desc");
	}
	
	@Override
	public DataResult<List<JobPosting>> getAllSortedAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC,"jobPostDate");
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(sort),"All Jobs Sorted By Job Post Date - Asc");
	}

	@Override
	public DataResult<List<JobPosting>> getAllStatusIsActiveSortedByDesc() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllStatusIsActiveSortedByDesc(),"All Active Jobs Sorted By Job Post Date - Desc");
	}

	@Override
	public DataResult<List<JobPosting>> getAllStatusIsActiveSortedByAsc() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllStatusIsActiveSortedByAsc(),"All Active Jobs Sorted By Job Post Date - Asc");
		
	}

	@Override
	public Result update(JobPosting jobPosting) {
		
		jobPosting.setJobPostingStatus(false);
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("Job Posting updated - Status:Deactivated");
	}


	@Override
	public Result updateJobPostingStatusToInactive(int id) {
		this.jobPostingDao.updateJobPostingStatusToInactive(id);
		return new SuccessResult("JobPosting is closed.");
	}

	@Override
	public Result updateJobPostingStatusToActive(int id) {
		this.jobPostingDao.updateJobPostingStatusToActive(id);
		return new SuccessResult("JobPosting is opened");
	}
	

}
