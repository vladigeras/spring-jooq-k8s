package ru.vladigeras.springjooqopenshift.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.vladigeras.springjooqopenshift.model.dto.CarDto;
import ru.vladigeras.springjooqopenshift.tables.pojos.Cars;

@Mapper
public interface CarMapper {

	@Mapping(target = "id", source = "car.id")
	@Mapping(target = "createdAt", source = "car.createdAt")
	@Mapping(target = "title", source = "car.title")
	@Mapping(target = "price", source = "car.price")
	@Mapping(target = "country.id", source = "car.countryId")
	@BeanMapping(ignoreByDefault = true)
	CarDto map(Cars car);
}
