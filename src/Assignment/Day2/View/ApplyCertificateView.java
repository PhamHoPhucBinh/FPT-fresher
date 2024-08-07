package Assignment.Day2.View;

import Assignment.Day2.Service.CandidateService;
import Assignment.Day2.Service.CertificateService;

import java.util.Scanner;

public class ApplyCertificateView {
    private CandidateService candidateService;
    private CertificateService certificateService;

    public ApplyCertificateView(CandidateService candidateService, CertificateService certificateService) {
        this.candidateService = candidateService;
        this.certificateService = certificateService;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Apply Certificate to Candidate");
            System.out.println("1. Apply Certificate");
            System.out.println("2. Back to Home");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    applyCertificate();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void applyCertificate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Apply Certificate");
        System.out.print("Candidate ID: ");
        int candidateID = scanner.nextInt();
        System.out.print("Certificate ID: ");
        int certificateID = scanner.nextInt();

        candidateService.addCertificateToCandidate(candidateID, certificateID);
        System.out.println("Certificate applied to candidate successfully.");
    }
}
