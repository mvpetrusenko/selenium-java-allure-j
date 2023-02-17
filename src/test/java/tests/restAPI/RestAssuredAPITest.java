package tests.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class RestAssuredAPITest {

    static String accessToken = "BQALxOboQXyt7s7HSYOcTRKnOb0ascS3xS-Ywn0fsyQx6d_idrtKJhBOhXu7SXZ3OZfWxGxtmzZ3R740nZIR-7kVLkzeJrbbzLZSfQ050OXBafP1wnLIOg-RlQfN3BXDCR2bawEQplE9Cp5S_ZREINfbzoYlTIUp4qMQAoXld0e79dNnsiOH_CTsqjnTWvOODMTKaOMYaaAGjI1H3HYOCzuvc0zFi8pF5LnOfMixGusTrIgqHlr5L7rDtaXMFqXWA9JIY9pZgVKO2ejdseNeSTEZbV_t7x4_NppS8Nog7xltnbodFSx65bOLZCljAYPDXt2kQPo4IUEH9g";


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
        //.body(Matchers.equalTo("{\"code\":403,\"meta\":null,\"data\":{\"status\":\"403\","
        //+ "\"message\":\"You cannot create a playlist for another user.\"}"));
    }

}