package api;
//
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    public Response create(CreateUser createUser) {
        return given()
                .header("Content-type", "application/json")
                .body(createUser)
                .post("/api/auth/register");
    }

public Response delete(String accessToken) {
    return given()
            .header("Content-type", "application/json")
            .auth().oauth2(accessToken)
            .delete("/api/auth/user");
}


public Response login(LoginUser loginUser) {
    return given()
            .header("Content-type", "application/json")
            .body(loginUser)
            .post("/api/auth/login");
}


}
