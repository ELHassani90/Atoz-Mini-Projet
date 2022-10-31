package lu.atozdigital.api.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="Articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private double price;
    @Lob
    private byte[] img;

    public byte[] getImg() {
        return img;
    }

    @JsonProperty(value="img")
    public void setImg(byte[] img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Article() {
    }

    public Article(String name, double price, byte[] img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }


    public String getName() {
        return name;
    }

    @JsonProperty(value="name")
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    @JsonProperty(value="price")
    public void setPrice(double price) {
        this.price = price;
    }
}
