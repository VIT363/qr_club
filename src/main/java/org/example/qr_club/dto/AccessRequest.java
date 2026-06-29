package org.example.qr_club.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AccessRequest(@NotNull UUID uuid) {
}