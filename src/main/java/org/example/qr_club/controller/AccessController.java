package org.example.qr_club.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.qr_club.dto.AccessRequest;
import org.example.qr_club.dto.AccessResponse;
import org.example.qr_club.service.AccessService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.example.qr_club.constants.ApiPaths.ACCESS;

@RestController
@RequestMapping(ACCESS)
@RequiredArgsConstructor
@Validated
public class AccessController {

    private final AccessService accessService;

    @PostMapping
    public AccessResponse access(@Valid @RequestBody AccessRequest request) {
        return accessService.checkAccess(request);
    }
}
