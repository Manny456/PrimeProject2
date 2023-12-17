package com.example.PrimeProject.Restaurantv1;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;

@Entity
@Table(name = "RESTAURANT")
@ToString
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PersonSubmitting")
    private String personSubmitting;
    @Column(name = "PeanutScore")
    private Integer peanutScore;
    @Column(name = "EggScore")
    private Integer eggScore;
    @Column(name = "DairyScore")
    private Integer dairyScore;
    @Column(name = "Optional")
    private String comment;
//    @Column(name = "IsReviewAccepted")
//    private Boolean isReviewAccepted;
    @Column(name = "PersonZipCode")
    private String personZipCode;
    @Column(name = "PersonSTate")
    private String personState;
    @Column(name = "PersonCity")
    private String personCity;
    @Column(name = "InterestInPeanutAllergies")
    private Boolean interestInPeanutAllergies;
    @Column(name = "InterestInEggAllergies")
    private Boolean interestInEggAllergies;
    @Column(name = "InterestInDairyAllergies")
    private Boolean interestInDairyAllergies;

    public Restaurant(){
    }

    public Restaurant(String personSubmitting, Integer peanutScore, Integer eggScore, Integer dairyScore, String comment) {
        this.personSubmitting = personSubmitting;
        this.peanutScore = peanutScore;
        this.eggScore = eggScore;
        this.dairyScore = dairyScore;
        this.comment = comment;
    }

    public Restaurant(String personSubmitting, Integer peanutScore, Integer eggScore, Integer dairyScore, String comment, String personZipCode, String personState, String personCity, Boolean interestInPeanutAllergies, Boolean interestInEggAllergies, Boolean interestInDairyAllergies) {
        this.personSubmitting = personSubmitting;
        this.peanutScore = peanutScore;
        this.eggScore = eggScore;
        this.dairyScore = dairyScore;
        this.comment = comment;
//        this.isReviewAccepted = isReviewAccepted;
        this.personZipCode = personZipCode;
        this.personState = personState;
        this.personCity = personCity;
        this.interestInPeanutAllergies = interestInPeanutAllergies;
        this.interestInEggAllergies = interestInEggAllergies;
        this.interestInDairyAllergies = interestInDairyAllergies;
    }

    public Restaurant(Long id, String personSubmitting, Integer peanutScore, Integer eggScore, Integer dairyScore, String comment, String personZipCode, String personState, String personCity, Boolean interestInPeanutAllergies, Boolean interestInEggAllergies, Boolean interestInDairyAllergies) {
        this.id = id;
        this.personSubmitting = personSubmitting;
        this.peanutScore = peanutScore;
        this.eggScore = eggScore;
        this.dairyScore = dairyScore;
        this.comment = comment;
//        this.isReviewAccepted = isReviewAccepted;
        this.personZipCode = personZipCode;
        this.personState = personState;
        this.personCity = personCity;
        this.interestInPeanutAllergies = interestInPeanutAllergies;
        this.interestInEggAllergies = interestInEggAllergies;
        this.interestInDairyAllergies = interestInDairyAllergies;
    }

    public Long getId() {
        return id;
    }

    public String getPersonSubmitting() {

        return personSubmitting;
    }

    public Integer getPeanutScore() {

        return peanutScore;
    }

    public Integer getEggScore() {

        return eggScore;
    }

    public Integer getDairyScore() {

        return dairyScore;
    }

    public String getComment() {

        return comment;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public void setPersonSubmitting(String personSubmitting) {

        this.personSubmitting = personSubmitting;
    }

    public void setPeanutScore(Integer peanutScore) {

        this.peanutScore = peanutScore;
    }

    public void setEggScore(Integer eggScore) {

        this.eggScore = eggScore;
    }

    public void setDairyScore(Integer dairyScore) {

        this.dairyScore = dairyScore;
    }

    public void setComment(String comment) {

        this.comment = comment;
    }

//    public Boolean getReviewAccepted() {
//
//        return isReviewAccepted;
//    }

//    public void setReviewAccepted(Boolean reviewAccepted) {
//
//        isReviewAccepted = reviewAccepted;
//    }

    public String getPersonZipCode() {

        return personZipCode;
    }

    public void setPersonZipCode(String personZipCode) {

        this.personZipCode = personZipCode;
    }

    public String getPersonState() {
        return personState;
    }

    public void setPersonState(String personState) {

        this.personState = personState;
    }

    public String getPersonCity() {
        return personCity;
    }

    public void setPersonCity(String personCity) {

        this.personCity = personCity;
    }

    public Boolean getInterestInPeanutAllergies() {

        return interestInPeanutAllergies;
    }

    public void setInterestInPeanutAllergies(Boolean interestInPeanutAllergies) {
        this.interestInPeanutAllergies = interestInPeanutAllergies;
    }

    public Boolean getInterestInEggAllergies() {
        return interestInEggAllergies;
    }

    public void setInterestInEggAllergies(Boolean interestInEggAllergies) {
        this.interestInEggAllergies = interestInEggAllergies;
    }

    public Boolean getInterestInDairyAllergies() {
        return interestInDairyAllergies;
    }

    public void setInterestInDairyAllergies(Boolean interestInDairyAllergies) {
        this.interestInDairyAllergies = interestInDairyAllergies;
    }


}
