package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import objects.Species;
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

    public static String requestSpeciesList(String q){
        JSONParser jsonParser = new JSONParser();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + PATH + "?key=" + ConfigReader.getProperty("api.key") + "&q=" + q.replaceAll(" ","%20")))
                .build();
        HttpResponse<String> httpResponse = null;
        JSONObject jsonObject = null;
        try (HttpClient httpClient = HttpClient.newBuilder().build()) {
            httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
            jsonObject = (JSONObject) jsonParser.parse(httpResponse.body());
        } catch (IOException | InterruptedException | ParseException e) {
            e.printStackTrace();
        }
        try {
            return jsonObject.get("data").toString();
        } catch (NullPointerException e) {
            // Return empty string if API does not return plant data
            return " ";
        }
    }

    // Deserialize json response of list of species to list of Species objects
    public static List<Species> getAllSpecies(String q){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String speciesListJson = requestSpeciesList(q);
            return objectMapper.readValue(requestSpeciesList(q), new TypeReference<List<Species>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
