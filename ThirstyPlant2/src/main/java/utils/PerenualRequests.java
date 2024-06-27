package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import objects.SpeciesData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class PerenualRequests {
    private static final String BASE_URI = "https://perenual.com/api/";
    private static final String PATH = "species-list";
    private static final String API_KEY = "sk-F2M0667d5c0353ecc6051";

    public String requestSpeciesList(String q){
        HttpClient httpClient = HttpClient.newBuilder().build();
        JSONParser jsonParser = new JSONParser();

        HttpRequest httpRequest = null;
        httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + PATH + "?key=" + API_KEY + "&page=3&q=" + q))
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
            JSONObject jsonObject = (JSONObject) jsonParser.parse(httpResponse.body());
            return jsonObject.get("data").toString();
        } catch (IOException | InterruptedException | ParseException e) {
            throw new RuntimeException(e);
        } finally {
            httpClient.close();
        }
    }

    public List<SpeciesData> getAllSpecies(String q){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(requestSpeciesList(q), new TypeReference<List<SpeciesData>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
