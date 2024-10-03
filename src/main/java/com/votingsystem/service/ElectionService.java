package com.votingsystem.service;



import com.votingsystem.model.Election;
import com.votingsystem.model.ElectionStatus;
import com.votingsystem.repo.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectionService {

	@Autowired
    private ElectionRepository electionRepository;

    // Get the current ongoing election
    public Election getOngoingElection() {
        return electionRepository.findByStatus(ElectionStatus.ONGOING)
                .orElseThrow(() -> new RuntimeException("No ongoing election found"));
    }
}

