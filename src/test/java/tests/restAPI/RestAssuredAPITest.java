package tests.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class RestAssuredAPITest {

    static String accessToken = "BQCUdHXXpd8eKwPRJijWNPJUOtFtCuG7pGWI4G7S6gM9_ngJh-Ix3KFwiIwcLzx2S7qKwN5bwH2zf1gs8rWr2iQOvjTbBLfaRRDo3pSfa9sW2kSVuLUsvalkee9ODx6vrN8rKTLF-p0lklMwbJZuT57ZDsv_wKYZXigN8l7voA-iY2zg9AcsS6Q8yf7WXoGkHP1d6MUxy7JCpuMeAiyWqzgXJ9WTzqz6cjtI2WH9iLVge1JJLv2JQlgrTFEhRZ1re3dh0OmLZpGGmgtToDh9J24HMwfybf60GS2RXMm1jg1CFhUf-7DYcmaGQhaccWGEpXV7iRASwFQdMg";
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