package com.company.telephony;

public class Smartphone implements Calling, Browsing {

    public Smartphone() {
    }

    @Override
    public void Browse(String webSite) {
        if (validateWebSite(webSite)) {
            System.out.println("Invalid URL!");
        } else {
            System.out.println(String.format("Browsing: %s!", webSite));
        }
    }

    private boolean validateWebSite(String webSite) {
        for (int i = 0; i < webSite.length(); i++) {
            String token = String.valueOf(webSite.charAt(i));
            if (isInteger(token)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInteger(String input)
        {
            try {
                Integer.parseInt(input);
            } catch(NumberFormatException e) {
                return false;
            }
    // only got here if we didn't return false
    return true;
    }
    
    @Override
    public void Call(String phoneNumber) {
        if (validatePhoneNumber(phoneNumber)) {
            System.out.println("Invalid number!");
        } else {
            System.out.println(String.format("Calling... %s", phoneNumber));
        }
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        for (int i = 0; i < phoneNumber.length(); i++) {
            String token = String.valueOf(phoneNumber.charAt(i));
            if (!isInteger(token)) {
                return true;
            }
        }
        return false;
    }
}
