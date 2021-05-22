package ru.vladigeras.springjooqopenshift.model.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarEntity {

	private String id;
	private OffsetDateTime createdAt;
	private BigDecimal price;
	private String title;
	private CountryEntity country;
}
