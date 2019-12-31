package com.spring.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@Slf4j
public class Writer implements ItemWriter<Catalogue> {


    @Override
    public void write(List<? extends Catalogue> list) throws Exception {
        log.info("Catalogue information {}", list);
    }
}
