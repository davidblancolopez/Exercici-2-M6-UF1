/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici.pkg2.m6.uf1;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
public class gestioProducte extends gestioXML<T> {
    private File arxiu;

    public gestioProducte(File arxiu, String rutaDocument) throws ParserConfigurationException, SAXException, IOException {
        super(rutaDocument);
        this.arxiu = new File(rutaDocument);
    }
    
    
    

    @Override
    public void afegirObjecte(T object) {
        try {

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Producte cercarPerCodi(int codi) {
        try {
            Document doc = cargar();
            NodeList nl = doc.getElementsByTagName("codi");

            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    if (e.getAttribute("codi").equals(String.valueOf(codi))) {
                        String nom = GestioDocuments.getValue("nom", e);
                        String cognom = GestioDocuments.getValue("cognom", e);
                        per = new Persona(codi, nom, cognom);
                        break;
                    }
                }

            }catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(GestioProducte.class.getName()).log(Level.SEVERE, null, ex);
        }

        return producte;
    }

    

}
