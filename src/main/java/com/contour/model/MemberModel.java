package com.contour.model;

import com.contour.utilities.DataFaker;
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

    public MemberModel() {
        this.firstName = DataFaker.getFirstName();
        this.lastName = DataFaker.getLastName();
        this.title = "DEV";
        this.company = "Contour";
        this.phoneNumber = DataFaker.getPhone();
        this.web = DataFaker.getWeb();
        this.email = DataFaker.getEmail();
    }

    public static MemberModel createNewMember(){
        return new MemberModel();
    }
}
