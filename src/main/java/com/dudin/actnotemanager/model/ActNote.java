package com.dudin.actnotemanager.model;

import lombok.Data;

import javax.persistence.*;


//Hibernate
@Data
@Entity
@Table(name = "act_notes")
public class ActNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dateOfRegistration;

    private String dateOfChange;

    // Child information
    @Transient
    private boolean flagStatusOfNewborn;

    private String statusOfNewborn;
    private String childSurname;
    private String childName;
    private String ChildPatronymic;
    private String childDateOfBirth;
    private String childGender;
    private String childCountry;
    private String childPopulatedLocality;
    private String childIin;
    private String childNumberOfChildrenBorn;
    private String childTypeOfDocument;
    private String childNumberOfDocument;
    private String childIssuingAuthority;
    private String childDateOfIssueOfTheDocument;
    // Parent information
    private String parentSurname;
    private String parentName;
    private String parentPatronymic;
    private String parentDateOfBirth;
    private String parentGender;
    private String parentCountry;
    private String parentPopulatedLocality;
    private String parentIin;
    private String parentNationality;
    private String parentCitizenship;
    private String parentTypeOfDocument;
    private String parentNumberOfDocument;
    private String parentSeriesOfDocument;
    private String parentIssuingAuthority;
    private String parentDateOfIssueOfTheDocument;

    public ActNote() {
        this.dateOfChange = new MyLocalDate().getMyLocalDate();
        this.childNumberOfChildrenBorn = "1";
    }
}
