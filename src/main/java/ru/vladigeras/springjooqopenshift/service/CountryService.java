package ru.vladigeras.springjooqopenshift.service;

import java.util.List;
import ru.vladigeras.springjooqopenshift.model.dto.CountryDto;
import ru.vladigeras.springjooqopenshift.model.dto.CreateCountryDto;

public interface CountryService {

	void create(CreateCountryDto createCountryDto);

	List<CountryDto> get();
}
