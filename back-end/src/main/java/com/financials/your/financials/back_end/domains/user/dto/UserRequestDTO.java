package com.financials.your.financials.back_end.domains.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(

        @NotBlank(message = "o nome é obrigatório")
        String name,
        @NotBlank(message = "o email é obrigatório")
        @Email(message = "Formato de e-mail inválido")
        String email,
        @NotBlank(message = "a senha é obrigatória")
        String password

        ) {
}
