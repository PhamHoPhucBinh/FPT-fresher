package Assignment.Day2.DAO;

import Assignment.Day2.Model.Candidate;

import java.sql.SQLException;
import java.util.List;

public interface CandidateDAO {
    void addCandidate(Candidate candidate);

    void updateCandidate(Candidate candidate) throws SQLException;

    void deleteCandidateById(int CandidateID) throws SQLException;

    Candidate getCandidateById(int candidateID);

    List<Candidate> getAllCandidates();
    void addCertificateToCandidate(int candidateID, int certificateID);

}
