package ru.vladigeras.springjooqopenshift.repository;

import java.util.List;
import java.util.Optional;
import ru.vladigeras.springjooqopenshift.model.dto.CreateCountryDto;
import ru.vladigeras.springjooqopenshift.tables.pojos.Countries;

public interface CountryRepository {

	void create(CreateCountryDto createCountryDto);

	List<Countries> findAll();

	Optional<Countries> findById(String id);
}
