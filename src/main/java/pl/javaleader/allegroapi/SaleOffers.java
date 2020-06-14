package pl.javaleader.allegroapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import pl.javaleader.AllegroEnum;

import java.io.File;
import java.io.IOException;

public class SaleOffers {
    public static void main(String[] args) throws IOException {
        //utworzenie mappera Jackson json
        ObjectMapper objectMapper = new ObjectMapper();
        //utworzenie obiektu tokena
        Token token = objectMapper.readValue(new File("token.txt"), Token.class);

        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "bearer " + token.getAccess_token());
        headers.add("Accept", AllegroEnum.ACCEPT.acceptHeader);
        headers.add("Content-Type", AllegroEnum.ACCEPT.acceptHeader);
        headers.add("Accept-Language", "pl-PL");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://api.allegro.pl.allegrosandbox.pl/sale/offers/6278976754", HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        //utworzenie automatycznej klasy JsonNode do przechowywania zmiennych z Jsona
        JsonNode jsonNode = objectMapper.readValue(response, JsonNode.class);
        //utworzenie zmiennej, która ma zagnieżdżone dane
        JsonNode child = jsonNode.get("stock");
        //zagnieżdżone dane, wartość pola przed zmianą
        System.out.println("available = " + child.get("available").asInt());
        //zmiana wartości pola o nazwie available
        ((ObjectNode) child).put("available", 66);
        System.out.println("available after change = " + child.get("available").asInt());





        body = jsonNode.toString();
        System.out.println(body);

        headers.clear();
        headers.add("Authorization", "bearer " + token.getAccess_token());
        headers.add("Accept", AllegroEnum.ACCEPT.acceptHeader);
        headers.add("Content-Type", AllegroEnum.ACCEPT.acceptHeader);
        headers.add("Accept-Language", "pl-PL");
        System.out.println(headers.toString());
        requestEntity = new HttpEntity<String>(body, headers);
        responseEntity = rest.exchange("https://api.allegro.pl.allegrosandbox.pl/sale/offers/6278976754", HttpMethod.PUT, requestEntity, String.class);
        httpStatus = responseEntity.getStatusCode();
        status = httpStatus.value();
        response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

    }
}
