package ru.vladigeras.springjooqk8s.service;

import java.util.List;
import ru.vladigeras.springjooqk8s.model.dto.CarDto;
import ru.vladigeras.springjooqk8s.model.dto.CreateCarDto;
import ru.vladigeras.springjooqk8s.model.enumeration.CountryCode;

public interface CarService {

	void create(CreateCarDto createCarDto);

	List<CarDto> get(CountryCode country);
}
