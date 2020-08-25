package com.tattoo.com.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private Date created;
    private Set<RoleDto> roleDto;
}
