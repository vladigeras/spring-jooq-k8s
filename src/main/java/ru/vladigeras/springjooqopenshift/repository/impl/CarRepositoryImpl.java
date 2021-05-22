package ru.vladigeras.springjooqopenshift.repository.impl;

import static ru.vladigeras.springjooqopenshift.Tables.CARS;
import static ru.vladigeras.springjooqopenshift.Tables.COUNTRIES;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.vladigeras.springjooqopenshift.model.dto.CreateCarDto;
import ru.vladigeras.springjooqopenshift.model.entity.CarEntity;
import ru.vladigeras.springjooqopenshift.model.enumeration.CountryCode;
import ru.vladigeras.springjooqopenshift.repository.CarRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CarRepositoryImpl implements CarRepository {

	private final DSLContext dslContext;

	@Override
	public void save(CreateCarDto createCarDto) {
		dslContext.insertInto(CARS, CARS.CREATED_AT, CARS.TITLE, CARS.PRICE, CARS.COUNTRY_ID)
			.values(OffsetDateTime.now(), createCarDto.getTitle(), createCarDto.getPrice(),
				createCarDto.getCountryId()).execute();
	}

	@Override
	public List<CarEntity> findAll() {
		return dslContext.select(CARS.fields())
			.select(COUNTRIES.ID.as("country.id"), COUNTRIES.CREATED_AT.as("country.createdAt"),
				COUNTRIES.TITLE.as("country.title"), COUNTRIES.CODE.as("country.code"))
			.from(CARS).join(COUNTRIES)
			.on(CARS.COUNTRY_ID.eq(COUNTRIES.ID)).fetchInto(CarEntity.class);
	}

	@Override
	public List<CarEntity> findAllByCountryCode(CountryCode country) {
		return dslContext.select(CARS.fields())
			.select(COUNTRIES.ID.as("country.id"), COUNTRIES.CREATED_AT.as("country.createdAt"),
				COUNTRIES.TITLE.as("country.title"), COUNTRIES.CODE.as("country.code"))
			.from(CARS).join(COUNTRIES)
			.on(CARS.COUNTRY_ID.eq(COUNTRIES.ID))
			.where(COUNTRIES.CODE.eq(country.name()))
			.fetchInto(CarEntity.class);
	}
}
