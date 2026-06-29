package org.example.qr_club.service;

import lombok.RequiredArgsConstructor;
import org.example.qr_club.dto.AccessRequest;
import org.example.qr_club.dto.AccessResponse;
import org.example.qr_club.exception.BadRequestException;
import org.example.qr_club.model.Participant;
import org.example.qr_club.model.QrCode;
import org.example.qr_club.repository.QrCodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AccessService {

    private final QrCodeRepository qrCodeRepository;

    public AccessResponse checkAccess(AccessRequest request) {
        UUID receivedUuid = request.uuid();

        QrCode qrCode = qrCodeRepository.findByQrUuid(receivedUuid)
                .orElseThrow(() -> new BadRequestException("Недействительный QR-код"));

        Participant participant = qrCode.getParticipant();

        UUID newUuid = UUID.randomUUID();
        qrCode.setQrUuid(newUuid);
        qrCodeRepository.save(qrCode);

        return new AccessResponse(
                participant.getId(),
                participant.getFirstName(),
                participant.getLastName(),
                participant.getMiddleName()
        );
    }
}
