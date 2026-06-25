package org.example.qr_club.controller;

import lombok.RequiredArgsConstructor;
import org.example.qr_club.dto.QrCodeResponse;
import org.example.qr_club.service.QrCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/qr-codes")
@RequiredArgsConstructor
public class QrCodeController {

    private final QrCodeService qrCodeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QrCodeResponse create(@RequestParam Long participantId) {
        return qrCodeService.createQrCode(participantId);
    }

    @PutMapping("/{id}")
    public QrCodeResponse regenerate(@PathVariable Long id) {
        return qrCodeService.regenerate(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        qrCodeService.delete(id);
    }
}
