package com.financials.your.financials.back_end.domains.user.dto;

import com.financials.your.financials.back_end.domains.user.enums.Role;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponseDTO(
        UUID userId,
        String name,
        String email,
        Role role,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
