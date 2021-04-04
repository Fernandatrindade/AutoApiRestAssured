package TesteApi;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class BuscaFilmeApi {
    private String ID_DO_FILME = "tt1285016";
    private String API_KEY= "52ec71bf";


    @Test
    public void buscarFilmeExistente(){
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
                .body("Title", Matchers.equalTo("The Social Network"))
                .body("Year", Matchers.equalTo("2010"))
                .body("Language",Matchers.equalTo("English, French"));
    }

}
