package api;
//
import io.restassured.response.Response;

public class Delete extends BaseUrl{
    String accessToken;
    UserClient userClient = new UserClient();

    public void deleteUser(String email, String password) {
        LoginUser loginUser = new LoginUser()
                .withEmail(email).withPassword(password);
        Response loginResponse = userClient.login(loginUser);
        accessToken = loginResponse.as(UserBody.class).getAccessToken().substring(7);
        userClient.delete(accessToken);
    }

}
