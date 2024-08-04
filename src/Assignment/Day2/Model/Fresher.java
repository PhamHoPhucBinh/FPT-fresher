package Assignment.Day2.Model;

import java.util.Date;

public class Fresher extends Candidate{
    private Date graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(int candidateID, String fullName, Date birthDay, String phone, String email, Date graduationDate, String graduationRank, String education) {
        super(candidateID, fullName, birthDay, phone, email, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public String toString() {
        return super.toString() + "Fresher{" +
                "graduationDate=" + graduationDate +
                ", graduationRank='" + graduationRank + '\'' +
                ", education='" + education + '\'' +
                "} " ;
    }
}
