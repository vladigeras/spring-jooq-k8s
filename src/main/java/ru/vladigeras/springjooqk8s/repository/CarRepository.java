package ru.vladigeras.springjooqk8s.repository;

import java.util.List;
import ru.vladigeras.springjooqk8s.model.dto.CreateCarDto;
import ru.vladigeras.springjooqk8s.model.entity.CarEntity;
import ru.vladigeras.springjooqk8s.model.enumeration.CountryCode;

public interface CarRepository {

	void save(CreateCarDto createCarDto);

	List<CarEntity> findAll();

	List<CarEntity> findAllByCountryCode(CountryCode country);
}
