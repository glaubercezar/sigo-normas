package com.sigo.norm.repository;

import com.sigo.norm.model.Norm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormRepository extends JpaRepository<Norm, Long> {
}
