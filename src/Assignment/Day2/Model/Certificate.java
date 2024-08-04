package Assignment.Day2.Model;

import java.util.Date;

public class Certificate {
    private int certificateID;
    private String certificateName;
    private String certificateRank;
    private Date certificateDate;

    public Certificate(int certificateID, String certificateName, String certificateRank, Date certificateDate) {
        this.certificateID = certificateID;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificateDate = certificateDate;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "certificateID=" + certificateID +
                ", certificateName='" + certificateName + '\'' +
                ", certificateRank='" + certificateRank + '\'' +
                ", certificateDate=" + certificateDate +
                '}';
    }
}
