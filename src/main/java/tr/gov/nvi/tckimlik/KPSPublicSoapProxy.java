package tr.gov.nvi.tckimlik;

import org.springframework.stereotype.Service;


import kodlamaio.hrms.entities.concretes.JobSeeker;
@Service
public class KPSPublicSoapProxy {
	final String tcKimlikNo="123456";
	final String tcKimlikNo2="123456";
	
	public boolean tcKimlikDogula(JobSeeker jobSeeker) {
		
		if(jobSeeker.getTcno().equals(tcKimlikNo)) {
			return true;
		}else {
			return false;
		}
	}

}
