package ru.vladigeras.springjooqopenshift.service;

import java.util.List;
import ru.vladigeras.springjooqopenshift.model.dto.CarDto;
import ru.vladigeras.springjooqopenshift.model.dto.CreateCarDto;
import ru.vladigeras.springjooqopenshift.model.enumeration.CountryCode;

public interface CarService {

	void create(CreateCarDto createCarDto);

	List<CarDto> get(CountryCode country);
}
