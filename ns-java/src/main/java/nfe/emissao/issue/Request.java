package nfe.emissao.issue;

import com.fasterxml.jackson.databind.ObjectMapper;
import ns.commons.API;
import nfe.emissao.xsd.TNFe;

import static nfe.emissao.layout.NFeConstructor.nfeToXML;

public class Request {
    public static Response sendPostRequest(TNFe requestBody){
        String url = "https://nfe.ns.eti.br/nfe/issue";

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(API.postRequest(nfeToXML(requestBody),url,"json"), Response.class);
        }
        catch (Exception ex){
            System.out.print("ERRO: "  + ex); //log
        }
        return null;
    }
}
