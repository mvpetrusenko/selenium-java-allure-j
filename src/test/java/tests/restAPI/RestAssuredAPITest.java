package tests.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class RestAssuredAPITest {

    static String accessToken = "BQA140xJb5FJBXJcce-Nyi1_HvOJXd9JFuypsyY-eBuTo2F2UffSTXCjVlZGuYGaYaeB-DSwVaGWu2U30y9Dzj6kAgznqgePrQ5cuaZOY2uvQIFALXRaVRXpOXOeokwbPmHB1KsqlkOWRZafphigubHRkg9R1Lo_5bAsIebuO04PwrF0rK0EVUZf6uDJE_QNZxxrtHzaPjoXMi5ySW5Mxh8ifqk7YYay4LibZNeQ9QF9iuTDM8mKBQnOmvd00VNFXS_sQpPpv1eb_slLGCR7r75IgW3v5TR8XYv2JlGbnbkFLcLJPLF2dGqV550gqS15bncOBHOyngYr3g";
    //Get artist
    @Test (groups = {"SmokeTest"})
    public void getArtist() {

        ValidatableResponse response = RestAssured.given().contentType(ContentType.JSON)
                .baseUri("https://api.spotify.com/").basePath("v1")
                .accept(ContentType.JSON).header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/artists/1RyvyyTE3xzB2ZywiAwp0i")
                .then()
                .log()
                .all()
                .assertThat().statusCode(200);

    }


    //Get Artist`s Albums
    @Test (groups = {"SmokeTest"})
    public void getArtistAlbums() {
        ValidatableResponse response = RestAssured.given().contentType(ContentType.JSON)
                .baseUri("https://api.spotify.com/").basePath("v1")
                .accept(ContentType.JSON).header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/artists/1RyvyyTE3xzB2ZywiAwp0i/albums")
                .then()
                .log()
                .all()
                .assertThat().statusCode(200);
    }


    @Test (groups = {"SmokeTest"})
    public void getArtistAlbumsNegative() {
        ValidatableResponse response = RestAssured.given().contentType(ContentType.JSON)
                .baseUri("https://api.spotify.com/").basePath("v1")
                .accept(ContentType.JSON).header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/artists/1111111111111111/albums")
                .then()
                .log()
                .all()
                .assertThat().statusCode(400);
    }


    @Test (groups = {"SmokeTest"})
    public void createPlaylistNegative() {

        String jsonBody = "{" +
                "   \"name\":\"MyNewPlaylist\",\n" +
                "   \"description\":\"This is the new playlist for testing framework\",\n" +
                "   \"public\":\"false\"\n" +
                "}";

        ValidatableResponse response = RestAssured.given().contentType(ContentType.JSON)
                .baseUri("https://api.spotify.com/").basePath("v1")
                .accept(ContentType.JSON).header("Authorization", "Bearer " + accessToken)
                .and()
                .body(jsonBody)
                .when()
                .post("/users/smedjan/playlists")
                .then()
                .log()
                .all()
                .assertThat().statusCode(403)
                .and()
                .statusLine("HTTP/1.1 403 Forbidden")
                .body("error.status", equalTo(403))
                .body("error.message", equalTo("You cannot create a playlist for another user."));
    }

}