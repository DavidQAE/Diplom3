package api;
//
public class UserCreation extends BaseUrl{

    public void createUser(String email, String name, String password) {
        UserClient userClient = new UserClient();
        CreateUser createUser = new CreateUser().
                withEmail(email).withName(name).withPassword(password);
        userClient.create(createUser);
    }

}
