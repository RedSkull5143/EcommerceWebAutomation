package com.capstone.webautomation.models;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedBack {
    private String name;
    private String emailID;
    private String phoneNo;
    private String comment;

    public FeedBack validDetails(){
        Faker faker=new Faker();
        return FeedBack.builder()
                .name(faker.name().fullName())
                .emailID(faker.internet().emailAddress())
                .phoneNo(faker.phoneNumber().cellPhone())
                .comment(faker.lorem().paragraph())
                .build();
    }
}
