package com.crossasyst.mapper;

import com.crossasyst.entity.AddressEntity;
import com.crossasyst.entity.PersonEntity;
import com.crossasyst.model.AddressRequest;
import com.crossasyst.model.PersonRequest;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    public List<PersonRequest> toModels(List<PersonEntity> personEntityList);
    public PersonRequest toModel(PersonEntity personEntity);
    public PersonEntity toEntity(PersonRequest personRequest);

    public AddressEntity addressRequestToAddressEntity(AddressRequest addressRequest);
}
