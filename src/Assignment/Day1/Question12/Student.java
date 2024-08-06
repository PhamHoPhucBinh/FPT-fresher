package Assignment.Day1.Question12;
class Student{
    String StdNo ;
    String StdName;
    String Phone;
    String StdEmail;
    double GradePoint;

    public Student(String stdNo, String stdName, String phone, String stdEmail, double gradePoint) {
        StdNo = stdNo;
        StdName = stdName;
        Phone = phone;
        StdEmail = stdEmail;
        GradePoint = gradePoint;
    }

    public String getStdNo() {
        return StdNo;
    }

    public void setStdNo(String stdNo) {
        StdNo = stdNo;
    }

    public String getStdName() {
        return StdName;
    }

    public void setStdName(String stdName) {
        StdName = stdName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getStdEmail() {
        return StdEmail;
    }

    public void setStdEmail(String stdEmail) {
        StdEmail = stdEmail;
    }

    public double getGradePoint() {
        return GradePoint;
    }

    public void setGradePoint(double gradePoint) {
        GradePoint = gradePoint;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StdNo=" + StdNo +
                ", StdName='" + StdName + '\'' +
                ", Phone='" + Phone + '\'' +
                ", StdEmail='" + StdEmail + '\'' +
                ", GradePoint=" + GradePoint +
                '}';
    }
}

