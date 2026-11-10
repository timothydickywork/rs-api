package org.timothydickyherlambang.rscorebackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "status_pemeriksaan", schema = "core_operational")
public class StatusPemeriksaan {

    @Id
    @Column(name = "id_status_pemeriksaan", nullable = false)
    private Integer idStatusPemeriksaan;

    @Column(name = "status_pemeriksaan", nullable = false)
    private String statusPemeriksaan;

    // Getters and Setters
    public Integer getIdStatusPemeriksaan() {
        return idStatusPemeriksaan;
    }

    public void setIdStatusPemeriksaan(Integer idStatusPemeriksaan) {
        this.idStatusPemeriksaan = idStatusPemeriksaan;
    }

    public String getStatusPemeriksaan() {
        return statusPemeriksaan;
    }

    public void setStatusPemeriksaan(String statusPemeriksaan) {
        this.statusPemeriksaan = statusPemeriksaan;
    }
}