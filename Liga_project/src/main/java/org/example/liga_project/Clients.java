package org.example.liga_project;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record Clients(
        Long id,
        @NotBlank
        String full_name,
        ClientGender gender,
        ClientStatus status,
        LocalDateTime date_of_create,
        LocalDateTime date_of_update
){



}
