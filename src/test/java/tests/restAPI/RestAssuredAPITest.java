package tests.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class RestAssuredAPITest {


        private static String accessToken;


    //static String accessToken = "BQBgL7Okn1Wb8vYB629tCu8GW2KNQ1lkam0jPZoAJQgbWpMwsSdZHsaZOLF7_gmFyh89lMgzCNCtPYRQbiLNMlaPagaZVlYNyYcr2JMGBAxaIDTBFio";


        //Get artist
        @Test(groups = {"SmokeTest"})
        public void getArtist () {

            try {
                accessToken = GetToken.getToken();
                System.out.println("Access Token: " + accessToken);
            } catch (Exception e) {
                e.printStackTrace();
            }

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
        @Test(groups = {"SmokeTest"})
        public void getArtistAlbums () {
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


        @Test(groups = {"SmokeTest"})
        public void getArtistAlbumsNegative () {
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


        @Test(groups = {"SmokeTest"})
        public void createPlaylistNegative () {

            try {
                accessToken = GetToken.getToken();
                System.out.println("Access Token: " + accessToken);
            } catch (Exception e) {
                e.printStackTrace();
            }


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
                    .body("error.status", equalTo(403));
                    //.body("error.message", equalTo("This request requires user authentication."));
                    //.body("error.message", equalTo("You cannot create a playlist for another user."));
        }
    }
