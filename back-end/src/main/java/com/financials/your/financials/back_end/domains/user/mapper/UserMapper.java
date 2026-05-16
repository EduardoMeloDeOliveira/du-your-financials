package com.financials.your.financials.back_end.domains.user.mapper;

import com.financials.your.financials.back_end.domains.user.dto.UserResponseDTO;
import com.financials.your.financials.back_end.domains.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toUserResponseDTO(User user);

}
