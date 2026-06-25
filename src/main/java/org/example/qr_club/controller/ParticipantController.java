package org.example.qr_club.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.qr_club.dto.ParticipantRequest;
import org.example.qr_club.dto.ParticipantResponse;
import org.example.qr_club.service.ParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParticipantResponse create(@Valid @RequestBody ParticipantRequest request) {
        return participantService.create(request);
    }

    @GetMapping
    public List<ParticipantResponse> getAll() {
        return participantService.getAll();
    }

    @GetMapping("/{id}")
    public ParticipantResponse getById(@PathVariable Long id) {
        return participantService.getById(id);
    }

    @PutMapping("/{id}")
    public ParticipantResponse update(@PathVariable Long id,
                                      @Valid @RequestBody ParticipantRequest request) {
        return participantService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        participantService.delete(id);
    }
}


