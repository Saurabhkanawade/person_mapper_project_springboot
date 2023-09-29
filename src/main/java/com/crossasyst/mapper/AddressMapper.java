package com.crossasyst.mapper;

import com.crossasyst.entity.AddressEntity;
import com.crossasyst.model.AddressRequest;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    public List<AddressRequest> toModels(List<AddressEntity> addressEntities);
    public AddressRequest toModel(AddressEntity addressEntity);
    public AddressEntity toEntity(AddressRequest addressRequest);
}
