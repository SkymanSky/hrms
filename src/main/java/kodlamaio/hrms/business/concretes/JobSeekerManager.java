package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.validations.SentValidationMessageService;
import kodlamaio.hrms.core.utilities.validations.TcKimlikNoValidationService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDetailDto;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private TcKimlikNoValidationService tcKimlikNoValidationService;
	private SentValidationMessageService sentValidationMessageService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, 
			TcKimlikNoValidationService tcKimlikNoValidationService,
			SentValidationMessageService sentValidationMessageService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.tcKimlikNoValidationService = tcKimlikNoValidationService;
		this.sentValidationMessageService=sentValidationMessageService;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {

		if (jobSeeker.getFirstName() != "" && jobSeeker.getLastName() != ""
				&& jobSeeker.getBirthDate().toLocaleString() != "" && jobSeeker.getTcno() != ""
				&& jobSeeker.getPassword() != "" && jobSeeker.getPasswordValidate() != "") {

			if (this.findByEmail(jobSeeker).getData() != null) {
				return new ErrorResult("Your email is in the system.");
			}

			if (this.findByTcno(jobSeeker).getData() != null) {
				return new ErrorResult("Your national identity is exists on our system.");
			}

			if (tcKimlikNoValidationService.tcKimlikNoValidator(jobSeeker)) {
				this.jobSeekerDao.save(jobSeeker);
				return this.sentValidationMessageService.sentEmail(jobSeeker);
				
				
			} else {
				return new ErrorResult("Your tcno is not valid.");
			}

		} else {
			return new ErrorResult("You should complete all required areas");

		}

	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {

		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Job seekers listed");
	}

	@Override
	public DataResult<JobSeeker> findByTcno(JobSeeker jobSeeker) {

		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByTcno(jobSeeker.getTcno()),
				"Job seekers listed");

	}

	@Override
	public DataResult<JobSeeker> findByEmail(JobSeeker jobSeeker) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByEmail(jobSeeker.getEmail()),
				"Job seekers listed");
	}

	@Override
	public DataResult<List<JobSeekerCvDetailDto>> getJobSeekerWithExperienceDetails() {
		return new SuccessDataResult<List<JobSeekerCvDetailDto>>(this.jobSeekerDao.getJobSeekerWithExperienceDetails(), "Job seekers listed");
	}

	@Override
	public DataResult<JobSeeker> findByUserId(int userId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByJobSeekerId(userId),
				"Job seekers listed");
	}

}
