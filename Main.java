package com.entego.vat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String VAT_FILE = "vat.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(VAT_FILE));
        List<Country> countries = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String l = scanner.nextLine();
            Scanner line = new Scanner(l);
            line.useDelimiter("\t");
            Country country = new Country(line.next(), line.next(), line.nextInt(), line.next(), line.nextBoolean());
            countries.add(country);
        }

        for (Country country: countries) {
            System.out.printf("%s (%s): %d %%\n", country.getName(), country.getAbbreviation(), country.getFullVat());
        }
        System.out.println("....");
        List<Country> exceptions = new ArrayList<>();
        for (Country country: countries) {
            if (country.getFullVat() > 20 && !country.isHas_exception()) {
                System.out.printf("%s (%s): %d %%\n", country.getName(), country.getAbbreviation(), country.getFullVat());
            } else {
                exceptions.add(country);
            }
        }
        System.out.println("....");
        countries.sort(new Comparator<>() {
            @Override
            public int compare(Country o1, Country o2) {
                return o2.getFullVat() - o1.getFullVat();
            }
        });
        for (Country country: countries) {
            System.out.printf("%s (%s): %d %%\n", country.getName(), country.getAbbreviation(), country.getFullVat());
        }
        System.out.println("....");
        System.out.print("Sazba VAT 20% nebo nizsi nebo pouzivaji specialni sazbu: ");
        for (Country country: exceptions) {
            if (country.getFullVat() <= 20 || country.isHas_exception()) {
                System.out.printf("%s ", country.getAbbreviation());
            }
        }
    }
}
