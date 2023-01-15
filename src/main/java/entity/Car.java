package entity;

public class Car {
    private int id;
    private String name;
    private int price;
    private String jpg;
    private String desc;
    private Label label;
    private Level level;
    private boolean isBlock;

    private Car() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getJpg() {
        return jpg;
    }

    public String getDesc() {
        return desc;
    }

    public Label getLabel() {
        return label;
    }

    public Level getLevel() {
        return level;
    }

    public boolean isBlock() {
        return isBlock;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", jpg='" + jpg + '\'' +
                ", desc='" + desc + '\'' +
                ", label=" + label +
                ", level=" + level +
                ", isBlock=" + isBlock +
                '}';
    }

    public static Builder newBuilder() {
        return new Car().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(int id) {
            Car.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Car.this.name = name;
            return this;
        }

        public Builder setPrice(int price) {
            Car.this.price = price;
            return this;
        }

        public Builder setJpg(String jpg) {
            Car.this.jpg = jpg;
            return this;
        }

        public Builder setDesc(String desc) {
            Car.this.desc = desc;
            return this;
        }

        public Builder setLabel(Label label) {
            Car.this.label = label;
            return this;
        }

        public Builder setLevel(Level level) {
            Car.this.level = level;
            return this;
        }

        public Builder setBlock(boolean block) {
            Car.this.isBlock = block;
            return this;
        }

        public Car build() {
            return Car.this;
        }
    }
}