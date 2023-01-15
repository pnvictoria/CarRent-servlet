package dto;

public class CarFilterDTO {
    private String name;
    private Integer labelId;
    private Integer levelId;
    private int priceFrom;
    private int priceTo;

    public String getName() {
        return name;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public int getPriceFrom() {
        return priceFrom;
    }

    public int getPriceTo() {
        return priceTo;
    }

    public static CarFilterDTO.Builder newBuilder() {
        return new CarFilterDTO().new Builder();
    }


    public class Builder {
        private Builder() {

        }


        public CarFilterDTO.Builder setName(String name) {
            CarFilterDTO.this.name = name;
            return this;
        }

        public CarFilterDTO.Builder setPriceFrom(int priceFrom) {
            CarFilterDTO.this.priceFrom = priceFrom;
            return this;
        }

        public CarFilterDTO.Builder setPriceTo(int priceTo) {
            CarFilterDTO.this.priceTo = priceTo;
            return this;
        }

        public CarFilterDTO.Builder setLabelId(Integer labelId) {
            CarFilterDTO.this.labelId = labelId;
            return this;
        }

        public CarFilterDTO.Builder setLevelId(Integer levelId) {
            CarFilterDTO.this.levelId = levelId;
            return this;
        }


        public CarFilterDTO build() {
            return CarFilterDTO.this;
        }
    }
}
