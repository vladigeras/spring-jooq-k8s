package ru.vladigeras.springjooqopenshift.repository;

import java.util.List;
import ru.vladigeras.springjooqopenshift.model.dto.CreateCarDto;
import ru.vladigeras.springjooqopenshift.model.entity.CarEntity;
import ru.vladigeras.springjooqopenshift.model.enumeration.CountryCode;

public interface CarRepository {

	void save(CreateCarDto createCarDto);

	List<CarEntity> findAll();

	List<CarEntity> findAllByCountryCode(CountryCode country);
}
