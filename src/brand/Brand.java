package brand;



public class Brand {

    String ID;
    String brandName;
    String soundBrand;
    Double price;

    public Brand() {
    }

    public Brand(String ID, String brandName, String soundBrand, Double price) {
        this.ID = ID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public void setSoundBrand(String soundBrand) {
        this.soundBrand = soundBrand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ID + ", " + brandName + ", " + soundBrand + ": " + price;
    }
}
