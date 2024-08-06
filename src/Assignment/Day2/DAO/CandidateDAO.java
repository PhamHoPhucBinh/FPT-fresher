package Assignment.Day2.DAO;

import Assignment.Day2.Model.Candidate;

import java.util.List;

public interface CandidateDAO {
    void addCandidate(Candidate candidate);

    Candidate getCandidateById(int candidateID);

    List<Candidate> getAllCandidates();

    void updateCandidate(Candidate candidate);

    void deleteCandidateById(int CandidateID);
}
