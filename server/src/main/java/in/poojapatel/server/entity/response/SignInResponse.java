package in.poojapatel.server.entity.response;

import in.poojapatel.server.entity.User;

public class SignInResponse {

    User users;
    Response response;

    public User getUsers() {
        return users;
    }
    public void setUsers(User users) {
        this.users = users;
    }
    public Response getResponse() {
        return response;
    }
    public void setResponse(Response response) {
        this.response = response;
    }
}
