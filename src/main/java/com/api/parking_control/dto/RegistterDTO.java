package com.api.parking_control.dto;

import com.api.parking_control.models.UserRole;

public record RegistterDTO(String login, String password, UserRole role) {
}
