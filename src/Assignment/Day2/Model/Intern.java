package Assignment.Day2.Model;

import java.util.Date;

public class Intern extends Candidate {
    private String majors;
    private String semester;
    private String universityName;

    public Intern(int candidateID, String fullName, Date birthDay, String phone, String email, String majors, String semester, String universityName) {
        super(candidateID, fullName, birthDay, phone, email, 2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }
    public Intern(){};

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return super.toString() + "Intern{" +
                "majors='" + majors + '\'' +
                ", semester='" + semester + '\'' +
                ", universityName='" + universityName + '\'' +
                "} ";
    }
}
