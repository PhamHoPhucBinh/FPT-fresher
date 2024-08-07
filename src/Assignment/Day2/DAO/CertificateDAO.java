package Assignment.Day2.DAO;

import Assignment.Day2.Model.Certificate;

import java.util.List;

public interface CertificateDAO {
    void addCertificate(Certificate certificate);

    void updateCertificate(Certificate certificate);

    void deleteCertificateById(int certificateID);

    List<Certificate> getAllCertificate();

    Certificate getCertificateById(int certificateId);

    List<Certificate> getCertificatesByCandidateId(int candidateID);
    List<Certificate> getAllCertificates();
    void addCertificateToCandidate(int candidateID, int certificateID);
}
