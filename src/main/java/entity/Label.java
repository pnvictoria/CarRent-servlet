package entity;

public class Label {
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

    public static Builder newBuilder() {
        return new Label().new Builder();
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(int id) {
            Label.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Label.this.name = name;
            return this;
        }

        public Label build() {
            return Label.this;
        }
    }
}
