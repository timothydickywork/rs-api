package org.timothydickyherlambang.rscorebackend.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "rekam_medis", schema = "core_operational",
        uniqueConstraints = @UniqueConstraint(columnNames = {"nomor_rekam_medis"}))
public class RekamMedis {

    @Id
    @Column(name = "id_pemeriksaan", nullable = false, updatable = false)
    private UUID idPemeriksaan;

    @Column(name = "id_pasien", nullable = false, insertable = false, updatable = false)
    private UUID idPasien;

    @Column(name = "id_dokter", nullable = false, insertable = false, updatable = false)
    private UUID idDokter;

    @Column(name = "id_status_pemeriksaan", nullable = false, insertable = false, updatable = false)
    private Integer idStatusPemeriksaan;

    @Column(name = "nomor_rekam_medis", nullable = false, unique = true)
    private String nomorRekamMedis;

    // Relasi Many-to-One ke Dokter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dokter", nullable = false)
    private Dokter dokter;

    // Relasi Many-to-One ke Pasien
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pasien", nullable = false)
    private Pasien pasien;

    // Relasi One-to-One dengan KajianAwal
    @OneToOne(mappedBy = "rekamMedis", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private KajianAwal kajianAwal;

    // Relasi One-to-One dengan KajianLanjutan
    @OneToOne(mappedBy = "rekamMedis", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private KajianLanjutan kajianLanjutan;


    // Relasi One-to-One dengan StatusPemeriksaan
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status_pemeriksaan", nullable = false, columnDefinition = "integer default 0")
    private StatusPemeriksaan statusPemeriksaan;

    // Getters and Setters
    public UUID getIdPemeriksaan() {
        return idPemeriksaan;
    }

    public void setIdPemeriksaan(UUID idPemeriksaan) {
        this.idPemeriksaan = idPemeriksaan;
    }

    public UUID getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(UUID idPasien) {
        this.idPasien = idPasien;
    }

    public UUID getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(UUID idDokter) {
        this.idDokter = idDokter;
    }

    public Integer getIdStatusPemeriksaan() {
        return idStatusPemeriksaan;
    }

    public void setIdStatusPemeriksaan(Integer idStatusPemeriksaan) {
        this.idStatusPemeriksaan = idStatusPemeriksaan;
    }

    public String getNomorRekamMedis() {
        return nomorRekamMedis;
    }

    public void setNomorRekamMedis(String nomorRekamMedis) {
        this.nomorRekamMedis = nomorRekamMedis;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
        if (dokter != null) {
            this.idDokter = dokter.getIdDokter();
        }
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
        if (pasien != null) {
            this.idPasien = pasien.getIdPasien();
        }
    }

    public KajianAwal getKajianAwal() {
        return kajianAwal;
    }

    public void setKajianAwal(KajianAwal kajianAwal) {
        this.kajianAwal = kajianAwal;
    }

    public KajianLanjutan getKajianLanjutan() {
        return kajianLanjutan;
    }

    public void setKajianLanjutan(KajianLanjutan kajianLanjutan) {
        this.kajianLanjutan = kajianLanjutan;
    }

    public StatusPemeriksaan getStatusPemeriksaan() {
        return statusPemeriksaan;
    }

    public void setStatusPemeriksaan(StatusPemeriksaan statusPemeriksaan) {
        this.statusPemeriksaan = statusPemeriksaan;
        if (statusPemeriksaan != null) {
            this.idStatusPemeriksaan = statusPemeriksaan.getIdStatusPemeriksaan();
        }
    }
}