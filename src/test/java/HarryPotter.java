import org.junit.Test;
import HarryPotter.Spell;
import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

import io.restassured.http.ContentType;

public class HarryPotter {
    private String API_URL = "https://www.potterapi.com/v1/";
    private String API_KEY = "$2a$10$V5Z32qQXhC20XRqB5CEiRugwGfsR8x9285xaxLj8Eb4NOxl4dKPy.";


    @Test
    public void getSpellById() {
//     Aberto Spell
        Spell testSpellObject = new Spell("5b74ebd5fb6fc0739646754c","Aberto","Charm","opens objects");
        String endPointURL = String.format("%s%s/%s", this.API_URL, "spells",testSpellObject.get_id());
        Spell [] responseSpellArray = given()
                .contentType(ContentType.JSON)
                .param("key", this.API_KEY)
                .when()
                .get(endPointURL)
                .then()
                .statusCode(200)
                .extract().as(Spell[].class);
        assertTrue(testSpellObject.equals(responseSpellArray[0]));
    }
}
