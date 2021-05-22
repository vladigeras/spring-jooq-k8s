package ru.vladigeras.springjooqopenshift.repository.impl;

import static java.util.Objects.nonNull;
import static ru.vladigeras.springjooqopenshift.Tables.COUNTRIES;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.vladigeras.springjooqopenshift.model.dto.CreateCountryDto;
import ru.vladigeras.springjooqopenshift.repository.CountryRepository;
import ru.vladigeras.springjooqopenshift.tables.pojos.Countries;
import ru.vladigeras.springjooqopenshift.tables.records.CountriesRecord;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CountryRepositoryImpl implements CountryRepository {

	private final DSLContext dslContext;

	@Override
	public void create(CreateCountryDto createCountryDto) {
		dslContext.insertInto(COUNTRIES, COUNTRIES.CREATED_AT, COUNTRIES.TITLE, COUNTRIES.CODE)
			.values(OffsetDateTime.now(), createCountryDto.getTitle(),
				createCountryDto.getCode().name())
			.execute();
	}

	@Override
	public List<Countries> findAll() {
		return dslContext.selectFrom(COUNTRIES).fetchInto(Countries.class);
	}

	@Override
	public Optional<Countries> findById(String id) {
		CountriesRecord countryRecord = dslContext.selectFrom(COUNTRIES)
			.where(COUNTRIES.ID.equal(id)).fetchOne();
		return nonNull(countryRecord) ? Optional.of(countryRecord.into(Countries.class))
			: Optional.empty();
	}
}
