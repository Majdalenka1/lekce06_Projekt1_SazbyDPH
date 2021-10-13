package com.entego.vat;

public class Country {
    private String abbreviation;
    private String name;
    private int fullVat;
    private String lowerVat;
    private boolean has_exception;

    public Country(String abbreviation, String name, int fullVat, String lowerVat, boolean has_exception) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.fullVat = fullVat;
        this.lowerVat = lowerVat;
        this.has_exception = has_exception;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public int getFullVat() {
        return fullVat;
    }

    public String getLowerVat() {
        return lowerVat;
    }

    public boolean isHas_exception() {
        return has_exception;
    }

    @Override
    public String toString() {
        return "Country{" +
                "abbreviation='" + abbreviation + '\'' +
                ", name='" + name + '\'' +
                ", full_vat=" + fullVat +
                ", lower_vat=" + lowerVat +
                ", has_exception=" + has_exception +
                '}';
    }
}
