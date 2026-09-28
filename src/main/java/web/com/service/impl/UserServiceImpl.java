package web.com.service.impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import web.com.dto.UserDTO;
import web.com.entity.User;
import web.com.mapper.UserMapper;
import web.com.repository.UserRepository;
import web.com.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.toDTO(user);
    }
}
