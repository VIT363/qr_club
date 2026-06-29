package org.example.qr_club.dto;

public record ParticipantResponse(
        Long id,
        String firstName,
        String lastName,
        String middleName) {
}