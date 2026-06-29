package org.example.qr_club.service;

import lombok.RequiredArgsConstructor;
import org.example.qr_club.dto.ParticipantRequest;
import org.example.qr_club.dto.ParticipantResponse;
import org.example.qr_club.exception.ParticipantNotFoundException;
import org.example.qr_club.mapper.ParticipantMapper;
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
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final QrCodeRepository qrCodeRepository;
    private final ParticipantMapper participantMapper;

    public ParticipantResponse create(ParticipantRequest request) {
        Participant participant = participantMapper.toEntity(request);
        QrCode qrCode = new QrCode();
        qrCode.setQrUuid(UUID.randomUUID());
        participant.setQrCode(qrCode);
        qrCode.setParticipant(participant);
        Participant saved = participantRepository.save(participant);
        return participantMapper.toResponse(saved);
    }

    public void updateByQrUuid(UUID qrUuid, ParticipantRequest request) {
        QrCode qrCode = qrCodeRepository.findByQrUuid(qrUuid)
                .orElseThrow(() -> new ParticipantNotFoundException("Участник с QR-кодом " + qrUuid + " не найден"));
        Participant participant = qrCode.getParticipant();
        participant.setFirstName(request.firstName());
        participant.setLastName(request.lastName());
        participant.setMiddleName(request.middleName());
        participantRepository.save(participant);
    }

    public void deleteByQrUuid(UUID qrUuid) {
        QrCode qrCode = qrCodeRepository.findByQrUuid(qrUuid)
                .orElseThrow(() -> new ParticipantNotFoundException("Участник с QR-кодом " + qrUuid + " не найден"));
        participantRepository.delete(qrCode.getParticipant());
    }
}