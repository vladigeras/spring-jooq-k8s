package ru.vladigeras.springjooqk8s.service;

import java.util.List;
import ru.vladigeras.springjooqk8s.model.dto.CountryDto;
import ru.vladigeras.springjooqk8s.model.dto.CreateCountryDto;

public interface CountryService {

	void create(CreateCountryDto createCountryDto);

	List<CountryDto> get();
}
