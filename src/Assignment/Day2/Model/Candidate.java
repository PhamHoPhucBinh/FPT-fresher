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
}
