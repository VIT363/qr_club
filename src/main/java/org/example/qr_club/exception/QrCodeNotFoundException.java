package org.example.qr_club.exception;

import java.util.UUID;

public class QrCodeNotFoundException extends RuntimeException {
    public QrCodeNotFoundException(UUID qrUuid) {
        super("QR- код по этому id " + qrUuid + "  не найден");
    }
}
