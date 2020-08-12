package pl.avntrka.model;

import java.io.File;
import java.sql.Timestamp;
import java.util.Objects;

public class Product {
    private long id;
    private String name;
    private String description;
    private Timestamp timestamp;
    private String category;
    private User user;
    private String pris;
    private String brand;
    private String condition;
   private File file;
   private String pictureName;
   private String pictureField;

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureField() {
        return pictureField;
    }

    public void setPictureField(String pictureField) {
        this.pictureField = pictureField;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                ", category='" + category + '\'' +
                ", user=" + user +
                ", pris=" + pris +
                ", brand='" + brand + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(timestamp, product.timestamp) &&
                Objects.equals(category, product.category) &&
                Objects.equals(user, product.user) &&
                Objects.equals(pris, product.pris) &&
                Objects.equals(brand, product.brand) &&
                Objects.equals(condition, product.condition) &&
                Objects.equals(file, product.file) &&
                Objects.equals(pictureName, product.pictureName) &&
                Objects.equals(pictureField, product.pictureField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, timestamp, category, user, pris, brand, condition);
    }

    public String getPris() {
        return pris;
    }

    public void setPris(String pris) {
        this.pris = pris;
    }

    public String getBrand() {
        return brand;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Product(Product product) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timestamp =  timestamp;
        this.user=new User(product.user);
        this.category = category;
        this.brand= brand;
        this.condition = condition;
        this.pris= pris;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product() {
    }




    public Product(long id, String name, String description, Timestamp timestamp, String category, User user, String brand, String condition) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timestamp = timestamp;
        this.category = category;
        this.condition=condition;
        this.brand=brand;
    }

    public Product(long id, String name, String description, Timestamp timestamp, String category, User user, String pris, String brand, String condition, File file, String pictureName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timestamp = timestamp;
        this.category = category;
        this.user = user;
        this.pris = pris;
        this.brand = brand;
        this.condition = condition;
        this.file = file;
        this.pictureName = pictureName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
