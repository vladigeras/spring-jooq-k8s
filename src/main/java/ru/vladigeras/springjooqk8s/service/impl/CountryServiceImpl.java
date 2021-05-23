package ru.vladigeras.springjooqk8s.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vladigeras.springjooqk8s.mapper.CountryMapper;
import ru.vladigeras.springjooqk8s.model.dto.CountryDto;
import ru.vladigeras.springjooqk8s.model.dto.CreateCountryDto;
import ru.vladigeras.springjooqk8s.repository.CountryRepository;
import ru.vladigeras.springjooqk8s.service.CountryService;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

	private final CountryRepository countryRepository;
	private final CountryMapper countryMapper;

	@Override
	public void create(CreateCountryDto createCountryDto) {
		countryRepository.create(createCountryDto);
	}

	@Override
	public List<CountryDto> get() {
		return countryRepository.findAll().stream().map(countryMapper::map)
			.collect(Collectors.toList());
	}
}
