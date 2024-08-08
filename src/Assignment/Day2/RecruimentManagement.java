package Assignment.Day2;

import Assignment.Day2.DAO.CandidateDAO;
import Assignment.Day2.DAO.CandidateDAOImpl;
import Assignment.Day2.DAO.CertificateDAO;
import Assignment.Day2.DAO.CertificateDAOImpl;
import Assignment.Day2.Service.CandidateService;
import Assignment.Day2.Service.CertificateService;
import Assignment.Day2.View.ApplyCertificateView;
import Assignment.Day2.View.HomeView;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.chainsaw.Main;

import java.sql.SQLException;
import java.util.logging.Logger;

public class RecruimentManagement {
    /*test add and update data
    public static void main(String[] args) throws ParseException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver

            CandidateDAO candidateDAO = new CandidateDAOImpl();
            CandidateService candidateService = new CandidateService(candidateDAO);

            // Test addCandidate
            Experience newExperience = new Experience();
            newExperience.setFullName("Binh");
            newExperience.setBirthDay(new Date(1996 - 10 - 23));
            newExperience.setPhone("0923695395");
            newExperience.setEmail("binh@gmail.com");
            newExperience.setExpInYear(4);
            newExperience.setProSkill("Java Dev");
            candidateService.addCandidate(newExperience);

            // Test updateCandidate
            Experience updatedExperience = new Experience();
            updatedExperience.setCandidateID(newExperience.getCandidateID()); // Ensure this is set to the correct ID
            updatedExperience.setFullName("Updated Binh");
            updatedExperience.setBirthDay(new java.sql.Date(1996 - 10 - 23));
            updatedExperience.setExpInYear(5);
            updatedExperience.setPhone("0931234567");
            updatedExperience.setEmail("updated_binh@gmail.com");
            updatedExperience.setProSkill("Senior Java Dev");
            candidateService.updateCandidate(updatedExperience);
            System.out.println("Updated candidate");

            // Fetch and print all candidates to verify the update
            List<Candidate> candidates = candidateService.getAllCandidates();
            if (candidates == null) {
                System.out.println("candidates list if null");
            } else {
                for (Candidate candidate : candidates) {
                    System.out.println(candidate);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

     */

    private static Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {
        BasicConfigurator.configure();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver

            CandidateDAO candidateDAO = new CandidateDAOImpl();
            CandidateService candidateService = new CandidateService(candidateDAO);

            CertificateDAO certificateDAO = new CertificateDAOImpl();
            CertificateService certificateService = new CertificateService(certificateDAO);

            ApplyCertificateView applyCertificateView = new ApplyCertificateView(candidateService, certificateService);


            HomeView homeView = new HomeView(candidateService, certificateService, applyCertificateView);
            homeView.showMenu();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}