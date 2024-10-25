package com.blastza.platform.authorization_server.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
@AllArgsConstructor
public class RegistrationResponse {
    private String token;
    private String message;
}
