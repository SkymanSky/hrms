package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCvDetailDto {
	//private int id;
	private int jobSeekerid;
	private String name;
	private int startYear;
	private int endYear;
	private String companyName;
	private String positionDescription;
	private int startYearExperience;
	private int endYearExperience;

}
