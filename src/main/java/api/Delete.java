package api;
//
import io.restassured.response.Response;

public class Delete extends BaseUrl{
    String accessToken;
    UserClient userClient = new UserClient();

    public void deleteUser() {
        LoginUser loginUser = new LoginUser()
                .withEmail("TestDave5@mail.ru").withPassword("Tester1234323");
        Response loginResponse = userClient.login(loginUser);
        accessToken = loginResponse.as(UserBody.class).getAccessToken().substring(7);
        userClient.delete(accessToken);
    }

}
