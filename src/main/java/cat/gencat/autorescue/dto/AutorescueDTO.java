/**

Project: AUTORESCUE
Copyright (c) nttdata 2024 

*/
package cat.gencat.autorescue.dto;

import java.io.Serializable;

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
public class AutorescueDTO implements Serializable {
	private static final long serialVersionUID = -2278478421931544957L;

	@JsonProperty("name")
	private String name;
}
