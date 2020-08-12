package pl.avntrka.model;

import java.io.File;
import java.util.Objects;

public class FilePicture {
    private  long id;
    private long productId;
    private long userId;
    private String fileName;
    private String FieldName;
    private File file;



    public FilePicture() {
    }

    public FilePicture(long id, long productId, long userId, String fileName, String fieldName, File file) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.fileName = fileName;
        FieldName = fieldName;
        this.file = file;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFieldName() {
        return FieldName;
    }

    public void setFieldName(String fieldName) {
        FieldName = fieldName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilePicture that = (FilePicture) o;
        return id == that.id &&
                productId == that.productId &&
                userId == that.userId &&
                Objects.equals(fileName, that.fileName) &&
                Objects.equals(FieldName, that.FieldName) &&
                Objects.equals(file, that.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, userId, fileName, FieldName, file);
    }

    @Override
    public String toString() {
        return "FilePicture{" +
                "id=" + id +
                ", productId=" + productId +
                ", userId=" + userId +
                ", fileName='" + fileName + '\'' +
                ", FieldName='" + FieldName + '\'' +
                ", file=" + file +
                '}';
    }
}
