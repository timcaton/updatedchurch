package org.stpaul.model;

import org.stpaul.TransactionalEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "CHURCH_MEMBER")
public class ChurchMember extends TransactionalEntity {

        @Column(name = "FIRST_NAME")
        //@NotNull
        private String firstName;

        @Column(name = "MIDDLE_NAME")
        private String middleName;

        @Column(name = "LAST_NAME")
        //@NotNull
        private String lastName;

        @Column(name = "BAPTISM_ID")
        //@NotNull
        private Long baptismId;

        @Column(name = "MARRIAGE_ID")
        //@NotNull
        private Long marriageId;

        @Column(name = "FUNERAL_ID")
        private Long funeralId;

        @Column(name = "CONFIRMATION_ID")
        private Long confirmationId;

        @Column(name = "MEMBER_INFO")
        private String memberInfo;

        @Column(name = "CONTRIBUTION_ID")
        private Long contributionId;

        @Column(name = "ENVELOPE_ID")
        private Long envelopeId;

        @Column(name = "HOUSEHOLD_ID")
        private Long householdId;

        @Column(name = "COMMUNION_ID")
        private Long communionId;

        @Column(name = "DOB")
        //@NotNull
        private String dob;

        @Column(name = "GENDER")
        //@NotNull
        private String gender;

        @Column(name = "NICKNAME")
        //@NotNull
        private String nickname;

        @Column(name = "TITLE")
       //@NotNull
        private String title;

        @Column(name = "ETHNICITY")
        //@NotNull
        private String ethnicity;

        @Column(name = "SEQUENCE_IN_HOUSEHOLD")
        //@NotNull
        private Long sequenceInHousehold;

        @Column(name = "STATE")
        //@NotNull
        private String state;

        @Column(name = "CITY")
        //@NotNull
        private String city;

        @Column(name = "ZIP_CODE")
        //@NotNull
        private Long zipCode;

        @Column(name = "ADDRESS")
        //@NotNull
        private String address;

        @Column(name = "CARRIER_DATE")
        //@NotNull
        private String carrierDate;

        @Column(name = "Email")
        //@NotNull
        private String email;

        @Column(name = "STATUS")
        //@NotNull
        private String status;

        @Column(name = "RECEIVED_BY")
        //@NotNull
        private String receivedBy;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getBaptismId() {
        return baptismId;
    }

    public void setBaptismId(Long baptismId) {
        this.baptismId = baptismId;
    }

    public Long getMarriageId() {
        return marriageId;
    }

    public void setMarriageId(Long marriageId) {
        this.marriageId = marriageId;
    }

    public Long getFuneralId() {
        return funeralId;
    }

    public void setFuneralId(Long funeralId) {
        this.funeralId = funeralId;
    }

    public Long getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(Long confirmationId) {
        this.confirmationId = confirmationId;
    }

    public String getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(String memberInfo) {
        this.memberInfo = memberInfo;
    }

    public Long getContributionId() {
        return contributionId;
    }

    public void setContributionId(Long contributionId) {
        this.contributionId = contributionId;
    }

    public Long getEnvelopeId() {
        return envelopeId;
    }

    public void setEnvelopeId(Long envelopeId) {
        this.envelopeId = envelopeId;
    }

    public Long getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Long householdId) {
        this.householdId = householdId;
    }

    public Long getCommunionId() {
        return communionId;
    }

    public void setCommunionId(Long communionId) {
        this.communionId = communionId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Long getSequenceInHousehold() {
        return sequenceInHousehold;
    }

    public void setSequenceInHousehold(Long sequenceInHousehold) {
        this.sequenceInHousehold = sequenceInHousehold;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCarrierDate() {
        return carrierDate;
    }

    public void setCarrierDate(String carrierDate) {
        this.carrierDate = carrierDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ChurchMember that = (ChurchMember) o;
            return Objects.equals(this.getId(), that.getId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), this.getId());
        }
}
