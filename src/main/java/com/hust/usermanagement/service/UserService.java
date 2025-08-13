package com.hust.usermanagement.service;

import com.hust.usermanagement.dto.UserDto;
import com.hust.usermanagement.entity.User;
import com.hust.usermanagement.exception.EmailAlreadyExistsException;
import com.hust.usermanagement.exception.ResourceNotFoundException;
import com.hust.usermanagement.mapper.AutoUserMapper;
import com.hust.usermanagement.mapper.UserMapper;
import com.hust.usermanagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    public UserDto createUser(UserDto user){
//        User user1 = UserMapper.mapToUser(user);
//        User user1 = modelMapper.map(user, User.class);
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email for this User already exists");
        }
        User user1 = AutoUserMapper.MAPPER.mapToUser(user);

        User savedUser = userRepository.save(user1);

//        UserDto user2 = UserMapper.mapToUserDto(savedUser);
//        UserDto user2 = modelMapper.map(savedUser, UserDto.class);
        UserDto user2 = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        return user2;
    }

    public UserDto getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
//        return UserMapper.mapToUserDto(user);
//        return modelMapper.map(user, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
//        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return users.stream().map(user -> AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    public UserDto updateUser(Long id, UserDto user){
        User existUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email for this User already exists");
        }

        existUser.setFirstName(user.getFirstName());
        existUser.setLastName(user.getLastName());
        existUser.setEmail(user.getEmail());
//        return UserMapper.mapToUserDto(userRepository.save(existUser));
//        return modelMapper.map(userRepository.save(existUser), UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(userRepository.save(existUser));
    }

    public void deleteUser(Long id){
        User existUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(id);
    }
}
