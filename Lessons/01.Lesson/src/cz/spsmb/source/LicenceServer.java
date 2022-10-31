package cz.spsmb.source;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LicenceServer {

    private static final String LICENSE_SERVER_URL = "https://licence.tulacka.cz/check/123412341234";
    private static boolean validLicence;

    static {
        checkValidLicense(LICENSE_SERVER_URL);
    }

    private static void checkValidLicense(String url) {
        try {
            HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
            httpConnection.connect();
            validLicence = (httpConnection.getResponseCode() == 200);
        } catch (IOException e) {
            e.printStackTrace();
            validLicence = false;
        }
    }

    public static void startGame() {
        if (!validLicence) {
            System.out.println("Licence is not valid");
        } else {
            System.out.println("Starting game");
        }
    }
}
