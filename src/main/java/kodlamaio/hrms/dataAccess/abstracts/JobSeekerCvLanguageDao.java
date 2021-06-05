package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerCvLanguage;

public interface JobSeekerCvLanguageDao extends JpaRepository<JobSeekerCvLanguage, Integer> {

}
