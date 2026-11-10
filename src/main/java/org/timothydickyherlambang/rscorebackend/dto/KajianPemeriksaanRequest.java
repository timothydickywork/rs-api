package org.timothydickyherlambang.rscorebackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Schema(description = "Request body untuk menyimpan kajian awal dan lanjutan")
public record KajianPemeriksaanRequest(
        @Schema(example = "7e3c434b-f1e3-4f4a-b3c8-bc06796f5ed1", description = "ID Pemeriksaan / Rekam Medis yang sudah ada")
        @NotNull(message = "ID Pemeriksaan wajib diisi")
        UUID idPemeriksaan,

        // Data Kajian Awal
        @Schema(example = "150.0")
        @NotNull(message = "Tinggi badan wajib diisi")
        Float tinggiBadan,

        @Schema(example = "40.0")
        @NotNull(message = "Berat badan wajib diisi")
        Float beratBadan,

        @Schema(example = "120.0")
        @NotNull(message = "Tekanan darah wajib diisi")
        Float tekananDarah,

        @Schema(example = "36.5")
        @NotNull(message = "Suhu badan wajib diisi")
        Float suhuBadan,

        @Schema(example = "80.0")
        @NotNull(message = "Detak jantung wajib diisi")
        Float detakJantung,

        // Data Kajian Lanjutan
        @Schema(example = "Pusing dan lelah setelah beraktivitas")
        @NotBlank(message = "Keluhan utama wajib diisi")
        String keluhanUtama,

        @Schema(example = "Tidak ada riwayat penyakit berat")
        @NotBlank(message = "Riwayat penyakit dahulu wajib diisi")
        String riwayatDulu,

        @Schema(example = "Kurang istirahat")
        @NotBlank(message = "Riwayat penyakit sekarang wajib diisi")
        String riwayatSekarang,

        @Schema(example = "Dianjurkan istirahat cukup")
        @NotBlank(message = "Assessment tambahan wajib diisi")
        String assesmentTambahan,

        @Schema(example = "Pasien sadar penuh, tensi stabil.")
        String kajianObjective
) {}