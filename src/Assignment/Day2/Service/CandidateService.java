package Assignment.Day2.Service;

import Assignment.Day2.DAO.CandidateDAO;
import Assignment.Day2.Model.Candidate;

import java.sql.SQLException;
import java.util.List;

public class CandidateService {
    private CandidateDAO candidateDAO;

    public CandidateService(CandidateDAO candidateDAO) {
        this.candidateDAO = candidateDAO;
    }

    public void addCandidate(Candidate candidate) {
        candidateDAO.addCandidate(candidate);
    }

    public void updateCandidate(Candidate candidate) throws SQLException {
        candidateDAO.updateCandidate(candidate);
    }

    public void deleteCandidateById(int candidateID) throws SQLException {
        candidateDAO.deleteCandidateById(candidateID);
    }

    public Candidate getCandidateById(int candidateID) {
        return candidateDAO.getCandidateById(candidateID);
    }

    public List<Candidate> getAllCandidates() {
        return candidateDAO.getAllCandidates();
    }

    public void addCertificateToCandidate(int candidateID, int certificateID) {
        candidateDAO.addCertificateToCandidate(candidateID, certificateID);
    }


}

