package org.timothydickyherlambang.rscorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.timothydickyherlambang.rscorebackend.entity.KajianAwal;

import java.util.UUID;

@Repository
public interface KajianAwalRepository extends JpaRepository<KajianAwal, UUID> {
}