package com.votingsystem.service;



import com.votingsystem.model.Candidate;
import com.votingsystem.repo.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    // Get all candidates for a specific election
    public List<Candidate> getCandidatesByElectionId(int electionId) {
        return candidateRepository.findByElectionId(electionId);
    }

    // Find a candidate by their ID
    public Candidate findById(int candidateId) {
        Optional<Candidate> candidate = candidateRepository.findById(candidateId);
        return candidate.orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    // Save a new candidate to the database
    public void addCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    // Delete a candidate by ID
    public void deleteCandidate(int candidateId) {
        candidateRepository.deleteById(candidateId);
    }
}
