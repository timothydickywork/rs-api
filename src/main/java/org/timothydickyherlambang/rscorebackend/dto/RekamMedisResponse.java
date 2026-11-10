package org.timothydickyherlambang.rscorebackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Rekam medis representation returned by the API")
public record RekamMedisResponse(
        @Schema(example = "7e3c434b-f1e3-4f4a-b3c8-bc06796f5ed1")
        UUID id_pemeriksaan,
        @Schema(example = "Timothy Dicky Herlambang")
        String nama_pasien,
        @Schema(example = "P01-20261110-0002")
        String nomor_rekam_medis,
        @Schema(example = "Hari Prasetyo")
        String nama_dokter,
        @Schema(example = "Proses Periksa")
        String status_pemeriksaan) {
}
