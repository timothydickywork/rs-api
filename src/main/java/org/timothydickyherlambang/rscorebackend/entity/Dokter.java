package org.timothydickyherlambang.rscorebackend.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "dokter", schema = "core_operational")
public class Dokter {

    @Id
    @Column(name = "id_dokter", nullable = false, updatable = false)
    private UUID idDokter;

    @Column(name = "nama_dokter", nullable = false)
    private String namaDokter;

    // Getters and Setters
    public UUID getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(UUID idDokter) {
        this.idDokter = idDokter;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }
}