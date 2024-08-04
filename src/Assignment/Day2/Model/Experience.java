package Assignment.Day2.Model;

import java.util.Date;

public class Experience extends Candidate{
    private int expInYear;
    private String proSkill;

    public Experience(int candidateID, String fullName, Date birthDay, String phone, String email, int expInYear, String proSkill) {
        super(candidateID, fullName, birthDay, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return  super.toString() + "Experience{" +
                "expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                "} ";
    }
}
