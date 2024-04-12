package com.sansilvestre.desktop.app.product.create.domain.util;

import com.sansilvestre.desktop.app.Language;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateParser {

    public String parse(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d 'de' MMMM 'del' yyyy", new Locale(Language.getSystemLanguage()));
        return dateTimeFormatter.format(date);
    }

}