package ru.vladigeras.springjooqk8s.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.vladigeras.springjooqk8s.model.dto.CountryDto;
import ru.vladigeras.springjooqk8s.model.dto.CreateCountryDto;
import ru.vladigeras.springjooqk8s.service.CountryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/countries")
public class CountryController {

	private final CountryService countryService;

	@PostMapping
	@ResponseStatus(CREATED)
	public void create(@RequestBody CreateCountryDto createCountryDto) {
		countryService.create(createCountryDto);
	}

	@GetMapping
	@ResponseStatus(OK)
	public List<CountryDto> get() {
		return countryService.get();
	}
}
