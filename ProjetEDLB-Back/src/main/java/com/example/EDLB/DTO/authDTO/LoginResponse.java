package com.example.EDLB.DTO.authDTO;

import java.util.UUID;

public record LoginResponse(UUID idUser, String token, Long expiresIn) {
}