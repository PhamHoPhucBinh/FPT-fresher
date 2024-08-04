package Assignment.Day2;

import Assignment.Day2.Model.Certificate;
import Assignment.Day2.Model.Experience;
import Assignment.Day2.Model.Fresher;
import Assignment.Day2.Model.Intern;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RecruimentManagement {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Experience expCandidate = new Experience(1, "Bình", dateFormat.parse("23/10/1996"), "0123456789", "binh@gmail.com", 5, "Java Developer");
        Fresher fresherCandidate = new Fresher(2, "Đạt", dateFormat.parse("02/02/2000"), "0987654321", "dat@gmail.com", dateFormat.parse("01/06/2023"), "Excellent", "FPT University");
        Intern internCandidate = new Intern(3, "Vy", dateFormat.parse("03/03/2001"), "0111222333", "vy@gmail.com", "Computer Science", "5th", "FPT University");

        Certificate cert1 = new Certificate(1, "Java Certification", "A", dateFormat.parse("01/01/2023"));
        Certificate cert2 = new Certificate(2, "AWS Cloud Certification", "B", dateFormat.parse("01/06/2022"));

        expCandidate.addCertificate(cert1);
        fresherCandidate.addCertificate(cert1);
        expCandidate.addCertificate(cert2);
        internCandidate.addCertificate(cert2);

        System.out.println(expCandidate);
        System.out.println(fresherCandidate);
        System.out.println(internCandidate);
    }
}
