package entity;

public class User {
    private int id;
    private String name;
    private String surname;
    private boolean sex;
    private String date;
    private String email;
    private String password;
    private String avatar;
    private Role role;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isSex() {
        return sex;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAvatar() {
        return avatar;
    }

    public Role getRole() {
        return role;
    }

    public static Builder newBuilder() {
        return new User().new Builder();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                ", date='" + date + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", role=" + role +
                '}';
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(int id) {
            User.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            User.this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            User.this.surname = surname;
            return this;
        }

        public Builder setSex(boolean sex) {
            User.this.sex = sex;
            return this;
        }

        public Builder setDate(String date) {
            User.this.date = date;
            return this;
        }

        public Builder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            User.this.password = password;
            return this;
        }

        public Builder setAvatar(String avatar) {
            User.this.avatar = avatar;
            return this;
        }

        public Builder setRole(Role role) {
            User.this.role = role;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}
