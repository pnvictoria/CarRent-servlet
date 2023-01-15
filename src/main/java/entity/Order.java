package entity;

public class Order {
    private int id;
    private User user;
    private Car car;
    private String phone;
    private State state;

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }

    public String getPhone() {
        return phone;
    }

    public static Order.Builder newBuilder() {
        return new Order().new Builder();
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", car=" + car +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                '}';
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(int id) {
            Order.this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            Order.this.user = user;
            return this;
        }

        public Builder setCar(Car car) {
            Order.this.car = car;
            return this;
        }

        public Builder setPhone(String phone) {
            Order.this.phone = phone;
            return this;
        }

        public Builder setState(State state) {
            Order.this.state = state;
            return this;
        }

        public Order build() {
            return Order.this;
        }
    }
}
