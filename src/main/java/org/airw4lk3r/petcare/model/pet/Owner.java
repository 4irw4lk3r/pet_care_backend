package org.airw4lk3r.petcare.model.pet;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Owner")
@Table(name = "Owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_sequence")
    @SequenceGenerator(name = "owner_sequence", sequenceName = "seq_owner")
    @Column(name = "owner_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "age")
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    private List<Contact> contacts;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    private List<Pet> pets;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /*
     * public List<Contact> getContacts() { return this.contacts; }
     * 
     * public void setContacts(List<Contact> contacts) { this.contacts = contacts;
     * }//
     */

    /*
     * public List<Pet> getPets() { return this.pets; }
     * 
     * public void setPets(List<Pet> pets) { this.pets = pets; }//
     */

}
