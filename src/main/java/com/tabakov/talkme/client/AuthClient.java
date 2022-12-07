package com.tabakov.talkme.client;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tabakov.talkme.auth.AuthDTO;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Scanner;

public class AuthClient {

    public static Optional<AuthDTO> getAuth() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {

            URL url = new URL("https://api.admitad.com/token/");
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("POST");

            httpConn.setRequestProperty("Authorization", "Basic TXQ0NEJCQ01Ld1lENUJFUExpWTlGRmRhdWwyMXhuOkFESFlJaUJvb2RvUUhIWDVsZVZudTAzbklDa0RDUg==");
            httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            httpConn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
            writer.write("grant_type=client_credentials&client_id=Mt44BBCMKwYD5BEPLiY9FFdaul21xn&scope=advcampaigns websites public_data advcampaigns_for_website");
            writer.flush();
            writer.close();
            httpConn.getOutputStream().close();

            AuthDTO authDTO = null;

            if (httpConn.getResponseCode() / 100 == 2) {

                String text = null;
                try (Scanner scanner = new Scanner(httpConn.getInputStream(), StandardCharsets.UTF_8.name())) {

                    StringBuilder sb = new StringBuilder();
                    while (scanner.hasNext()) {
                        sb.append(scanner.next());
                    }

                    text = sb.toString();
                    System.out.println(text);
                    JsonFactory factory = mapper.getFactory();
                    JsonParser parser = factory.createParser(text);
                    var node = mapper.readTree(parser);


                    authDTO = new AuthDTO();
                    authDTO.setAccessToken(node.get("access_token").toString());
                    authDTO.setRefreshToken(node.get("refresh_token").toString());
                    authDTO.setExpires(Long.parseLong(node.get("expires_in").toString()));
                }
            } else {
                httpConn.getErrorStream().transferTo(System.out);
            }

            return Optional.ofNullable(authDTO);
        } catch (Exception e) {
            System.out.println("exception while requesting auth token!");
            e.printStackTrace();
            return Optional.empty();
        }

    }

    public static Optional<AuthDTO> refresh() {
        return Optional.empty();
    }
}
