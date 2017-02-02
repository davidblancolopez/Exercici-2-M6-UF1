package exercici.pkg2.m6.uf1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author ALUMNEDAM
 */
public abstract class gestioXML <T>{
    
    protected File fitxerXML; 
    
    public gestioXML(String rutaDocument){
        this.fitxerXML = new File(rutaDocument);
    }
    
    public Document carregarFitxerXML() throws SAXException, IOException, ParserConfig;
    
    public void desarDoc(Document doc) throws TransformerConfigrationException;
    
    public abstract void afegirObjecte(T object);
    
    public abstract T cercarPerCodi(String codi);
    
    public abstract List<T> retornarObjectes();
    
    public abstract void modificarObjecte(T object);
    
    public abstract void eliminarObjecte(T object);
    
    
    
}
