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
    public Experience( String fullName, Date birthDay, String phone, String email, int expInYear, String proSkill) {
        super(fullName, birthDay, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Experience(int expInYear, String proSkill) {
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Experience(int candidateID, String fullName, Date birthDay, String phone, String email, int candidateType, int expInYear, String proSkill) {
        super(candidateID, fullName, birthDay, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Experience(String fullName, Date birthDay, String phone, String email, int candidateType, int expInYear, String proSkill) {
        super(fullName, birthDay, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Experience() {
    }

    @Override
    public String toString() {
        return  super.toString() + "Experience{" +
                "expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                "} ";
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
