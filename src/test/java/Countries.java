import io.restassured.path.json.JsonPath;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

import io.restassured.http.ContentType;

public class Countries {


    @Test
    public void getByName() {
        assertEquals(10, 10);
        Response response = given()
                .contentType(ContentType.JSON)
                .header("X-RapidAPI-Host", "restcountries-v1.p.rapidapi.com")
                .header("X-RapidAPI-Key", "21e6f4f25dmsh8bbed3c079a43acp14bd7bjsnb34a3bcca5f8")
                .when()
                .get("https://restcountries-v1.p.rapidapi.com/name/norge")
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
