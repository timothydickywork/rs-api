package org.timothydickyherlambang.rscorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.timothydickyherlambang.rscorebackend.entity.KajianLanjutan;

import java.util.UUID;

@Repository
public interface KajianLanjutanRepository extends JpaRepository<KajianLanjutan, UUID> {
}