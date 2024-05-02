package com.capstone.webautomation.actions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerifySearch {
    private String input;

    public VerifySearch init(){
        return VerifySearch.builder()
                .input("Megara Dress")
                .build();
    }
}
