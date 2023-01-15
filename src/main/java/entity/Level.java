package entity;

public class Level {
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
        return new Level().new Builder();
    }

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(int id) {
            Level.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Level.this.name = name;
            return this;
        }

        public Level build() {
            return Level.this;
        }
    }
}
