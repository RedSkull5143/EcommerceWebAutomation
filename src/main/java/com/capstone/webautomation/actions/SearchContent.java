package com.capstone.webautomation.actions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchContent {
    private String input;

    public SearchContent init(){
        return SearchContent.builder()
                .input("Dress")
                .build();
    }
}
