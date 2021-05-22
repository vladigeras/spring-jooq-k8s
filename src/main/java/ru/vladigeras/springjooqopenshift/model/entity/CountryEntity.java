package ru.vladigeras.springjooqopenshift.model.entity;

import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryEntity {

	private String id;
	private OffsetDateTime createdAt;
	private String title;
	private String code;
}
