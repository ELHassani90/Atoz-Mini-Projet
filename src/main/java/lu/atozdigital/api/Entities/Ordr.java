package lu.atozdigital.api.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Ordr {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String reference;
    @JsonFormat()
    private Date date;
    @OneToMany(targetEntity = Article.class, cascade = ALL)
    @JoinColumn(name = "Art_Frk", referencedColumnName = "id")
    private List<Article> articals;

    public Ordr() {
    }

    public Ordr(String reference, Date date, List<Article> articals) {
        this.reference = reference;
        this.articals = articals;
        this.date = date;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Article> getArticals() {
        return articals;
    }

    public void setArticals(List<Article> articals) {
        this.articals = articals;
    }
}
