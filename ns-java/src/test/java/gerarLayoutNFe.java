import nfe.emissao.layout.NFeConstructor;
import nfe.emissao.layout.NFeConstructor.*;
import nfe.emissao.xsd.TNFe;

import javax.xml.bind.JAXBException;

public class gerarLayoutNFe {

    public static void main(String[] args) throws JAXBException {
        String notafiscal = NFeConstructor.nfeToXML(NFeConstructor.generateTNFe());
        System.out.println(notafiscal);
    }

}
