package org.example.qr_club.mapper;

import org.example.qr_club.dto.QrCodeResponse;
import org.example.qr_club.model.QrCode;
import org.springframework.stereotype.Component;

@Component
public class QrCodeMapper {

    public QrCodeResponse toResponse(QrCode qrCode) {
        return new QrCodeResponse(qrCode.getId(),
                qrCode.getParticipant().getId(),
                qrCode.getQrUuid());
    }
}
