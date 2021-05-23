package ru.vladigeras.springjooqk8s.service.impl;

import static java.lang.String.format;
import static java.util.Objects.nonNull;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vladigeras.springjooqk8s.mapper.CarMapper;
import ru.vladigeras.springjooqk8s.model.dto.CarDto;
import ru.vladigeras.springjooqk8s.model.dto.CreateCarDto;
import ru.vladigeras.springjooqk8s.model.entity.CarEntity;
import ru.vladigeras.springjooqk8s.model.enumeration.CountryCode;
import ru.vladigeras.springjooqk8s.repository.CarRepository;
import ru.vladigeras.springjooqk8s.repository.CountryRepository;
import ru.vladigeras.springjooqk8s.service.CarService;

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
