package cz.spsmb.source;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LicenceServer {

    private static final String LICENSE_SERVER_URL = "https://licence.tulacka.cz/check/123412341234";

    private static boolean checkValidLicense(String url) {
        try {
            HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
            httpConnection.connect();
            return (httpConnection.getResponseCode() == 200);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void startGame() {
        if (!checkValidLicense(LICENSE_SERVER_URL)) {
            System.out.println("Licence is not valid");
        } else {
            System.out.println("Starting game");
        }
    }
}
