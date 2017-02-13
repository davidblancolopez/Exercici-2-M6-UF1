package exercici.pkg2.m6.uf1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author ALUMNEDAM
 */
public abstract class gestioXML<T> {

    protected File fitxerXML;

    public gestioXML(String rutaDocument) throws ParserConfigurationException, org.xml.sax.SAXException, IOException {
        this.fitxerXML = new File(rutaDocument);

    }

  
    public abstract Document ActualitzarDOM();
    
    public abstract void GuardarEstatDom(Document dom);
    
    public abstract void AfegirElementDom (T t, Document dom);
    
    public abstract T obtindreElementPerCodi(Document doc, int codigo);
    
    public abstract ArrayList<T> obtindreLlistaElements(Document doc);
    
    public abstract boolean modificarElementDom (Document doc, int codigo, String nombre, double precio, int cantidad);
    
    public abstract boolean eliminarElementDom (Document doc, int codigo);

}
