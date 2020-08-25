package com.tattoo.com.mapper;

import com.tattoo.com.dto.UserDto;
import com.tattoo.com.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public final ModelMapper modelMapper;
    public final RoleMapper roleMapper;

    public UserDto toDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        userDto.setRoleDto(roleMapper.mapListToDto(user.getRoles()));
        return userDto;
    }

    public List<UserDto> mapListToDto(List<User> users) {
        return users.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
