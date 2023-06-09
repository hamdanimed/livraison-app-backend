package ensa.livraisonappbackend.service;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Randomizer {
    private static String alphanum="ABCDEFGHIJKLMNOPARSTUVWXYZ0123456789";

    public static String generateShipmentCode(){
        String code = "";
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 7;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphanum.length());

            // get character specified by index
            // from the string
            char randomChar = alphanum.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
