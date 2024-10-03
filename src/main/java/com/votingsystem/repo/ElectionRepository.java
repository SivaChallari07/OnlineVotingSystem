package com.votingsystem.repo;



import com.votingsystem.model.Election;
import com.votingsystem.model.ElectionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Integer> {
    Optional<Election> findByStatus(ElectionStatus status);
}
