package api;
//
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient extends Keys{

    public Response create(CreateUser createUser) {
        return given()
                .header("Content-type", "application/json")
                .body(createUser)
                .post(registerKey);
    }

public Response delete(String accessToken) {
    return given()
            .header("Content-type", "application/json")
            .auth().oauth2(accessToken)
            .delete(userKey);
}


public Response login(LoginUser loginUser) {
    return given()
            .header("Content-type", "application/json")
            .body(loginUser)
            .post(loginKey);
}


}
