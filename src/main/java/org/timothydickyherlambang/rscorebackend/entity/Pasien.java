package org.timothydickyherlambang.rscorebackend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pasien", schema = "core_operational")
public class Pasien {

    @Id
    @Column(name = "id_pasien", nullable = false, updatable = false)
    private UUID idPasien;

    @Column(name = "nama_pasien", nullable = false)
    private String namaPasien;

    @Column(name = "dob_pasien", nullable = false)
    private LocalDate dobPasien;

    @Column(name = "address", nullable = false)
    private String address;

    // Getters and Setters
    public UUID getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(UUID idPasien) {
        this.idPasien = idPasien;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public LocalDate getDobPasien() {
        return dobPasien;
    }

    public void setDobPasien(LocalDate dobPasien) {
        this.dobPasien = dobPasien;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}