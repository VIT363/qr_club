package org.example.qr_club.service;

import lombok.RequiredArgsConstructor;
import org.example.qr_club.dto.QrCodeResponse;
import org.example.qr_club.exception.BadRequestException;
import org.example.qr_club.exception.ParticipantNotFoundException;
import org.example.qr_club.exception.QrCodeNotFoundException;
import org.example.qr_club.mapper.QrCodeMapper;
import org.example.qr_club.model.Participant;
import org.example.qr_club.model.QrCode;
import org.example.qr_club.repository.ParticipantRepository;
import org.example.qr_club.repository.QrCodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class QrCodeService {

    private final QrCodeRepository qrCodeRepository;
    private final ParticipantRepository participantRepository;
    private final QrCodeMapper qrCodeMapper;

    private QrCodeResponse saveAndMap(QrCode qrCode) {
        qrCode.setQrUuid(UUID.randomUUID());
        QrCode saved = qrCodeRepository.save(qrCode);
        return qrCodeMapper.toResponse(saved);
    }

    public QrCodeResponse createQrCode(Long id) {

        if (id == null) {
            throw new BadRequestException("ID не может быть null");
        }

        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(id));
        if (qrCodeRepository.findByParticipant_Id(id).isPresent()) {
            throw new BadRequestException("QR-код уже существует для этого участника");
        }
        QrCode qrCode = new QrCode();
        qrCode.setParticipant(participant);
        participant.setQrCode(qrCode);
        return saveAndMap(qrCode);
    }

    public QrCodeResponse regenerate(Long qrCodeId) {

        if (qrCodeId == null) {
            throw new BadRequestException("ID не может быть null");
        }

        QrCode qrCode = qrCodeRepository.findById(qrCodeId)
                .orElseThrow(() -> new QrCodeNotFoundException(qrCodeId));
        return saveAndMap(qrCode);
    }

    public void delete(Long qrCodeId) {

        if (qrCodeId == null) {
            throw new BadRequestException("ID не может быть null");
        }

        QrCode qrCode = qrCodeRepository.findById(qrCodeId)
                .orElseThrow(() -> new QrCodeNotFoundException(qrCodeId));
        qrCodeRepository.delete(qrCode);

    }
}
