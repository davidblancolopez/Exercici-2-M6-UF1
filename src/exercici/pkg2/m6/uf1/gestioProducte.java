/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici.pkg2.m6.uf1;

import java.io.File;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author ALUMNEDAM
 */
public class gestioProducte extends gestioXML<T> {

    @Override
    public void afegirObjecte(T object) {
        try {
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public T cercarPerCodi(int codi) {
        try {
//            Document doc = g.fileXmlPasDOM(new File("fitxer.xml"));
//            Producte producte = null;
//
//            //S'obtenen les entrades amb nom persona
//            NodeList nodes = doc.getElementsByTagName("persona");
//
//            //S'obtenen els valors emmagatzemats en el node de codi
//            for (int i = 0; i < nodes.getLength(); i++) {
//                Node node = nodes.item(i);
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Element e = (Element) node;
//                    if (e.getAttribute("codi").equals(String.valueOf(codi))) {
//                       
//                        producte = new Producte(codi, nom, preu, unitats);
//                        break;
//                    }
//                }
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return producte;
    }

    @Override
    public List<T> retornarObjectes() {

        try {

        } catch (Exception e) {
            System.out.println(e);
        }
        return llista;
    }

    @Override
    public void modificarObjecte(T object) {
        try {

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminarObjecte(T object) {
        try {

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
