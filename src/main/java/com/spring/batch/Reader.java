package com.spring.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Reader implements ItemReader<Catalogue> {
    int index = 0;
    @Override
    public Catalogue read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        List<Catalogue> list = new ArrayList();
        list.add(new Catalogue("devagoud ", "rangol"));
        list.add(new Catalogue("deva ", "ran"));
        list.add(new Catalogue("d ", "ran"));

        Catalogue catalogue = null;
        if (index < list.size()) {
            catalogue = list.get(index);
            index++;
            return catalogue;
        } else {
            return null;
        }

    }
}
