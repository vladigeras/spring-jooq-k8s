package ru.vladigeras.springjooqopenshift.model.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCarDto {

	private String title;
	private BigDecimal price;
	private String countryId;
}
