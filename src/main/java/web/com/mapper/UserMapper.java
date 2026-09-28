package web.com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import web.com.dto.UserDTO;
import web.com.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "roleName", source = "role.name")
    UserDTO toDTO(User user);
}