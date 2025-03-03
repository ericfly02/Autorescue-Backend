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
public class Center {

	@JsonProperty("areaType")
	private String areaType;

	@JsonProperty("center")
	private Center center;

	@JsonProperty("radius")
	private String radius;
}
