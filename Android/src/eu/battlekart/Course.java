package eu.battlekart;

/**
 * Created by lefevrew on 23/03/16.
 */
public class Course {

    private String nom;

    public Course(){
        nom = "test";
    }

    public Course(String nom) {
        this.nom = nom;
    }

    public String getNom(){
        return nom;
    }


}
