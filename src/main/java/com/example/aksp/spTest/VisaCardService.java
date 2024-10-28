package com.example.aksp.spTest;

import org.springframework.stereotype.Service;

@Service
public class VisaCardService implements Card{
    @Override
    public String getInfo() {
        return "VisaCardService";
    }
}
