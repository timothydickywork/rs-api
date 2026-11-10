package org.timothydickyherlambang.rscorebackend.service;

import org.timothydickyherlambang.rscorebackend.dto.PasienRekamMedisResponse;
import org.timothydickyherlambang.rscorebackend.dto.RekamMedisResponse;
import org.timothydickyherlambang.rscorebackend.entity.Pasien;
import org.timothydickyherlambang.rscorebackend.entity.RekamMedis;
import org.timothydickyherlambang.rscorebackend.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.timothydickyherlambang.rscorebackend.repository.RekamMedisRepository;

import java.util.Collections;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;

@Service
@Transactional(readOnly = true)
public class RekamMedisService {

    private final RekamMedisRepository rekamMedisRepository;

    public RekamMedisService(RekamMedisRepository rekamMedisRepository) {
        this.rekamMedisRepository = rekamMedisRepository;
    }

    public List<RekamMedisResponse> searchPasien(String search) {
        if(search.isEmpty() || search.trim().length() < 3){
            return Collections.emptyList();
        }

        return rekamMedisRepository.findByPasien_NamaPasienContainingIgnoreCase(search.trim());
    }

    public PasienRekamMedisResponse findPasienByNomorRekamMedis(String nomor_rekam_medis) {
        if(nomor_rekam_medis.isEmpty()){
            throw new ResourceNotFoundException("nomor_rekam_medis tidak boleh null!");
        }

        RekamMedis rekamMedis = rekamMedisRepository.findByNomorRekamMedis(nomor_rekam_medis.trim())
                .orElseThrow(() -> new ResourceNotFoundException("Pasien dengan nomor " + nomor_rekam_medis + " tidak ditemukan!"));
        Pasien pasien = rekamMedis.getPasien();
        Period usia = Period.between(pasien.getDobPasien(), LocalDate.now());

        return new PasienRekamMedisResponse(
                rekamMedis.getNomorRekamMedis(),
                pasien.getNamaPasien(),
                pasien.getDobPasien(),
                usia.getYears() + " tahun " + usia.getMonths() + " bulan",
                pasien.getAddress());
    }
}
