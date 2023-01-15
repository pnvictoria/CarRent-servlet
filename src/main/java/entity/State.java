package entity;

public class State {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static State.Builder newBuilder() {
        return new State().new Builder();
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public class Builder {
        private Builder() {

        }

        public State.Builder setId(int id) {
            State.this.id = id;
            return this;
        }

        public State.Builder setName(String name) {
            State.this.name = name;
            return this;
        }

        public State build() {
            return State.this;
        }
    }

}