package Assignment.Day2.Controller;

import Assignment.Day2.Model.Candidate;
import Assignment.Day2.Service.CandidateService;

import java.util.List;

public class CandidateController {
    private CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }
    public void addCandidate(Candidate candidate) {
        candidateService.addCandidate(candidate);
    }

    public Candidate getCandidateById(int candidateID) {
        return candidateService.getCandidateById(candidateID);
    }

    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    public void updateCandidate(Candidate candidate) {
        candidateService.updateCandidate(candidate);
    }

//    public void deleteCandidate(int candidateID) {
//        candidateService.deleteCandidateById(candidateID);
//    }
}
