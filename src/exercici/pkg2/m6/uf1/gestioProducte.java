/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici.pkg2.m6.uf1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author ALUMNEDAM
 */
public class gestioProducte extends gestioXML<Producte> {

    public gestioProducte(String rutaDocument) throws ParserConfigurationException, SAXException, IOException {
        super(rutaDocument);
        fitxerXML = new File(rutaDocument);
        System.out.println(fitxerXML.getName());
    }

    @Override
    public Document ActualitzarDOM() {
        try {
            //Obtenemos el dom del fichero xml.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fitxerXML);
            doc.normalizeDocument();
            return doc;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(gestioProducte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(gestioProducte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(gestioProducte.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public void GuardarEstatDom(Document dom) {
        try {

            Transformer trans = TransformerFactory.newInstance().newTransformer();
            StreamResult result = new StreamResult(fitxerXML);
            DOMSource source = new DOMSource(dom);
            trans.transform(source, result);

        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(gestioProducte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(gestioProducte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void AfegirElementDom(Producte t, Document dom) {
        //Creas un tag producto
        Element productoE = dom.createElement("Producto");

        //Creas los tags que iran dentro de producto y el texto que ira en su interior
        //codigo
        Element codigoE = dom.createElement("codigo");
        Text codigoT = dom.createTextNode(t.getCodi() + "");

        //nombre
        Element nombreE = dom.createElement("nombre");
        Text nombreT = dom.createTextNode(t.getNom());

        //precio
        Element precioE = dom.createElement("precio");
        Text precioT = dom.createTextNode(t.getPreu() + "");

        //cantidad
        Element cantidadE = dom.createElement("cantidad");
        Text cantidadT = dom.createTextNode(t.getUnitats() + "");

        //S'afegeix cada node al node pare que li correspongui
        dom.getDocumentElement().appendChild(productoE);
        productoE.appendChild(codigoE);
        codigoE.appendChild(codigoT);

        productoE.appendChild(nombreE);
        nombreE.appendChild(nombreT);

        productoE.appendChild(precioE);
        precioE.appendChild(precioT);

        productoE.appendChild(cantidadE);
        cantidadE.appendChild(cantidadT);

    }

    @Override
    public Producte obtindreElementPerCodi(Document doc, int codigo) {
        NodeList listaElementos = doc.getElementsByTagName("Producto");

        for (int i = 0; i < listaElementos.getLength(); i++) {
            NodeList nodosHijo = listaElementos.item(i).getChildNodes();

            int codi = Integer.parseInt(nodosHijo.item(0).getTextContent());

            if (codi == codigo) {

                String nombre = nodosHijo.item(1).getTextContent();
                double precio = Double.parseDouble(nodosHijo.item(2).getTextContent());
                int cantidad = Integer.parseInt(nodosHijo.item(3).getTextContent());
                return new Producte(codi, nombre, precio, cantidad);

            }
        }
        return null;
    }

    @Override
    public ArrayList<Producte> obtindreLlistaElements(Document doc) {
        ArrayList<Producte> listaProductos = new ArrayList<>();
        NodeList listaElementos = doc.getElementsByTagName("Producto");

        for (int i = 0; i < listaElementos.getLength(); i++) {
            NodeList nodosHijo = listaElementos.item(i).getChildNodes();

            int codigo = Integer.parseInt(nodosHijo.item(0).getTextContent());
            String nombre = nodosHijo.item(1).getTextContent();
            double precio = Double.parseDouble(nodosHijo.item(2).getTextContent());
            int cantidad = Integer.parseInt(nodosHijo.item(3).getTextContent());

            listaProductos.add(new Producte(codigo, nombre, precio, cantidad));
        }

        return listaProductos;
    }

    @Override
    public boolean modificarElementDom(Document doc, int codigo, String nombre, double precio, int cantidad) {
        NodeList listaElementos = doc.getElementsByTagName("Producto");

        for (int i = 0; i < listaElementos.getLength(); i++) {
            NodeList nodosHijo = listaElementos.item(i).getChildNodes();
            System.out.println(nodosHijo.item(0).getTextContent());
            int codi = Integer.parseInt(nodosHijo.item(0).getTextContent());
            if (codi == codigo) {

                Element element = (Element) nodosHijo;
                element.getChildNodes().item(1).setTextContent(nombre);
                element.getChildNodes().item(2).setTextContent(precio + "");
                element.getChildNodes().item(3).setTextContent(cantidad + "");

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarElementDom(Document doc, int codigo) {
        NodeList listaElementos = doc.getElementsByTagName("Producto");

        for (int i = 0; i < listaElementos.getLength(); i++) {

            if (Integer.parseInt(listaElementos.item(i).getChildNodes().item(0).getTextContent())
                    == codigo) {

                Element elementoABorrar = (Element) listaElementos.item(i);
                elementoABorrar.getParentNode().removeChild(elementoABorrar);
                return true;
            }
        }
        return false;
    }

}
