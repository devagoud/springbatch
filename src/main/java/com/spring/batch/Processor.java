package com.spring.batch;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<Catalogue,Catalogue> {
    @Override
    public Catalogue process(Catalogue catalogue) throws Exception {

        return catalogue;
    }
}
