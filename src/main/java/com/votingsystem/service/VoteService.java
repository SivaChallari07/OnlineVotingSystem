package com.votingsystem.service;



import com.votingsystem.model.Candidate;
import com.votingsystem.model.User;
import com.votingsystem.model.Vote;
import com.votingsystem.repo.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public void castVote(User user, Candidate candidate) {
        Vote vote = new Vote();
        vote.setUser(user);
        vote.setCandidate(candidate);
        voteRepository.save(vote);
    }
}

