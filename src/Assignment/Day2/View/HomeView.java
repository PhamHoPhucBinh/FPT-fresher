package Assignment.Day2.View;

import Assignment.Day2.DAO.CertificateDAOImpl;
import Assignment.Day2.Model.Candidate;
import Assignment.Day2.Model.Certificate;
import Assignment.Day2.Service.CandidateService;
import Assignment.Day2.Service.CertificateService;
import Assignment.Day2.Util.CommonUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class HomeView {
    private CandidateService candidateService;
    private CertificateService certificateService;
    private ApplyCertificateView applyCertificateView;

    public HomeView(CandidateService candidateService, CertificateService certificateService, ApplyCertificateView applyCertificateView) {
        this.candidateService = candidateService;
        this.certificateService = certificateService;
        this.applyCertificateView = applyCertificateView;
    }

    public void showMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Candidate Management");
            System.out.println("2. Certificate Management");
            System.out.println("3. Show All Candidates");
            System.out.println("4. Show All Certificates");
            System.out.println("5. Add Certificate to Candidate");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    CandidateView.showMenu(scanner, candidateService);
                    break;
                case 2:
                    CertificateView.showMenu(scanner, certificateService);
                    break;
                case 3:
                    showAllCandidates();
                    break;
                case 4:
                    showAllCertificates();
                    break;
                case 5:
                    applyCertificateView.showMenu();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void showAllCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();
        for (Candidate candidate : candidates) {
            System.out.println(candidate);
        }
    }

    private void showAllCertificates() {
        List<Certificate> certificates = certificateService.getAllCertificates();
        for (Certificate certificate : certificates) {
            System.out.println(certificate);
        }
    }
}

