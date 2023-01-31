package com.contour.model;

import lombok.Data;

@Data
public class MemberModel {
    private String firstName;
    private String lastName;
    private String title;
    private String company;
    private String phoneNumber;
    private String web;
    private String email;

    public MemberModel(String firstName, String lastName, String title, String company, String phoneNumber, String web, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.web = web;
        this.email = email;
    }

    public MemberModel createMember(String firstName, String lastName, String title, String company, String phoneNumber, String web, String email){
        return new MemberModel(firstName, lastName, title, company, phoneNumber, web, email);
    }
}
