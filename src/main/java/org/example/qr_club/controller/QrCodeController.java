package org.example.qr_club.controller;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.example.qr_club.dto.QrCodeResponse;
import org.example.qr_club.service.QrCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.example.qr_club.constants.ApiPaths.*;

@RestController
@RequestMapping(QR_CODES)
@RequiredArgsConstructor
@Validated
public class QrCodeController {

    private final QrCodeService qrCodeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QrCodeResponse create(@RequestParam @NotNull Long participantId) {
        return qrCodeService.createQrCode(participantId);
    }

    @PutMapping(UUID_PATH)
    public QrCodeResponse regenerate(@PathVariable @NotNull UUID uuid) {
        return qrCodeService.regenerate(uuid);
    }

    @DeleteMapping(UUID_PATH)
    public void delete(@PathVariable @NotNull UUID uuid) {
        qrCodeService.delete(uuid);
    }
}