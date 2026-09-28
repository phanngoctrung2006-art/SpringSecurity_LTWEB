package web.com.service;

import web.com.dto.UserDTO;

public interface UserService {
    UserDTO findById(Long id);
}
