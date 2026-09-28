package web.com.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import web.com.dto.UserDTO;
import web.com.entity.Role;
import web.com.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-28T10:17:42+0700",
    comments = "version: 1.6.3, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setRoleId( entityRoleId( entity ) );
        userDTO.setRoleName( entityRoleName( entity ) );
        userDTO.setId( entity.getId() );
        userDTO.setEmail( entity.getEmail() );
        userDTO.setFullName( entity.getFullName() );
        userDTO.setEnabled( entity.isEnabled() );
        userDTO.setCreatedAt( entity.getCreatedAt() );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setEmail( dto.getEmail() );
        user.setFullName( dto.getFullName() );
        user.setEnabled( dto.isEnabled() );
        user.setCreatedAt( dto.getCreatedAt() );

        return user;
    }

    private Long entityRoleId(User user) {
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        return role.getId();
    }

    private String entityRoleName(User user) {
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        return role.getName();
    }
}
