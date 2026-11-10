package org.timothydickyherlambang.rscorebackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.timothydickyherlambang.rscorebackend.dto.RekamMedisResponse;
import org.timothydickyherlambang.rscorebackend.entity.RekamMedis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RekamMedisRepository extends JpaRepository<RekamMedis, UUID> {
    @Query("""
            select new org.timothydickyherlambang.rscorebackend.dto.RekamMedisResponse(
                r.idPemeriksaan,
                p.namaPasien,
                r.nomorRekamMedis,
                d.namaDokter,
                s.statusPemeriksaan
            )
            from RekamMedis r
            join r.pasien p
            join r.dokter d,
                 StatusPemeriksaan s
            where s.idStatusPemeriksaan = r.idStatusPemeriksaan
              and lower(p.namaPasien) like lower(concat('%', :namaPasien, '%'))
            """)
    List<RekamMedisResponse> findByPasien_NamaPasienContainingIgnoreCase(
            @Param("namaPasien") String namaPasien);

    Optional<RekamMedis> findByNomorRekamMedis(String nomorRekamMedis);
}
