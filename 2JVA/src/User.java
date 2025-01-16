public class User {
    private int id;
    private String email;
    private String pseudo;
    private String password;
    private Boolean isUser;
    private String store_id;

    public User() {}

    public User(String email, String pseudo, String password, boolean isUser, String store_id) {
        this.email = email;
        this.pseudo = pseudo;
        this.password = password;
        this.isUser = isUser;
        this.store_id = store_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsUser() {
        return isUser;
    }

    public void setIsUser(Boolean isUser) {
        this.isUser = isUser;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", password='" + password + '\'' +
                ", isUser=" + isUser +
                ", store_id='" + store_id + '\'' +
                '}';
    }
}
