package org.example.qr_club.service;

import lombok.RequiredArgsConstructor;
import org.example.qr_club.dto.ParticipantRequest;
import org.example.qr_club.dto.ParticipantResponse;
import org.example.qr_club.exception.BadRequestException;
import org.example.qr_club.exception.ParticipantNotFoundException;
import org.example.qr_club.mapper.ParticipantMapper;
import org.example.qr_club.model.Participant;
import org.example.qr_club.model.QrCode;
import org.example.qr_club.repository.ParticipantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ParticipantService {

    private final ParticipantRepository participantRepository;
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

    public List<ParticipantResponse> getAll() {
        return participantRepository.findAll().stream()
                .map(participantMapper::toResponse)
                .toList();
    }

    public ParticipantResponse getById(Long id) {

        if (id == null) {
            throw new BadRequestException("ID не может быть null");
        }

        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(id));

        return participantMapper.toResponse(participant);
    }

    public ParticipantResponse update(Long id, ParticipantRequest request) {

        if (id == null) {
            throw new BadRequestException("ID не может быть null");
        }

        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(id));
        participant.setFirstName(request.firstName());
        participant.setLastName(request.lastName());
        participant.setMiddleName(request.middleName());
        Participant updated = participantRepository.save(participant);
        return participantMapper.toResponse(updated);
    }

    public void delete(Long id) {

        if (id == null) {
            throw new BadRequestException("ID не может быть null");
        }

        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(id));
        participantRepository.delete(participant);

    }
}
