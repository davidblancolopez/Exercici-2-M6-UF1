//import org.w3c.dom.Document;
//import org.w3c.dom.Element;


package exercici.pkg2.m6.uf1;

import java.io.File;
import java.io.IOException;
import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;

/**
 *
 * @author ALUMNEDAM
 */
public abstract class claseGenerica <T>{
    
    protected File fitxerXML; 
    
    public claseGenerica(String rutaDocument){
        this.fitxerXML = new File(rutaDocument);
    }
    
    public Document carregarFitxerXML() throws SAXException, IOException, ParserConfig;
    
    public void deasrDoc(Document doc) throws TransformerConfigrationException;
    
    public abstract void afegirObjecte(T object);
    
    public abstract T cercarPerCodi(String codi);
    
    public abstract List<T> ;
    
    
    
}
