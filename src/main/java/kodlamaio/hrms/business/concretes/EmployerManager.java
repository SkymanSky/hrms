package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.validations.SentValidationMessageService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private SentValidationMessageService sentValidationMessageService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, SentValidationMessageService sentValidationMessageService) {
		super();
		this.employerDao = employerDao;
		this.sentValidationMessageService = sentValidationMessageService;
	}

	@Override
	public Result add(Employer employer) {
		if (employer.getWebSite()!="" && employer.getCompanyName()!= "" && employer.getPassword() != ""
				&& employer.getPasswordValidate() != "" && employer.getTelno() !=""
				&& employer.getEmail() != "") {

			

			if (this.findByEmail(employer).getData() != null) {
				return new ErrorResult("Your email is in the system.");
			}
			
			String[] emailDomain = employer.getEmail().split("@");
			String[] webDomain = employer.getWebSite().split("www.");

			
			System.out.println(emailDomain[1]);
			System.out.println(webDomain[1]);

			if (webDomain[1].equals(emailDomain[1])) {
				this.employerDao.save(employer);
				return this.sentValidationMessageService.sentEmail(employer);
			}else {

				return new ErrorResult("Please use your company email.");
			}

		} else {
			return new ErrorResult("You should complete all required areas");
		}
	}

	@Override
	public DataResult<List<Employer>> getall() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employers listed.");
	}

	@Override
	public DataResult<Employer> findByEmail(Employer employer) {
		
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(employer.getEmail()),"Employers listed.");
	}

}
