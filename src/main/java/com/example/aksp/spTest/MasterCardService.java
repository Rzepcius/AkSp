package com.example.aksp.spTest;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MasterCardService implements Card {

    public MasterCardService() {
    }
    @Override
    public String getInfo(){
        return "MasterCardService";
    }
}
