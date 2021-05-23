package ru.vladigeras.springjooqk8s.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.vladigeras.springjooqk8s.model.dto.CarDto;
import ru.vladigeras.springjooqk8s.model.dto.CreateCarDto;
import ru.vladigeras.springjooqk8s.model.enumeration.CountryCode;
import ru.vladigeras.springjooqk8s.service.CarService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cars")
public class CarController {

	private final CarService carService;

	@PostMapping
	@ResponseStatus(CREATED)
	public void create(@RequestBody CreateCarDto createCarDto) {
		carService.create(createCarDto);
	}

	@GetMapping
	@ResponseStatus(OK)
	public List<CarDto> get(@RequestParam(name = "country", required = false) CountryCode country) {
		return carService.get(country);
	}
}
