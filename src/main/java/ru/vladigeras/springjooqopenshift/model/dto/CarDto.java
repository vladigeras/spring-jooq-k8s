package ru.vladigeras.springjooqopenshift.model.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CarDto {

	private final String id;
	private final OffsetDateTime createdAt;
	private final String title;
	private final BigDecimal price;
	private final CountryDto country;
}
