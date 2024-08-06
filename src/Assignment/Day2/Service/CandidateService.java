package Assignment.Day2.Service;

import Assignment.Day2.DAO.CandidateDAO;
import Assignment.Day2.Model.Candidate;

import java.util.List;

public class CandidateService {
    private CandidateDAO candidateDAO;

    public CandidateService(CandidateDAO candidateDAO) {
        this.candidateDAO = candidateDAO;
    }

    public void addCandidate(Candidate candidate) {
        candidateDAO.addCandidate(candidate);
    }

    public Candidate getCandidateById(int candidateID) {
        return candidateDAO.getCandidateById(candidateID);
    }

    public List<Candidate> getAllCandidates() {
        return candidateDAO.getAllCandidates();
    }

    public void updateCandidate(Candidate candidate) {
        candidateDAO.updateCandidate(candidate);
    }

//    public void deleteCandidate(int candidateID) {
//        candidateDAO.deleteCandidate(candidateID);
//    }
}

