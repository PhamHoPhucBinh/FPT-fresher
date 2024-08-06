package Assignment.Day2.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Candidate {
    protected static int candidateCount=0;
    protected int candidateID;
    protected String fullName;
    protected Date birthDay;
    protected String phone;
    protected String email;
    protected int candidateType;
    protected List<Certificate> certificates = new ArrayList<>();

    public Candidate() {
    }

    public Candidate(int candidateID, String fullName, Date birthDay, String phone, String email, int candidateType) {
        this.candidateID = candidateID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
        candidateCount++;
    }
//    public abstract void showInfo();

    public void addCertificate(Certificate certificate) {
        certificates.add(certificate);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateID=" + candidateID +
                ", fullName='" + fullName + '\'' +
                ", birthDay=" + birthDay +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", candidateType=" + candidateType +
                ", certificates=" + certificates +
                '}';
    }

    public static int getCandidateCount() {
        return candidateCount;
    }

    public static void setCandidateCount(int candidateCount) {
        Candidate.candidateCount = candidateCount;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}
