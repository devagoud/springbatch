package com.spring.batch;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Catalogue {
    private String name;
    private String colour;
//    private String image;

    public Catalogue(Catalogue catalogue) {
        this.name = catalogue.getName();
        this.colour = catalogue.getColour();
    }

    public Catalogue(String string, String string1) {
        this.name = string;
        this.colour = string1;
    }
}
