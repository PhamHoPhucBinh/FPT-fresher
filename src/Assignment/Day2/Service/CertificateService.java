package Assignment.Day2.Service;

import Assignment.Day2.DAO.CertificateDAO;
import Assignment.Day2.Model.Certificate;

import java.util.List;

public class CertificateService {
    private CertificateDAO certificateDAO;

    public CertificateService(CertificateDAO certificateDAO) {
        this.certificateDAO = certificateDAO;
    }

    public void addCertificate(Certificate certificate) {
        certificateDAO.addCertificate(certificate);
    }

    public void updateCertificate(Certificate certificate) {
        certificateDAO.updateCertificate(certificate);
    }

    public void deleteCertificateById(int certificateId) {
        certificateDAO.deleteCertificateById(certificateId);
    }

    public Certificate getCertificateById(int certificateID) {
        return certificateDAO.getCertificateById(certificateID);
    }

    public List<Certificate> getCertificatesByCandidateId(int candidateID) {
        return certificateDAO.getCertificatesByCandidateId(candidateID);
    }
    public List<Certificate> getAllCertificates(){
        return certificateDAO.getAllCertificates();
    }
}
