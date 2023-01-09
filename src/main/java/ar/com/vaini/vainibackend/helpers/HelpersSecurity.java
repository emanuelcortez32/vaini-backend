package ar.com.vaini.vainibackend.helpers;

import ar.com.vaini.vainibackend.model.facebook.FacebookUserProfile;
import ar.com.vaini.vainibackend.model.User;

import java.util.Random;

public class HelpersSecurity {
    public static String generateUsername(String firstName, String lastName) {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        return String.format("%s.%s.%06d", firstName, lastName, number);
    }

    public static String generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for (int i = 4; i < length; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return new String(password);
    }

    public static User convertToUser(FacebookUserProfile facebookUserProfile) {
        return User.builder()
                .id(facebookUserProfile.getIdUser())
                .name(facebookUserProfile.getFirstName())
                .lastName(facebookUserProfile.getLastName())
                .email(facebookUserProfile.getEmail())
                .username(HelpersSecurity.generateUsername(facebookUserProfile.getFirstName(), facebookUserProfile.getLastName()))
                .password(HelpersSecurity.generatePassword(8))
                .build();
    }
}
