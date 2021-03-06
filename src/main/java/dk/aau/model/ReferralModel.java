package dk.aau.model;

import java.sql.Date;

public class ReferralModel extends PatientModel {
    private Date referralSentDate;
    private Date referralRecievedDate;
    private String referredBy;
    private String waitingGroup;
    private String diagnosisText;
    private String course;
    private String referralID;
    private String anamnesis;
    private String referralType;
    private String responsibleUnit;

    // Constructor
    public ReferralModel(String name, String address, Integer cprNumber, Integer postalCode, String city,
            Date referralSentDate, Date referralRecievedDate, String referredBy, String waitingGroup,
            String diagnosisText, String course, String referralID, String anamnesis, String referralType,
            String responsibleUnit) {
        super(name, address, cprNumber, postalCode, city);
        this.referralSentDate = referralSentDate;
        this.referralRecievedDate = referralRecievedDate;
        this.referredBy = referredBy;
        this.waitingGroup = waitingGroup;
        this.diagnosisText = diagnosisText;
        this.course = course;
        this.referralID = referralID;
        this.anamnesis = anamnesis;
        this.referralType = referralType;
        this.responsibleUnit = responsibleUnit;
    }

    // Getters
    public Date getReferralSentDate() {
        return referralSentDate;
    }

    public Date getReferralRecievedDate() {
        return referralRecievedDate;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public String getWaitingGroup() {
        return waitingGroup;
    }

    public String getDiagnosisText() {
        return diagnosisText;
    }

    public String getCourse() {
        return course;
    }

    public String getReferralID() {
        return referralID;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public String getReferralType() {
        return referralType;
    }

    public String getResponsibleUnit() {
        return responsibleUnit;
    }

}