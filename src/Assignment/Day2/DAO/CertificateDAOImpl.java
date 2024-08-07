package Assignment.Day2.DAO;

import Assignment.Day2.Model.Certificate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class CertificateDAOImpl implements CertificateDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/CandidateManagement";
    private static final String username = "root";
    private static final String password = "12345";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Unable to load MySQL Driver", e);
        }
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    public void addCertificate(Certificate certificate) {
        String query = "INSERT INTO certificates (certificateName, certificateRank, certificateDate) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, certificate.getCertificateName());
            preparedStatement.setString(2, certificate.getCertificateRank());
            preparedStatement.setDate(3, new java.sql.Date(certificate.getCertificateDate().getTime()));
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                certificate.setCertificateID(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCertificate(Certificate certificate) {
        String query = "UPDATE certificates SET certificateName = ?, certificateRank = ?, certificateDate = ? WHERE certificateID = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, certificate.getCertificateName());
            preparedStatement.setString(2, certificate.getCertificateRank());
            preparedStatement.setDate(3, new java.sql.Date(certificate.getCertificateDate().getTime()));
            preparedStatement.setInt(4, certificate.getCertificateID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCertificateById(int certificateID) {
        String query = "DELETE FROM certificates WHERE certificateID = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, certificateID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Certificate getCertificateById(int certificateId) {
        return null;
    }


    @Override
    public List<Certificate> getCertificatesByCandidateId(int candidateID) {
        return null;
    }


    @Override
    public List<Certificate> getAllCertificates() {
        List<Certificate> certificates = new ArrayList<>();
        String query = "SELECT * FROM certificates";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Certificate certificate = new Certificate();
                certificate.setCertificateID(resultSet.getInt("certificateID"));
                certificate.setCertificateName(resultSet.getString("certificateName"));
                certificate.setCertificateRank(resultSet.getString("certificateRank"));
                certificate.setCertificateDate(resultSet.getDate("certificateDate"));
                certificates.add(certificate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return certificates;
    }

    private int getLastInsertedCertificateID(Connection connection) throws SQLException {
        String sql = "SELECT LAST_INSERT_ID()";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return -1;
    }

}