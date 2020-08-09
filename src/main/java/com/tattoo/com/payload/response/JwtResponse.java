package com.tattoo.com.payload.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class JwtResponse {
    private String accessToken;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private Date created;
    private List<String> roles;

    public JwtResponse(String accessToken,
                       Long id,
                       String username,
                       String email, Date created,
                       List<String> roles) {
        this.accessToken = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.created = created;
        this.roles = roles;
    }
}
