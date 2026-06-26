package org.example.qr_club.dto;

public record AccessResponse(
        Long id,
        String firstName,
        String lastName,
        String middleName) {
}
