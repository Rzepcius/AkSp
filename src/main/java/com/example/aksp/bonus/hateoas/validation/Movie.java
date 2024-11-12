package com.example.aksp.bonus.hateoas.validation;

import jakarta.validation.constraints.*;

/**
 * @author andrzej.rzepecki
 **/


public class Movie {

    @NotNull(message = "why no name?")
    @Size(min = 2,max = 60)
    private String name;

    @Min(2000)
    @Max(2020)
    private int year;

    @Email
    @NotNull
    private String reportersMail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getReportersMail() {
        return reportersMail;
    }

    public void setReportersMail(String reportersMail) {
        this.reportersMail = reportersMail;
    }
}
