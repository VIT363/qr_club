package org.example.qr_club.exception;

public class ParticipantNotFoundException extends RuntimeException {

    public ParticipantNotFoundException(Long id) {
        super("Участник с id " + id + " не найден");
    }

    public ParticipantNotFoundException(String message) {
        super(message);
    }
}