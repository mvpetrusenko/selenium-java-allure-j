package tests.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class RestAssuredAPITest {

    static String accessToken = "BQDU8fAGz9jKKWdDZgI4sgwpmFEC16cWpGU44MXkl27KxJVEBiKhumvQGZFtgGvoSTTuethZJLi4WP6WFVwlZu9BDfekw-XmwTdJA8yYP3spm-1gIiQxSKlg8Ji3XiNHqClbJOFEseOdkNDy9xijmn4ImuU1VNZhqalZJEKe2xKodcflIwQodtxnXGwO90u4S9MmodGhpqTyTSHEGIgnPHfqZtQln0SXSxN3O6nbepNxqi-RtdpJcVT-_MJYbt4anfs_NENku5Q7810KD7qGWJVlXobGovicsSN_pqaOVfagTBn4hMDM6rGP435eRQDu34qlDsPgJCuMeg";
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