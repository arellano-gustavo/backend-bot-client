package mx.gob.impi.chatbot.persistence.api.model.domain;

import java.util.List;

public class UserPagination {
    private int total;
    private List<User> userList;
    public UserPagination() {
    }
    public UserPagination(int total, List<User> userList) {
        this.total = total;
        this.userList = userList;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public List<User> getUserList() {
        return userList;
    }
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
