package org.timothydickyherlambang.rscorebackend.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "kajian_lanjutan", schema = "core_operational")
public class KajianLanjutan {

    @Id
    @Column(name = "id_pemeriksaan", nullable = false)
    private UUID idPemeriksaan;

    @Column(name = "keluhan_utama", nullable = false)
    private String keluhanUtama;

    @Column(name = "riwayat_dulu", nullable = false)
    private String riwayatDulu;

    @Column(name = "riwayat_sekarang", nullable = false)
    private String riwayatSekarang;

    @Column(name = "assesment_tambahan", nullable = false)
    private String assesmentTambahan;

    @Column(name = "kajian_objective")
    private String kajianObjective;

    // Relasi One-to-One dengan RekamMedis
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_pemeriksaan")
    private RekamMedis rekamMedis;

    // Getters and Setters
    public UUID getIdPemeriksaan() {
        return idPemeriksaan;
    }

    public void setIdPemeriksaan(UUID idPemeriksaan) {
        this.idPemeriksaan = idPemeriksaan;
    }

    public String getKeluhanUtama() {
        return keluhanUtama;
    }

    public void setKeluhanUtama(String keluhanUtama) {
        this.keluhanUtama = keluhanUtama;
    }

    public String getRiwayatDulu() {
        return riwayatDulu;
    }

    public void setRiwayatDulu(String riwayatDulu) {
        this.riwayatDulu = riwayatDulu;
    }

    public String getRiwayatSekarang() {
        return riwayatSekarang;
    }

    public void setRiwayatSekarang(String riwayatSekarang) {
        this.riwayatSekarang = riwayatSekarang;
    }

    public String getAssesmentTambahan() {
        return assesmentTambahan;
    }

    public void setAssesmentTambahan(String assesmentTambahan) {
        this.assesmentTambahan = assesmentTambahan;
    }

    public String getKajianObjective() {
        return kajianObjective;
    }

    public void setKajianObjective(String kajianObjective) {
        this.kajianObjective = kajianObjective;
    }

    public RekamMedis getRekamMedis() {
        return rekamMedis;
    }

    public void setRekamMedis(RekamMedis rekamMedis) {
        this.rekamMedis = rekamMedis;
        if (rekamMedis != null) {
            this.idPemeriksaan = rekamMedis.getIdPemeriksaan();
        }
    }
}