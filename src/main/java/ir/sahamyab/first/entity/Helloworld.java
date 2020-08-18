package ir.sahamyab.first.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Helloworld {

    @Id
    @GeneratedValue
    private Long id;

    public Helloworld() {
    }

    public Helloworld(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}