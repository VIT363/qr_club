package org.example.qr_club.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.qr_club.dto.ParticipantRequest;
import org.example.qr_club.dto.ParticipantResponse;
import org.example.qr_club.service.ParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.example.qr_club.constants.ApiPaths.*;

@RestController
@RequestMapping(PARTICIPANTS)
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParticipantResponse create(@Valid @RequestBody ParticipantRequest request) {
        return participantService.create(request);
    }

    @PutMapping(ID_PATCH)
    public ParticipantResponse update(@PathVariable Long id, @Valid @RequestBody ParticipantRequest request) {
        return participantService.update(id, request);
    }

    @DeleteMapping(ID_PATCH)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        participantService.delete(id);
    }
}


