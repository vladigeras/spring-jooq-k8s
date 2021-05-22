package ru.vladigeras.springjooqopenshift.service.impl;

import static java.lang.String.format;
import static java.util.Objects.nonNull;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vladigeras.springjooqopenshift.mapper.CarMapper;
import ru.vladigeras.springjooqopenshift.model.dto.CarDto;
import ru.vladigeras.springjooqopenshift.model.dto.CreateCarDto;
import ru.vladigeras.springjooqopenshift.model.entity.CarEntity;
import ru.vladigeras.springjooqopenshift.model.enumeration.CountryCode;
import ru.vladigeras.springjooqopenshift.repository.CarRepository;
import ru.vladigeras.springjooqopenshift.repository.CountryRepository;
import ru.vladigeras.springjooqopenshift.service.CarService;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

	private final CarRepository carRepository;
	private final CountryRepository countryRepository;
	private final CarMapper carMapper;

	@Override
	public void create(CreateCarDto createCarDto) {
		String countryId = createCarDto.getCountryId();
		if (countryRepository.findById(countryId).isEmpty()) {
			throw new RuntimeException(format("Country with id %s is not found", countryId));
		}
		carRepository.save(createCarDto);
	}

	@Override
	public List<CarDto> get(CountryCode country) {
		List<CarEntity> result;
		if (nonNull(country)) {
			result = carRepository.findAllByCountryCode(country);
		} else {
			result = carRepository.findAll();
		}
		return result.stream().map(carMapper::map).collect(Collectors.toList());
	}
}
