package org.example.qr_club.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.example.qr_club.dto.ParticipantRequest;
import org.example.qr_club.dto.ParticipantResponse;
import org.example.qr_club.service.ParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.example.qr_club.constants.ApiPaths.*;

@RestController
@RequestMapping(PARTICIPANTS)
@RequiredArgsConstructor
@Validated
public class ParticipantController {

    private final ParticipantService participantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParticipantResponse create(@Valid @RequestBody ParticipantRequest request) {
        return participantService.create(request);
    }

    @PutMapping(UUID_PATH)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable @NotNull UUID uuid,
                       @Valid @RequestBody ParticipantRequest request) {
        participantService.updateByQrUuid(uuid, request);
    }

    @DeleteMapping(UUID_PATH)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull UUID uuid) {
        participantService.deleteByQrUuid(uuid);
    }
}