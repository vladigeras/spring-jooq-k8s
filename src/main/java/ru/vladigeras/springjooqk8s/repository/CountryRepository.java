package ru.vladigeras.springjooqk8s.repository;

import java.util.List;
import java.util.Optional;
import ru.vladigeras.springjooqk8s.model.dto.CreateCountryDto;
import ru.vladigeras.springjooqk8s.tables.pojos.Countries;

public interface CountryRepository {

	void create(CreateCountryDto createCountryDto);

	List<Countries> findAll();

	Optional<Countries> findById(String id);
}
