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
@Table(name = "FORM_DATA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormData {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FORM_DATA_SQ")
	@SequenceGenerator(name = "FORM_DATA_SQ", sequenceName = "FORM_DATA_SQ", allocationSize = 1)
	@Column(name = "form_data_id")
	private Long id;

	@Column(name = "ID_DOCUMENT")
	private String idDocument;

	@Column(name = "CAR_PLATE")
	private String carPlate;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

}
