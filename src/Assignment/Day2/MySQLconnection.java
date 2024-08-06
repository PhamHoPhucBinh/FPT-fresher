//package Assignment.Day2;
//
//import Assignment.Day2.Model.*;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class MySQLconnection {
//    private static final String jdbcURL = "jdbc:mysql://localhost:3306/CandidateManagement";
//    private static final String username = "root";
//    private static final String password = "12345";
//
//    public static Connection getConnection() throws Exception {
//        return DriverManager.getConnection(jdbcURL, username, password);
//    }
//
//    public static void insertCandidate(Candidate candidate) {
//        String sql = "INSERT INTO candidates (fullName, birthDay, phone, email, candidateType) VALUES (?, ?, ?, ?, ?)";
//
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//            preparedStatement.setString(1, candidate.getFullName());
//            preparedStatement.setDate(2, new java.sql.Date(candidate.getBirthDay().getTime()));
//            preparedStatement.setString(3, candidate.getPhone());
//            preparedStatement.setString(4, candidate.getEmail());
//            preparedStatement.setInt(5, candidate.getCandidateType());
//
//            preparedStatement.executeUpdate();
//
//            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    candidate.setCandidateID(generatedKeys.getInt(1));
//                }
//            }
//
//            // Insert candidate-specific details
//            if (candidate instanceof Experience) {
//                insertExperience((Experience) candidate);
//            } else if (candidate instanceof Fresher) {
//                insertFresher((Fresher) candidate);
//            } else if (candidate instanceof Intern) {
//                insertIntern((Intern) candidate);
//            }
//
//            // Insert certificates
//            for (Certificate certificate : candidate.getCertificates()) {
//                insertCertificate(candidate.getCandidateID(), certificate);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void insertExperience(Experience experience) {
//        String sql = "INSERT INTO experience (candidateID, yearsOfExperience,proSkill) VALUES (?, ?, ?)";
//
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setInt(1, experience.getCandidateID());
//            preparedStatement.setInt(2, experience.getExpInYear());
//            preparedStatement.setString(3, experience.getProSkill());
//
//            preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void insertFresher(Fresher fresher) {
//        String sql = "INSERT INTO fresher (candidateID, graduationDate, graduationRank, education) VALUES (?, ?, ?, ?)";
//
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setInt(1, fresher.getCandidateID());
//            preparedStatement.setDate(2, new java.sql.Date(fresher.getGraduationDate().getTime()));
//            preparedStatement.setString(3, fresher.getGraduationRank());
//            preparedStatement.setString(4, fresher.getEducation());
//
//            preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void insertIntern(Intern intern) {
//        String sql = "INSERT INTO intern (candidateID, majors,semester,universityName) VALUES (?, ?,?,?)";
//
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setInt(1, intern.getCandidateID());
//            preparedStatement.setString(2, intern.getMajors());
//            preparedStatement.setString(3, intern.getSemester());
//            preparedStatement.setString(4, intern.getUniversityName());
//
//            preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void insertCertificate(int candidateID, Certificate certificate) {
//        String sql = "INSERT INTO certificates (candidateID, certificateName, certificateRank, certificateDate) VALUES (?, ?, ?, ?)";
//
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setInt(1, candidateID);
//            preparedStatement.setString(2, certificate.getCertificateName());
//            preparedStatement.setString(3, certificate.getCertificateRank());
//            preparedStatement.setDate(4, new java.sql.Date(certificate.getCertificateDate().getTime()));
//
//            preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static List<Candidate> getAllCandidates() throws Exception {
//        List<Candidate> candidates = new ArrayList<>();
//
//        String sql = "SELECT * FROM candidates";
//
//        try (Connection connection = getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(sql)) {
//
//            while (resultSet.next()) {
//                int candidateID = resultSet.getInt("candidateID");
//                String fullName = resultSet.getString("fullName");
//                Date birthDay = resultSet.getDate("birthDay");
//                String phone = resultSet.getString("phone");
//                String email = resultSet.getString("email");
//                int candidateType = resultSet.getInt("candidateType");
//
//                Candidate candidate = null;
//                switch (candidateType) {
//                    case 0:
//                        int expInYear = Integer.parseInt(resultSet.getString("expInYear"));
//                        String proSkill = resultSet.getString("proSkill");
//                        candidate = new Experience(candidateID, fullName, birthDay, phone, email, expInYear, proSkill);
//                        break;
//                    case 1:
//                        Date graduationDate = resultSet.getDate("graduationDate");
//                        String graduationRank = resultSet.getString("graduationRank");
//                        String education = resultSet.getString("education");
//                        candidate = new Fresher(candidateID, fullName, birthDay, phone, email, graduationDate, graduationRank, education);
//                        break;
//                    case 2:
//                        String majors = resultSet.getString("majors");
//                        String semester = resultSet.getString("semester");
//                        String universityName = resultSet.getString("universityName");
//                        candidate = new Intern(candidateID, fullName, birthDay, phone, email, majors, semester, universityName);
//                        break;
//                }
//            }
//        }
//        return candidates;
//    }
//}