package pl.javaleader.allegroapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import pl.javaleader.AllegroEnum;

import java.io.File;
import java.io.IOException;

public class ApiAllegroMe {
    public static void main(String[] args) throws IOException {
        //utworzenie mappera json
        ObjectMapper objectMapper = new ObjectMapper();
        //utworzenie obiektu tokena
        Token token = objectMapper.readValue(new File("token.txt"), Token.class);

        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "bearer " + token.getAccess_token());
        headers.add("Accept", AllegroEnum.ACCEPT.acceptHeader);
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://api.allegro.pl.allegrosandbox.pl/me", HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

    }
}
