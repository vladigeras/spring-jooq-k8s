package ru.vladigeras.springjooqopenshift.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.vladigeras.springjooqopenshift.model.dto.CountryDto;
import ru.vladigeras.springjooqopenshift.tables.pojos.Countries;

@Mapper
public interface CountryMapper {

	@Mapping(target = "id", source = "country.id")
	@Mapping(target = "createdAt", source = "country.createdAt")
	@Mapping(target = "title", source = "country.title")
	@Mapping(target = "code", source = "country.code")
	@BeanMapping(ignoreByDefault = true)
	CountryDto map(Countries country);
}
