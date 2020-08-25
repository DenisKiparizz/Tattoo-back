package com.tattoo.com.mapper;

import com.tattoo.com.dto.RoleDto;
import com.tattoo.com.dto.UserDto;
import com.tattoo.com.entity.user.Role;
import com.tattoo.com.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoleMapper {

    public final ModelMapper modelMapper;

    public RoleDto toDto(Role role) {
        RoleDto roleDto = modelMapper.map(role, RoleDto.class);
        roleDto.setRole(role.getName().name());
        return roleDto;
    }

    public Set<RoleDto> mapListToDto(Set<Role> users) {
        return users.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
    }
}
