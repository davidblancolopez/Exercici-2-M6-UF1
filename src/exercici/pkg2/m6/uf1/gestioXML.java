package exercici.pkg2.m6.uf1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author ALUMNEDAM
 */
public abstract class gestioXML<T> {

    protected File fitxerXML;

    public gestioXML(String rutaDocument) throws ParserConfigurationException, org.xml.sax.SAXException, IOException {
        this.fitxerXML = new File(rutaDocument);

        DocumentBuilderFactory docBuFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(fitxerXML);
    }

    public abstract Document carregarFitxerXML() throws SAXException, IOException, ParserConfigurationException;

    public abstract void desarDoc(Document doc) throws TransformerConfigurationException;

    public abstract void afegirObjecte(T object);

    public abstract T cercarPerCodi(int codi);

    public abstract List<T> retornarObjectes();

    public abstract void modificarObjecte(T object);

    public abstract void eliminarObjecte(T object);

}
