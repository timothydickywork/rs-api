package org.timothydickyherlambang.rscorebackend.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.timothydickyherlambang.rscorebackend.dto.ApiResponse;
import org.timothydickyherlambang.rscorebackend.dto.KajianPemeriksaanRequest;
import org.timothydickyherlambang.rscorebackend.service.KajianPemeriksaanService;
import org.timothydickyherlambang.rscorebackend.exception.ResourceNotFoundException;
import org.timothydickyherlambang.rscorebackend.exception.DuplicateResourceException;

@RestController
@RequestMapping("/api/v1/kajian-pemeriksaan")
public class KajianPemeriksaanController {

    @Autowired
    private KajianPemeriksaanService kajianPemeriksaanService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> simpanKajian(@Valid @RequestBody KajianPemeriksaanRequest request) {
        kajianPemeriksaanService.simpanKajianPemeriksaan(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Data kajian awal dan lanjutan berhasil disimpan.", null));
    }
}