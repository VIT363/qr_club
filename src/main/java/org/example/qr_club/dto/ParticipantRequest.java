package org.example.qr_club.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ParticipantRequest(@NotBlank @Size(max = 50) String firstName,
                                 @NotBlank @Size(max = 50) String lastName,
                                 @Size(max = 50) String middleName) {
}
