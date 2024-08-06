package Assignment.Day2.Controller;

import Assignment.Day2.Model.Certificate;
import Assignment.Day2.Service.CertificateService;

import java.util.List;

public class CertificateController {
    private CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    public void addCertificate(Certificate certificate) {
        certificateService.addCertificate(certificate);
    }

    public Certificate getCertificateById(int certificateID) {
        return certificateService.getCertificateById(certificateID);
    }

    public List<Certificate> getCertificatesByCandidateId(int candidateID) {
        return certificateService.getCertificatesByCandidateId(candidateID);
    }

    public void updateCertificate(Certificate certificate) {
        certificateService.updateCertificate(certificate);
    }

    public void deleteCertificate(int certificateID) {
        certificateService.deleteCertificateById(certificateID);
    }
}
