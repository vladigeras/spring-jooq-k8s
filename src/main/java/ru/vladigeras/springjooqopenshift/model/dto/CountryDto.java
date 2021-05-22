package ru.vladigeras.springjooqopenshift.model.dto;

import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.vladigeras.springjooqopenshift.model.enumeration.CountryCode;

@Getter
@RequiredArgsConstructor
public class CountryDto {

	private final String id;
	private final OffsetDateTime createdAt;
	private final String title;
	private final CountryCode code;
}
