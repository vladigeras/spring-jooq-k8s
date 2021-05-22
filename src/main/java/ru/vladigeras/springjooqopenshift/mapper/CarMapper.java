package ru.vladigeras.springjooqopenshift.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.vladigeras.springjooqopenshift.model.dto.CarDto;
import ru.vladigeras.springjooqopenshift.model.entity.CarEntity;

@Mapper
public interface CarMapper {

	@Mapping(target = "id", source = "car.id")
	@Mapping(target = "createdAt", source = "car.createdAt")
	@Mapping(target = "title", source = "car.title")
	@Mapping(target = "price", source = "car.price")
	@Mapping(target = "country.id", source = "car.country.id")
	@Mapping(target = "country.createdAt", source = "car.country.createdAt")
	@Mapping(target = "country.title", source = "car.country.title")
	@Mapping(target = "country.code", source = "car.country.code")
	@BeanMapping(ignoreByDefault = true)
	CarDto map(CarEntity car);
}
