package org.timothydickyherlambang.rscorebackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.UUID;

@Schema(description = "Pasien representation returned by the API")
public record PasienRekamMedisResponse(
        @Schema(example = "P01-20261110-0001")
        String nomor_rekam_medis,
        @Schema(example = "Timothy Dicky Herlambang")
        String nama_pasien,
        @Schema(example = "1997-10-02")
        LocalDate dob_pasien,
        @Schema(example = "29 tahun 1 bulan")
        String usia,
        @Schema(example = "Jl. Test Yogyakarta")
        String address) {
}
