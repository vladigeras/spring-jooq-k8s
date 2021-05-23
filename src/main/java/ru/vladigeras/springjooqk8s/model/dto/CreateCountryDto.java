package ru.vladigeras.springjooqk8s.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vladigeras.springjooqk8s.model.enumeration.CountryCode;

@Getter
@Setter
@NoArgsConstructor
public class CreateCountryDto {

	private String title;
	private CountryCode code;
}
