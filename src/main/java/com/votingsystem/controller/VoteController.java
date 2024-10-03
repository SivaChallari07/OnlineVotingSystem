package com.votingsystem.controller;

import java.security.Principal;
import java.util.List; // Correct import

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Correct import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.votingsystem.model.Candidate;
import com.votingsystem.model.Election;
import com.votingsystem.model.User;
import com.votingsystem.service.CandidateService;
import com.votingsystem.service.ElectionService; // Added ElectionService
import com.votingsystem.service.UserService;
import com.votingsystem.service.VoteService;

@Controller
public class VoteController {

    @Autowired
    private VoteService voteService;

    @Autowired
    private UserService userService;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private ElectionService electionService; // Add this line

    @PostMapping("/vote/cast")
    public String castVote(@RequestParam String username, @RequestParam int candidateId) {
        User user = userService.findByUsername(username);
        Candidate candidate = candidateService.findById(candidateId);
        voteService.castVote(user, candidate);
        return "redirect:/vote/success";
    }

    @GetMapping("/vote")
    public String showVoteForm(Model model, Principal principal) {
        // Get the logged-in user's username
        String username = principal.getName();
        User user = userService.findByUsername(username);

        // Get the current ongoing election
        Election election = electionService.getOngoingElection();

        // Get candidates for the ongoing election
        List<Candidate> candidates = candidateService.getCandidatesByElectionId(election.getId());

        // Add attributes to the model for rendering in the view
        model.addAttribute("username", user.getUsername());
        model.addAttribute("candidates", candidates);

        // Return the vote.html view
        return "vote"; // Renders the vote.html page
    }
}
