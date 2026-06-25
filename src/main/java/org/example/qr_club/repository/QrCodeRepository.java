package org.example.qr_club.repository;

import org.example.qr_club.model.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QrCodeRepository extends JpaRepository<QrCode, Long> {
    Optional<QrCode> findByQrUuid(UUID qrUuid);

    Optional<QrCode> findByParticipant_Id(Long participantId);
}
