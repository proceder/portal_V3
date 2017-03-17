/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author kadam
 */
@Entity
@Indexed
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Field
    @Column 
    private String firstName;
    @Field
    @Column
    private String lastName;
    @Field
    @Column
    private int number;
    @Field
    @Column
    private String country;
    @Field
    @Column
    private Leg preferedLeg;

    private boolean UEcitizen;
    @Field
    @Column
    private Position preferedPosition;

    @Transient
    private boolean editable;

    public Player() {

    }

    public enum Leg {
        LEFT, RIGHT, BOTH;
    }

    public enum Position {
        GK, RB, LB, CB, CM, LW, RW, CF;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Leg getPreferedLeg() {
        return preferedLeg;
    }

    public void setPreferedLeg(Leg preferedLeg) {
        this.preferedLeg = preferedLeg;
    }

    public boolean isUEcitizen() {
        return UEcitizen;
    }

    public void setUEcitizen(boolean UEcitizen) {
        this.UEcitizen = UEcitizen;
    }

    public Position getPreferedPosition() {
        return preferedPosition;
    }

    public void setPreferedPosition(Position preferedPosition) {
        this.preferedPosition = preferedPosition;
    }

}
