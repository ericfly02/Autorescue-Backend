/**
 * Project: AUTORESCUE

 */
package autorescue.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AUTORESCUE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Autorescue {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTORRESCUE_SQ")
	@SequenceGenerator(name = "AUTORRESCUE_SQ", sequenceName = "AUTORRESCUE_SQ", allocationSize = 1)
	@Column(name = "AUTORESCUE_ID")
	private Long id;

	@Column(name = "SERIAL_NUMBER")
	private String serialNumber;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "CAR_PLATE")
	private String carPlate;

}
