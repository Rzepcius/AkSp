package com.example.aksp.spTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {

    private MessageSource messageSource;

    @Autowired
    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
//        String tekst = messageSource.getMessage("hello",new Object[]{"Andrzej", "Rzepecki"}
//                , Locale.forLanguageTag("PL"));
        String tekst = messageSource.getMessage("hello",new Object[]{"Andrzej", "Rzepecki"}
                , Locale.forLanguageTag("EN"));
        System.out.println(tekst);
    }

}
