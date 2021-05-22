package ru.vladigeras.springjooqopenshift.repository;

import java.util.List;
import ru.vladigeras.springjooqopenshift.model.dto.CreateCarDto;
import ru.vladigeras.springjooqopenshift.model.enumeration.CountryCode;
import ru.vladigeras.springjooqopenshift.tables.pojos.Cars;

public interface CarRepository {

	void save(CreateCarDto createCarDto);

	List<Cars> findAll();

	List<Cars> findAllByCountryCode(CountryCode country);
}
