package TesteApi;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class BuscarFilmeInexistente {
    private String ID_DO_FILME = "tt01";
    private String API_KEY= "52ec71bf";


    @Test
    public void buscarFilmeInexistente(){
        RestAssured.baseURI = "http://www.omdbapi.com/";

        RestAssured
                .given()
                .pathParam("ID_DO_FILME", ID_DO_FILME)
                .pathParam("API_KEY", API_KEY)
                .when()
                .get("?i={ID_DO_FILME}&apikey={API_KEY}")
                .then()
                .assertThat()
                .statusCode(200)
                .body("Response", Matchers.equalTo("False"))
                .body("Error", Matchers.equalTo("Incorrect IMDb ID."));
    }
}
