package exercici.pkg2.m6.uf1;


import java.io.File;
import java.io.IOException;
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
    
    
        public Document desarDocument(Document doc) throws TransformerException {
        Transformer trns = TransformerFactory.newInstance().newTransformer();
        StreamResult result = new StreamResult(fitxerXML);
        DOMSource source = new DOMSource(doc);
         
        trns.transform(source, result);
        
        return doc;
    }

        
    public Document cargar() throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory docBuFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(fitxerXML);
        return doc;
    }

    public abstract void afegirObjecte(T object);

    public abstract T cercarPerCodi(int codi);

    public abstract List<T> retornarObjectes();

    public abstract void modificarObjecte(T object);

    public abstract void eliminarObjecte(T object);

}
