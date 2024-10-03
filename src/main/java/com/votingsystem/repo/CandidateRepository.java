package com.votingsystem.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.votingsystem.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    // Find all candidates for a given election
    List<Candidate> findByElectionId(int electionId);
}
