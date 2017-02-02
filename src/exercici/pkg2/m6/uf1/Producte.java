/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici.pkg2.m6.uf1;

/**
 *
 * @author ALUMNEDAM
 */
public class Producte {

    int unitats;
    String codi, nom;
    double preu;

    public Producte(String codi, int unitats, String nom, double preu) {
        this.codi = codi;
        this.unitats = unitats;
        this.nom = nom;
        this.preu = preu;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public int getUnitats() {
        return unitats;
    }

    public void setUnitats(int unitats) {
        this.unitats = unitats;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }
    
    
    
    
   
}
