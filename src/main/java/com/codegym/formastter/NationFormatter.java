package com.codegym.formastter;

import com.codegym.model.Nation;
import com.codegym.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class NationFormatter implements Formatter<Nation> {

    private INationService nationService;
    @Autowired
    public NationFormatter(INationService nationService){
        this.nationService = nationService;
    }

    @Override
    public Nation parse(String text, Locale locale) throws ParseException {
        return nationService.findOne(Long.parseLong(text));
    }

    @Override
    public String print(Nation object, Locale locale) {
        return "[" +object.getName()+"]";
    }
}
