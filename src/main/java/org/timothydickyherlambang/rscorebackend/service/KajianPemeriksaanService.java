package org.timothydickyherlambang.rscorebackend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.timothydickyherlambang.rscorebackend.dto.KajianPemeriksaanRequest;
import org.timothydickyherlambang.rscorebackend.entity.KajianAwal;
import org.timothydickyherlambang.rscorebackend.entity.KajianLanjutan;
import org.timothydickyherlambang.rscorebackend.entity.RekamMedis;
import org.timothydickyherlambang.rscorebackend.repository.KajianAwalRepository;
import org.timothydickyherlambang.rscorebackend.repository.KajianLanjutanRepository;
import org.timothydickyherlambang.rscorebackend.repository.RekamMedisRepository;
import org.timothydickyherlambang.rscorebackend.exception.ResourceNotFoundException;
import org.timothydickyherlambang.rscorebackend.exception.DuplicateResourceException;

@Service
public class KajianPemeriksaanService {

    @Autowired
    private RekamMedisRepository rekamMedisRepository;

    @Autowired
    private KajianAwalRepository kajianAwalRepository;

    @Autowired
    private KajianLanjutanRepository kajianLanjutanRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void simpanKajianPemeriksaan(KajianPemeriksaanRequest request) {
        // 1. Cek apakah Rekam Medis ada (Return 404 jika tidak ditemukan)
        RekamMedis rekamMedis = rekamMedisRepository.findById(request.idPemeriksaan())
                .orElseThrow(() -> new ResourceNotFoundException("Rekam medis dengan ID " + request.idPemeriksaan() + " tidak ditemukan."));

        // 2. Cek apakah data kajian sudah pernah diisi sebelumnya (Return 409 Conflict jika sudah ada)
        if (kajianAwalRepository.existsById(request.idPemeriksaan())
                || kajianLanjutanRepository.existsById(request.idPemeriksaan())) {
            throw new DuplicateResourceException("Data kajian untuk pemeriksaan ini sudah pernah disimpan.");
        }

        // 3. Simpan ke Tabel 1: Kajian Awal
        KajianAwal kajianAwal = new KajianAwal();
        kajianAwal.setRekamMedis(rekamMedis);
        kajianAwal.setTinggiBadan(request.tinggiBadan());
        kajianAwal.setBeratBadan(request.beratBadan());
        kajianAwal.setTekananDarah(request.tekananDarah());
        kajianAwal.setSuhuBadan(request.suhuBadan());
        kajianAwal.setDetakJantung(request.detakJantung());
        entityManager.persist(kajianAwal);

        // 4. Simpan ke Tabel 2: Kajian Lanjutan
        KajianLanjutan kajianLanjutan = new KajianLanjutan();
        kajianLanjutan.setRekamMedis(rekamMedis);
        kajianLanjutan.setKeluhanUtama(request.keluhanUtama());
        kajianLanjutan.setRiwayatDulu(request.riwayatDulu());
        kajianLanjutan.setRiwayatSekarang(request.riwayatSekarang());
        kajianLanjutan.setAssesmentTambahan(request.assesmentTambahan());
        kajianLanjutan.setKajianObjective(request.kajianObjective());
        entityManager.persist(kajianLanjutan);
    }
}