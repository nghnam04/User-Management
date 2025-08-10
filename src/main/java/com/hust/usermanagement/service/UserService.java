package com.hust.usermanagement.service;

import com.hust.usermanagement.dto.UserDto;
import com.hust.usermanagement.entity.User;
import com.hust.usermanagement.mapper.UserMapper;
import com.hust.usermanagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto createUser(UserDto user){
        User user1 = UserMapper.mapToUser(user);
        User savedUser = userRepository.save(user1);
        UserDto user2 = UserMapper.mapToUserDto(savedUser);
        return user2;
    }

    public UserDto getUserById(Long id){
        User user = userRepository.findById(id).get();
        return UserMapper.mapToUserDto(user);
    }

    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    public UserDto updateUser(Long id, UserDto user){
        User existUser = userRepository.findById(id).get();
        existUser.setFirstName(user.getFirstName());
        existUser.setLastName(user.getLastName());
        existUser.setEmail(user.getEmail());
        return UserMapper.mapToUserDto(userRepository.save(existUser));
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
