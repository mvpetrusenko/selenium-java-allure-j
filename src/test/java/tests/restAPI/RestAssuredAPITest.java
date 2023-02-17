package tests.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class RestAssuredAPITest {

    static String accessToken = "BQDTSw1GBUvDyKN2vD8SAKcI3AdFFr6V5CcDn2-ZfY78d46dINCY8n6HW3oQ1NenkLCp5bbJLQMhCoVqG38xWhKLS9lDevM20shKQBcELFFH6g_h6-86XkXZYTSI1hnrdp4zu_cUZj_vF9bwV1AimmKDhvaU4KKMFC4Z_V_MYixFcLigYDYQiB_Gf6Z6260p0PPztZr9AvBzaZ8cihizbCJWzReZAKMXdcxy26Q9xWunKI7TRs18qiVf713iITqlaFeacF_Q4XFDIoknKcF7qajjCkz5ssAcOuk1DQflgQU6SAHkVEYWuONX1Mjq5izYARVQti4l8VClrw";


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