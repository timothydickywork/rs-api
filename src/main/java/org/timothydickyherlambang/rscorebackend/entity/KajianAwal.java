package org.timothydickyherlambang.rscorebackend.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "kajian_awal", schema = "core_operational")
public class KajianAwal {

    @Id
    @Column(name = "id_pemeriksaan", nullable = false)
    private UUID idPemeriksaan;

    @Column(name = "tinggi_badan", nullable = false)
    private Float tinggiBadan;

    @Column(name = "berat_badan", nullable = false)
    private Float beratBadan;

    @Column(name = "tekanan_darah", nullable = false)
    private Float tekananDarah;

    @Column(name = "suhu_badan", nullable = false)
    private Float suhuBadan;

    @Column(name = "detak_jantung", nullable = false)
    private Float detakJantung;

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

    public Float getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(Float tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public Float getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(Float beratBadan) {
        this.beratBadan = beratBadan;
    }

    public Float getTekananDarah() {
        return tekananDarah;
    }

    public void setTekananDarah(Float tekananDarah) {
        this.tekananDarah = tekananDarah;
    }

    public Float getSuhuBadan() {
        return suhuBadan;
    }

    public void setSuhuBadan(Float suhuBadan) {
        this.suhuBadan = suhuBadan;
    }

    // Diperbaiki dari getDetak_jantung() menjadi getDetakJantung()
    public Float getDetakJantung() {
        return detakJantung;
    }

    public void setDetakJantung(Float detakJantung) {
        this.detakJantung = detakJantung;
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