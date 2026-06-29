package org.example.qr_club.mapper;

import org.example.qr_club.dto.ParticipantRequest;
import org.example.qr_club.dto.ParticipantResponse;
import org.example.qr_club.model.Participant;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {

    public Participant toEntity(ParticipantRequest request) {
        Participant participant = new Participant();
        participant.setFirstName(request.firstName());
        participant.setLastName(request.lastName());
        participant.setMiddleName(request.middleName());
        return participant;
    }

    public ParticipantResponse toResponse(Participant participant) {
        return new ParticipantResponse(participant.getId(),
                participant.getFirstName(),
                participant.getLastName(),
                participant.getMiddleName());
    }
}
