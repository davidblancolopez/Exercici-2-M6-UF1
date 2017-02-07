/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici.pkg2.m6.uf1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ALUMNEDAM
 */
public class gestioProducte extends gestioXML<Producte> {

    private File arxiu;

    public gestioProducte(File arxiu, String rutaDocument) throws ParserConfigurationException, SAXException, IOException {
        super(rutaDocument);
        this.arxiu = new File(rutaDocument);
    }

    @Override
    public Producte cercarPerCodi(int codi) {
        try {
            Producte producte = null;

            Document doc = super.cargar();
            NodeList nl = doc.getElementsByTagName("codi");

            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    if (e.getAttribute("codi").equals(String.valueOf(codi))) {
                        String nom = GestioDocuments.getValue("nom", e);
                        double preu = GestioDocuments.getValue("nom", e);
                        int unitats = GestioDocuments.getValue("cognom", e);
                        producte = new Producte(codi, nom, preu, unitats);
                        break;
                    }
                }

            }
            return producte;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(gestioProducte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(gestioProducte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(gestioProducte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void afegirObjecte(Producte object) {
        boolean check = true;
        try {
            Document doc = super.cargar();
        } catch (Exception e) {

        }
    }

    @Override
    public List<Producte> retornarObjectes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarObjecte(Producte object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarObjecte(Producte object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
