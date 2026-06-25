package org.example.qr_club.exception;

public class QrCodeNotFoundException extends RuntimeException {
    public QrCodeNotFoundException(Long id) {
        super("QR- код по этому id " + id + "  не найден");
    }
}
