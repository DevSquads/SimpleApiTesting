import io.restassured.path.json.JsonPath;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

import io.restassured.http.ContentType;

public class Countries {

    private String API_URL = "https://restcountries-v1.p.rapidapi.com/";
    private String API_HOST = "restcountries-v1.p.rapidapi.com";
    private String API_KEY = "21e6f4f25dmsh8bbed3c079a43acp14bd7bjsnb34a3bcca5f8";

    @Test
    public void getByName() {
        String countryName = "norge";
        String endPointURL = String.format("%s%s",this.API_URL,"name");
        Response response = given()
                .contentType(ContentType.JSON)
                .header("X-RapidAPI-Host", this.API_HOST)
                .header("X-RapidAPI-Key", this.API_KEY)
                .when()
                .get(String.format("%s/%s",endPointURL,countryName))
                .then()
                .statusCode(200)
                .extract().response();
        JsonPath response_json = response.body().jsonPath();
        assertEquals(getValueOf(response_json, "name"), "Norway");
        assertEquals(getValueOf(response_json, "region"), "Europe");
    }

    private String getValueOf(JsonPath response_json, String key) {
        //      note jsonPath returns an array , that's why we used name[0] => check https://goessner.net/articles/JsonPath/
        return response_json.getString(String.format("%s[0]", key));
    }
}
