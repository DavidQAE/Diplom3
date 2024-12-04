package api;
//
public class UserCreation extends BaseUrl{

    public void createUser() {
        UserClient userClient = new UserClient();
        CreateUser createUser = new CreateUser().
                withEmail("TestDave5@mail.ru").withName("Гном150").withPassword("Tester1234323");
        userClient.create(createUser);
    }

}
