package Assignment.Day2.View;

import Assignment.Day2.Exception.BirthDayException;
import Assignment.Day2.Exception.EmailException;
import Assignment.Day2.Model.Candidate;
import Assignment.Day2.Model.Experience;
import Assignment.Day2.Model.Fresher;
import Assignment.Day2.Model.Intern;
import Assignment.Day2.Service.CandidateService;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CandidateView {
    public static void showMenu(Scanner scanner, CandidateService candidateService) throws SQLException {
        while (true) {
            System.out.println("Candidate Management:");
            System.out.println("1. Add Candidate");
            System.out.println("2. Update Candidate");
            System.out.println("3. Delete Candidate");
            System.out.println("4. Number of candidates just added");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addCandidate(scanner, candidateService);
                case 2 -> updateCandidate(scanner, candidateService);
                case 3 -> deleteCandidate(scanner, candidateService);
                case 4 -> CandidateService.displayTotalCandidates();
                case 5 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCandidate(Scanner scanner, CandidateService candidateService) {
        try {
            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine();

            System.out.print("Enter birth date (dd-MM-yyyy): ");
            String birthDateString = scanner.nextLine();
            Date birthDate = validateBirthDate(birthDateString);

            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            validateEmail(email);

            System.out.print("Enter candidate type (0: Experience, 1: Fresher, 2: Intern): ");
            int candidateType = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Candidate candidate;
            try {
                switch (candidateType) {
                    case 0 -> {
                        System.out.print("Enter years of experience: ");
                        int expInYear = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter professional skill: ");
                        String proSkill = scanner.nextLine();
                        candidate = new Experience(fullName, birthDate, phone, email, expInYear, proSkill);
                    }
                    case 1 -> {
                        System.out.print("Enter graduation date (dd-MM-yyyy): ");
                        String gradDateString = scanner.nextLine();
                        Date graduationDate = new SimpleDateFormat("dd-MM-yyyy").parse(gradDateString);
                        System.out.print("Enter graduation rank: ");
                        String graduationRank = scanner.nextLine();
                        System.out.print("Enter education: ");
                        String education = scanner.nextLine();
                        candidate = new Fresher(fullName, birthDate, phone, email, graduationDate, graduationRank, education);
                    }
                    case 2 -> {
                        System.out.print("Enter majors: ");
                        String majors = scanner.nextLine();
                        System.out.print("Enter semester: ");
                        String semester = scanner.nextLine();
                        System.out.print("Enter university name: ");
                        String universityName = scanner.nextLine();
                        candidate = new Intern(fullName, birthDate, phone, email, majors, semester, universityName);
                    }
                    default -> {
                        System.out.println("Invalid candidate type.");
                        return;
                    }
                }

                candidateService.addCandidate(candidate);
                System.out.println("Candidate added successfully.");
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
        } catch (BirthDayException | EmailException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
        }
    }

    private static void updateCandidate(Scanner scanner, CandidateService candidateService) {
        try {
            System.out.print("Enter candidate ID to update: ");
            int candidateID = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine();

            System.out.print("Enter birth date (yyyy-MM-dd): ");
            String birthDateString = scanner.nextLine();
            Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateString);

            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter candidate type (0: Experience, 1: Fresher, 2: Intern): ");
            int candidateType = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Candidate candidate;
            switch (candidateType) {
                case 0 -> {
                    System.out.print("Enter years of experience: ");
                    int expInYear = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter professional skill: ");
                    String proSkill = scanner.nextLine();
                    candidate = new Experience(candidateID, fullName, birthDate, phone, email, candidateType, expInYear, proSkill);
                }
                case 1 -> {
                    System.out.print("Enter graduation date (dd-mm-yyyy): ");
                    String gradDateString = scanner.nextLine();
                    Date graduationDate = new SimpleDateFormat("dd-MM-yyyy").parse(gradDateString);
                    System.out.print("Enter graduation rank: ");
                    String graduationRank = scanner.nextLine();
                    System.out.print("Enter education: ");
                    String education = scanner.nextLine();
                    candidate = new Fresher(candidateID, fullName, birthDate, phone, email, candidateType, graduationDate, graduationRank, education);
                }
                case 2 -> {
                    System.out.print("Enter majors: ");
                    String majors = scanner.nextLine();
                    System.out.print("Enter semester: ");
                    String semester = scanner.nextLine();
                    System.out.print("Enter university name: ");
                    String universityName = scanner.nextLine();
                    candidate = new Intern(candidateID, fullName, birthDate, phone, email, candidateType, majors, semester, universityName);
                }
                default -> {
                    System.out.println("Invalid candidate type.");
                    return;
                }
            }

            candidateService.updateCandidate(candidate);
            System.out.println("Candidate updated successfully.");
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteCandidate(Scanner scanner, CandidateService candidateService) {
        System.out.print("Enter Candidate ID to delete: ");
        int candidateID = scanner.nextInt();

        try {
            candidateService.deleteCandidateById(candidateID);
            System.out.println("Candidate deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting candidate: " + e.getMessage());
        }
    }

    private static Date validateBirthDate(String birthDateString) throws BirthDayException, ParseException {
        Date birthDate = new SimpleDateFormat("dd-MM-yyyy").parse(birthDateString);
        Date minDate = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-1990");
        Date maxDate = new Date();

        if (birthDate.before(minDate) || birthDate.after(maxDate)) {
            throw new BirthDayException("Birth date phải từ 1900 đến hiện tại.");
        }

        return birthDate;
    }

    private static void validateEmail(String email) throws EmailException {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailRegex)) {
            throw new EmailException("Sai định dạng mail.");
        }
    }
}
