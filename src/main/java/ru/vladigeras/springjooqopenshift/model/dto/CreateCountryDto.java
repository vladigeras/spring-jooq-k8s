package ru.vladigeras.springjooqopenshift.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vladigeras.springjooqopenshift.model.enumeration.CountryCode;

@Getter
@Setter
@NoArgsConstructor
public class CreateCountryDto {

	private String title;
	private CountryCode code;
}
