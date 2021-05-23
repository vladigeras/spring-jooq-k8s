package ru.vladigeras.springjooqk8s.model.dto;

import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.vladigeras.springjooqk8s.model.enumeration.CountryCode;

@Getter
@RequiredArgsConstructor
public class CountryDto {

	private final String id;
	private final OffsetDateTime createdAt;
	private final String title;
	private final CountryCode code;
}
