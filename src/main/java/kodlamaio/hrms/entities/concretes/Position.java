package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="positions")

public class Position {

	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="position_name")
	private String positionName;
	
	public Position() {}
	
	
}
