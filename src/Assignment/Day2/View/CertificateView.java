package Assignment.Day2.View;

import Assignment.Day2.DAO.CertificateDAOImpl;
import Assignment.Day2.Model.*;
import Assignment.Day2.Service.CertificateService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CertificateView {
    public static void showMenu(Scanner scanner, CertificateService certificateService) {
        while (true) {
            System.out.println("Certificate Management:");
            System.out.println("1. Add Certificate");
            System.out.println("2. Update Certificate");
            System.out.println("3. Delete Certificate");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCertificate(scanner, certificateService);
                    break;
                case 2:
                    updateCertificate(scanner, certificateService);
                    break;
                case 3:
                    deleteCertificate(scanner, certificateService);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCertificate(Scanner scanner, CertificateService certificateService) {
        try {
            System.out.print("Enter Certificate Name: ");
            String certificateName = scanner.nextLine();

            System.out.print("Enter Enter Certificate Date (dd-mm-yyyy): ");
            String certificateDateString = scanner.nextLine();
            Date certificateDate = new SimpleDateFormat("dd-mm-yyyy").parse(certificateDateString);

            System.out.print("Enter Certificate rank: ");
            String certificateRank = scanner.nextLine();
            Certificate certificate = new Certificate(certificateName, certificateRank, certificateDate);
            certificateService.addCertificate(certificate);
            System.out.println("Create Certificate successfully");
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
        }
    }

    private static void updateCertificate(Scanner scanner, CertificateService certificateService) {
        // Implement the logic for updating a certificate
    }

    private static void deleteCertificate(Scanner scanner, CertificateService certificateService) {
        // Implement the logic for deleting a certificate
    }
}
