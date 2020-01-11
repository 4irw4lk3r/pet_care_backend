package org.airw4lk3r.petcare.model.pet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Contact")
@Table(name = "Contact")
public class Contact {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "contact_sequence")
    @SequenceGenerator(name="contact_sequence", sequenceName="seq_contact")    
    @Column(name = "contact_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_contact", nullable = false)
    private ContactType typeOfContact;

    @Column(name = "value_contact", nullable = false)
    private String valueOfContact;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    };

    public ContactType getTypeOfContact() {
        return this.typeOfContact;
    }

    public void setTypeOfContact(ContactType typeOfContact) {
        this.typeOfContact = typeOfContact;
    }


    public String getValueOfContact() {
        return this.valueOfContact;
    }

    public void setValueOfContact(String valueOfContact) {
        this.valueOfContact = valueOfContact;
    }

}
