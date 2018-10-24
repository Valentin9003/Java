package com.company;

import java.util.Scanner;

public class PhotoPictures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int brPhotos = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String purchaiseType = scanner.nextLine();

        double sum = 0.0;

        switch (type) {
            case "9X13":
                sum = brPhotos * 0.16;
                if (brPhotos >= 50) {
                    sum = brPhotos * 0.16 - ((brPhotos * 0.16) * 0.05);
                }
                break;
            case "10X15":
                sum = brPhotos * 0.16;
                if (brPhotos >= 80) {
                    sum = brPhotos * 0.16 - ((brPhotos * 0.16) * 0.03);
                }
                break;
            case "13X18":
                sum = brPhotos * 0.38;
                if (brPhotos >= 50 && brPhotos <= 100) {
                    sum = brPhotos * 0.38 - ((brPhotos * 0.38) * 0.03);
                } else if (brPhotos > 100 ) {
                    sum = brPhotos * 0.38 - ((brPhotos * 0.38) * 0.05);
                }
                break;
            case "20X30":
                sum = brPhotos * 2.9;
                if (brPhotos >= 10 && brPhotos <= 50) {
                    sum = brPhotos * 2.9 - ((brPhotos * 2.9) * 0.07);
                } else if (brPhotos > 50 ) {
                    sum = brPhotos * 2.9 - ((brPhotos * 2.9) * 0.09);
                }
                break;
        }
        if (purchaiseType.equals("online")) {
            sum *= 0.98;
        }
        System.out.printf("%.2fBGN",sum);
    }
}
