package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_postings")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class JobPosting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="position_id")
	private int positionId;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="salary_max")
	private Double salaryMax;
	
	@Column(name="salary_min")
	private Double salaryMin;
	
	@Column(name="open_position_qty")
	private int openPositionQuantity;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="job_posting_status")
	private boolean jobPostingStatus;
	
	
}
