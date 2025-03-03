/**

Project: AUTORESCUE
Copyright (c) nttdata 2024 

*/
package autorescue.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@SuperBuilder
@NoArgsConstructor
public class SendFormRequest {

	@JsonProperty("carPlate")
	private String carPlate;

	@JsonProperty("description")
	private String description;

	@JsonProperty("idDocument")
	private String idDocument;

	@JsonProperty("name")
	private String name;

}
