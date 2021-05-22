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
import ru.vladigeras.springjooqopenshift.model.enumeration.CountryCode;
import ru.vladigeras.springjooqopenshift.repository.CarRepository;
import ru.vladigeras.springjooqopenshift.tables.pojos.Cars;

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
	public List<Cars> findAll() {
		// TODO: fetch child entity
		return dslContext.selectFrom(CARS).fetchInto(Cars.class);
	}

	@Override
	public List<Cars> findAllByCountryCode(CountryCode country) {
		// TODO: fetch child entity
		return dslContext.select().from(CARS).join(COUNTRIES).on(CARS.COUNTRY_ID.eq(COUNTRIES.ID))
			.where(COUNTRIES.CODE.eq(country.name()))
			.fetchInto(Cars.class);
	}
}
