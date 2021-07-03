package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	Result add(JobPosting jobPosting);
	Result update(JobPosting jobPosting);
	Result updateJobPostingStatusToInactive(int id);
	Result updateJobPostingStatusToActive(int id);
	DataResult<List<JobPosting>> getAll();
	DataResult<List<JobPosting>> getAllSortedDesc();
	DataResult<List<JobPosting>> getAllSortedAsc();
	DataResult<List<JobPosting>> getByStatus(boolean jobPostingStatus);
	DataResult<List<JobPosting>> getAllStatusIsActiveSortedByDesc();
	DataResult<List<JobPosting>> getAllStatusIsActiveSortedByAsc();
	DataResult<List<JobPosting>> getByUserIdStatusActive(int userId);
}
