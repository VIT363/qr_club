package org.example.qr_club.dto;

import java.util.UUID;

public record QrCodeResponse(Long id, Long participantId, UUID qrUuid) {
}
