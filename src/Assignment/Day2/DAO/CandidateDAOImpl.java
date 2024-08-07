package Assignment.Day2.DAO;

import Assignment.Day2.DAO.CandidateDAO;
import Assignment.Day2.Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAOImpl implements CandidateDAO {

    private static final String jdbcURL = "jdbc:mysql://localhost:3306/CandidateManagement";
    private static final String username = "root";
    private static final String password = "12345";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver
        } catch (ClassNotFoundException e) {
            throw new SQLException("Unable to load MySQL Driver", e);
        }
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    @Override
    public void addCandidate(Candidate candidate) {
        String sql = "SELECT * FROM candidates WHERE 1=0"; // Empty result set

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(sql)) {

            resultSet.moveToInsertRow();
            resultSet.updateString("fullName", candidate.getFullName());
            resultSet.updateDate("birthDay", new java.sql.Date(candidate.getBirthDay().getTime()));
            resultSet.updateString("phone", candidate.getPhone());
            resultSet.updateString("email", candidate.getEmail());
            resultSet.updateInt("candidateType", candidate.getCandidateType());
            resultSet.insertRow();
            resultSet.moveToCurrentRow();

            int candidateID = getLastInsertedCandidateID(connection);
            candidate.setCandidateID(candidateID);

            if (candidate instanceof Experience) {
                insertExperience(connection, (Experience) candidate);
            } else if (candidate instanceof Fresher) {
                insertFresher(connection, (Fresher) candidate);
            } else if (candidate instanceof Intern) {
                insertIntern(connection, (Intern) candidate);
            }

            for (Certificate certificate : candidate.getCertificates()) {
                insertCertificate(connection, candidateID, certificate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Candidate getCandidateById(int candidateID) {
        return null;
    }

    private int getLastInsertedCandidateID(Connection connection) throws SQLException {
        String sql = "SELECT LAST_INSERT_ID()";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return -1;
    }

    private void insertExperience(Connection connection, Experience experience) throws SQLException {
        String sql = "SELECT * FROM experience WHERE 1=0"; // Empty result set

        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(sql)) {

            resultSet.moveToInsertRow();
            resultSet.updateInt("candidateID", experience.getCandidateID());
            resultSet.updateInt("expInYear", experience.getExpInYear());
            resultSet.updateString("proSkill", experience.getProSkill());

            resultSet.insertRow();
            resultSet.moveToCurrentRow();
        }
    }

    private void insertFresher(Connection connection, Fresher fresher) throws SQLException {
        String sql = "SELECT * FROM fresher WHERE 1=0"; // Empty result set

        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(sql)) {

            resultSet.moveToInsertRow();
            resultSet.updateInt("candidateID", fresher.getCandidateID());
            resultSet.updateDate("graduationDate", new java.sql.Date(fresher.getGraduationDate().getTime()));
            resultSet.updateString("graduationRank", fresher.getGraduationRank());
            resultSet.updateString("education", fresher.getEducation());
            resultSet.insertRow();
            resultSet.moveToCurrentRow();
        }
    }

    private void insertIntern(Connection connection, Intern intern) throws SQLException {
        String sql = "SELECT * FROM intern WHERE 1=0"; // Empty result set

        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(sql)) {

            resultSet.moveToInsertRow();
            resultSet.updateInt("candidateID", intern.getCandidateID());
            resultSet.updateString("majors", intern.getMajors());
            resultSet.updateString("semester", intern.getSemester());
            resultSet.updateString("universityName", intern.getUniversityName());
            resultSet.insertRow();
            resultSet.moveToCurrentRow();
        }
    }

    private void insertCertificate(Connection connection, int candidateID, Certificate certificate) throws SQLException {
        String sql = "SELECT * FROM certificates WHERE 1=0"; // Empty result set

        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(sql)) {

            resultSet.moveToInsertRow();
            resultSet.updateInt("candidateID", candidateID);
            resultSet.updateString("certificateName", certificate.getCertificateName());
            resultSet.updateString("certificateRank", certificate.getCertificateRank());
            resultSet.updateDate("certificateDate", new java.sql.Date(certificate.getCertificateDate().getTime()));
            resultSet.insertRow();
            resultSet.moveToCurrentRow();
        }
    }

//    @Override
//    public void updateCandidate(Candidate candidate) {
//        try (Connection connection = getConnection()) {
//            if (candidate instanceof Experience) {
//                updateExperience(connection, (Experience) candidate);
//            } else if (candidate instanceof Fresher) {
//                updateFresher(connection, (Fresher) candidate);
//            } else if (candidate instanceof Intern) {
//                updateIntern(connection, (Intern) candidate);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    private void updateExperience(Connection connection, Experience experience) throws SQLException {
//        String sql = "SELECT * FROM candidates WHERE candidateID = " + experience.getCandidateID();
//        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//             ResultSet resultSet = statement.executeQuery(sql)) {
//
//            if (resultSet.next()) {
//                resultSet.updateString("fullName", experience.getFullName());
//                resultSet.updateDate("birthDay", new java.sql.Date(experience.getBirthDay().getTime()));
//                resultSet.updateString("phone", experience.getPhone());
//                resultSet.updateString("email", experience.getEmail());
//                resultSet.updateInt("candidateType", experience.getCandidateType());
//                resultSet.updateRow();
//            }
//
//            String expSql = "SELECT * FROM experience WHERE candidateID = " + experience.getCandidateID();
//            try (ResultSet expResultSet = statement.executeQuery(expSql)) {
//                if (expResultSet.next()) {
//                    expResultSet.updateInt("ExpInYear", experience.getExpInYear());
//                    expResultSet.updateString("proSkill", experience.getProSkill());
//                    expResultSet.updateRow();
//                }
//            }
//        }
//    }
//
//    private void updateFresher(Connection connection, Fresher fresher) throws SQLException {
//        String sql = "SELECT * FROM candidates WHERE candidateID = " + fresher.getCandidateID();
//        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//             ResultSet resultSet = statement.executeQuery(sql)) {
//
//            if (resultSet.next()) {
//                resultSet.updateString("fullName", fresher.getFullName());
//                resultSet.updateDate("birthDay", new java.sql.Date(fresher.getBirthDay().getTime()));
//                resultSet.updateString("phone", fresher.getPhone());
//                resultSet.updateString("email", fresher.getEmail());
//                resultSet.updateInt("candidateType", fresher.getCandidateType());
//                resultSet.updateRow();
//            }
//
//            String fresherSql = "SELECT * FROM fresher WHERE candidateID = " + fresher.getCandidateID();
//            try (ResultSet fresherResultSet = statement.executeQuery(fresherSql)) {
//                if (fresherResultSet.next()) {
//                    fresherResultSet.updateDate("graduationDate", new java.sql.Date(fresher.getGraduationDate().getTime()));
//                    fresherResultSet.updateString("graduationRank", fresher.getGraduationRank());
//                    fresherResultSet.updateString("education", fresher.getEducation());
//                    fresherResultSet.updateRow();
//                }
//            }
//        }
//    }
//
//    private void updateIntern(Connection connection, Intern intern) throws SQLException {
//        String sql = "SELECT * FROM candidates WHERE candidateID = " + intern.getCandidateID();
//        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//             ResultSet resultSet = statement.executeQuery(sql)) {
//
//            if (resultSet.next()) {
//                resultSet.updateString("fullName", intern.getFullName());
//                resultSet.updateDate("birthDay", new java.sql.Date(intern.getBirthDay().getTime()));
//                resultSet.updateString("phone", intern.getPhone());
//                resultSet.updateString("email", intern.getEmail());
//                resultSet.updateInt("candidateType", intern.getCandidateType());
//                resultSet.updateRow();
//            }
//
//            String internSql = "SELECT * FROM intern WHERE candidateID = " + intern.getCandidateID();
//            try (ResultSet internResultSet = statement.executeQuery(internSql)) {
//                if (internResultSet.next()) {
//                    internResultSet.updateString("majors", intern.getMajors());
//                    internResultSet.updateString("semester", intern.getSemester());
//                    internResultSet.updateString("universityName", intern.getUniversityName());
//                    internResultSet.updateRow();
//                }
//            }
//        }
//    }


    //TODO: 8/7/2024 UPDATE FUCNTION
    @Override
    public void updateCandidate(Candidate candidate) throws SQLException {
        try (Connection connection = getConnection()) {
            if (candidate instanceof Experience) {
                updateExperience(connection, (Experience) candidate);
            } else if (candidate instanceof Fresher) {
                updateFresher(connection, (Fresher) candidate);
            } else if (candidate instanceof Intern) {
                updateIntern(connection, (Intern) candidate);
            }
        }
    }

    private void updateExperience(Connection connection, Experience experience) throws SQLException {
        // Update the candidate base information
        String sql = "SELECT * FROM candidates WHERE candidateID = " + experience.getCandidateID();
        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(sql)) {

            if (resultSet.next()) {
                int currentCandidateType = resultSet.getInt("candidateType");

                resultSet.updateString("fullName", experience.getFullName());
                resultSet.updateDate("birthDay", new java.sql.Date(experience.getBirthDay().getTime()));
                resultSet.updateString("phone", experience.getPhone());
                resultSet.updateString("email", experience.getEmail());
                resultSet.updateInt("candidateType", experience.getCandidateType());
                resultSet.updateRow();

                // nếu đổi type thì xóa data cũ
                if (currentCandidateType != experience.getCandidateType()) {
                    deleteOldCandidateSubclassData(connection, experience.getCandidateID(), currentCandidateType);
                }
            }

            // upd exp hoặc add nếu chưa có
            String expSql = "SELECT * FROM experience WHERE candidateID = " + experience.getCandidateID();
            try (ResultSet expResultSet = statement.executeQuery(expSql)) {
                if (expResultSet.next()) {
                    expResultSet.updateInt("ExpInYear", experience.getExpInYear());
                    expResultSet.updateString("proSkill", experience.getProSkill());
                    expResultSet.updateRow();
                } else {
                    // add data mới
                    String insertExpSql = "INSERT INTO experience (candidateID, ExpInYear, proSkill) VALUES (?, ?, ?)";
                    try (PreparedStatement insertExpStmt = connection.prepareStatement(insertExpSql)) {
                        insertExpStmt.setInt(1, experience.getCandidateID());
                        insertExpStmt.setInt(2, experience.getExpInYear());
                        insertExpStmt.setString(3, experience.getProSkill());
                        insertExpStmt.executeUpdate();
                    }
                }
            }
        }
    }

    private void updateFresher(Connection connection, Fresher fresher) throws SQLException {

        String sql = "SELECT * FROM candidates WHERE candidateID = " + fresher.getCandidateID();
        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(sql)) {

            if (resultSet.next()) {
                int currentCandidateType = resultSet.getInt("candidateType");

                resultSet.updateString("fullName", fresher.getFullName());
                resultSet.updateDate("birthDay", new java.sql.Date(fresher.getBirthDay().getTime()));
                resultSet.updateString("phone", fresher.getPhone());
                resultSet.updateString("email", fresher.getEmail());
                resultSet.updateInt("candidateType", fresher.getCandidateType());
                resultSet.updateRow();

                // If candidate type changed, remove old subclass data
                if (currentCandidateType != fresher.getCandidateType()) {
                    deleteOldCandidateSubclassData(connection, fresher.getCandidateID(), currentCandidateType);
                }
            }


            String fresherSql = "SELECT * FROM fresher WHERE candidateID = " + fresher.getCandidateID();
            try (ResultSet fresherResultSet = statement.executeQuery(fresherSql)) {
                if (fresherResultSet.next()) {
                    fresherResultSet.updateDate("graduationDate", new java.sql.Date(fresher.getGraduationDate().getTime()));
                    fresherResultSet.updateString("graduationRank", fresher.getGraduationRank());
                    fresherResultSet.updateString("education", fresher.getEducation());
                    fresherResultSet.updateRow();
                } else {

                    String insertFresherSql = "INSERT INTO fresher (candidateID, graduationDate, graduationRank, education) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement insertFresherStmt = connection.prepareStatement(insertFresherSql)) {
                        insertFresherStmt.setInt(1, fresher.getCandidateID());
                        insertFresherStmt.setDate(2, new java.sql.Date(fresher.getGraduationDate().getTime()));
                        insertFresherStmt.setString(3, fresher.getGraduationRank());
                        insertFresherStmt.setString(4, fresher.getEducation());
                        insertFresherStmt.executeUpdate();
                    }
                }
            }
        }
    }

    private void updateIntern(Connection connection, Intern intern) throws SQLException {

        String sql = "SELECT * FROM candidates WHERE candidateID = " + intern.getCandidateID();
        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(sql)) {

            if (resultSet.next()) {
                int currentCandidateType = resultSet.getInt("candidateType");

                resultSet.updateString("fullName", intern.getFullName());
                resultSet.updateDate("birthDay", new java.sql.Date(intern.getBirthDay().getTime()));
                resultSet.updateString("phone", intern.getPhone());
                resultSet.updateString("email", intern.getEmail());
                resultSet.updateInt("candidateType", intern.getCandidateType());
                resultSet.updateRow();


                if (currentCandidateType != intern.getCandidateType()) {
                    deleteOldCandidateSubclassData(connection, intern.getCandidateID(), currentCandidateType);
                }
            }


            String internSql = "SELECT * FROM intern WHERE candidateID = " + intern.getCandidateID();
            try (ResultSet internResultSet = statement.executeQuery(internSql)) {
                if (internResultSet.next()) {
                    internResultSet.updateString("majors", intern.getMajors());
                    internResultSet.updateString("semester", intern.getSemester());
                    internResultSet.updateString("universityName", intern.getUniversityName());
                    internResultSet.updateRow();
                } else {

                    String insertInternSql = "INSERT INTO intern (candidateID, majors, semester, universityName) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement insertInternStmt = connection.prepareStatement(insertInternSql)) {
                        insertInternStmt.setInt(1, intern.getCandidateID());
                        insertInternStmt.setString(2, intern.getMajors());
                        insertInternStmt.setString(3, intern.getSemester());
                        insertInternStmt.setString(4, intern.getUniversityName());
                        insertInternStmt.executeUpdate();
                    }
                }
            }
        }
    }

    private void deleteOldCandidateSubclassData(Connection connection, int candidateID, int candidateType) throws SQLException {
        String deleteSql = null;

        switch (candidateType) {
            case 0: // Experience
                deleteSql = "DELETE FROM experience WHERE candidateID = ?";
                break;
            case 1: // Fresher
                deleteSql = "DELETE FROM fresher WHERE candidateID = ?";
                break;
            case 2: // Intern
                deleteSql = "DELETE FROM intern WHERE candidateID = ?";
                break;
        }

        if (deleteSql != null) {
            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteSql)) {
                deleteStmt.setInt(1, candidateID);
                deleteStmt.executeUpdate();
            }
        }
    }

    // TODO: 8/7/2024 DELETE FUNCTION
    @Override
    public void deleteCandidateById(int candidateID) throws SQLException {
        try (Connection connection = getConnection()) {
            String sql = "SELECT candidateType FROM candidates WHERE candidateID = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, candidateID);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int candidateType = rs.getInt("candidateType");
                        deleteOldCandidateSubclassData(connection, candidateID, candidateType);
                        String deleteCandidateSql = "DELETE FROM candidates WHERE candidateID = ?";
                        try (PreparedStatement deleteStmt = connection.prepareStatement(deleteCandidateSql)) {
                            deleteStmt.setInt(1, candidateID);
                            deleteStmt.executeUpdate();
                        }
                    }
                }
            }
        }
    }


    @Override
    public List<Candidate> getAllCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        String candidateQuery = "SELECT * FROM candidates";

        try (Connection connection = getConnection();
             Statement candidateStmt = connection.createStatement();
             ResultSet candidateRs = candidateStmt.executeQuery(candidateQuery)) {

            while (candidateRs.next()) {
                int candidateID = candidateRs.getInt("candidateID");
                String fullName = candidateRs.getString("fullName");
                Date birthDay = candidateRs.getDate("birthDay");
                String phone = candidateRs.getString("phone");
                String email = candidateRs.getString("email");
                int candidateType = candidateRs.getInt("candidateType");

                Candidate candidate = null;

                switch (candidateType) {
                    case 0: // Experience
                        candidate = getExperienceCandidate(connection, candidateID, fullName, birthDay, phone, email, candidateType);
                        break;
                    case 1: // Fresher
                        candidate = getFresherCandidate(connection, candidateID, fullName, birthDay, phone, email, candidateType);
                        break;
                    case 2: // Intern
                        candidate = getInternCandidate(connection, candidateID, fullName, birthDay, phone, email, candidateType);
                        break;
                }

                if (candidate != null) {
                    candidates.add(candidate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return candidates;
    }
    private Experience getExperienceCandidate(Connection connection, int candidateID, String fullName, Date birthDay, String phone, String email, int candidateType) throws SQLException {
        String experienceQuery = "SELECT * FROM experience WHERE candidateID = ?";
        Experience experience = null;

        try (PreparedStatement experienceStmt = connection.prepareStatement(experienceQuery)) {
            experienceStmt.setInt(1, candidateID);
            ResultSet experienceRs = experienceStmt.executeQuery();

            if (experienceRs.next()) {
                int expInYear = experienceRs.getInt("ExpInYear");
                String proSkill = experienceRs.getString("proSkill");

                experience = new Experience();
                experience.setCandidateID(candidateID);
                experience.setFullName(fullName);
                experience.setBirthDay(birthDay);
                experience.setPhone(phone);
                experience.setEmail(email);
                experience.setCandidateType(candidateType);
                experience.setExpInYear(expInYear);
                experience.setProSkill(proSkill);
            }
        }

        return experience;
    }

    private Fresher getFresherCandidate(Connection connection, int candidateID, String fullName, Date birthDay, String phone, String email, int candidateType) throws SQLException {
        String fresherQuery = "SELECT * FROM fresher WHERE candidateID = ?";
        Fresher fresher = null;

        try (PreparedStatement fresherStmt = connection.prepareStatement(fresherQuery)) {
            fresherStmt.setInt(1, candidateID);
            ResultSet fresherRs = fresherStmt.executeQuery();

            if (fresherRs.next()) {
                Date graduationDate = fresherRs.getDate("graduationDate");
                String graduationRank = fresherRs.getString("graduationRank");
                String education = fresherRs.getString("education");

                fresher = new Fresher();
                fresher.setCandidateID(candidateID);
                fresher.setFullName(fullName);
                fresher.setBirthDay(birthDay);
                fresher.setPhone(phone);
                fresher.setEmail(email);
                fresher.setCandidateType(candidateType);
                fresher.setGraduationDate(graduationDate);
                fresher.setGraduationRank(graduationRank);
                fresher.setEducation(education);
            }
        }

        return fresher;
    }

    private Intern getInternCandidate(Connection connection, int candidateID, String fullName, Date birthDay, String phone, String email, int candidateType) throws SQLException {
        String internQuery = "SELECT * FROM intern WHERE candidateID = ?";
        Intern intern = null;

        try (PreparedStatement internStmt = connection.prepareStatement(internQuery)) {
            internStmt.setInt(1, candidateID);
            ResultSet internRs = internStmt.executeQuery();

            if (internRs.next()) {
                String majors = internRs.getString("majors");
                String semester = internRs.getString("semester");
                String universityName = internRs.getString("universityName");

                intern = new Intern();
                intern.setCandidateID(candidateID);
                intern.setFullName(fullName);
                intern.setBirthDay(birthDay);
                intern.setPhone(phone);
                intern.setEmail(email);
                intern.setCandidateType(candidateType);
                intern.setMajors(majors);
                intern.setSemester(semester);
                intern.setUniversityName(universityName);
            }
        }

        return intern;
    }

    @Override
    public void addCertificateToCandidate(int candidateID, int certificateID) {
        String query = "INSERT INTO candidate_certificates (candidateID, certificateID) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, candidateID);
            preparedStatement.setInt(2, certificateID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
