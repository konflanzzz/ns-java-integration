package nfe.emissao.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ns.commons.NSAPI;

public class Request {
    public static Response sendPostRequest(Body requestBody) throws JsonProcessingException {

        String url = "https://nfe.ns.eti.br/nfe/issue/status";

        ObjectMapper mapper = new ObjectMapper();
        String jsonRequestBody = mapper.writeValueAsString(requestBody);

        try {
            return mapper.readValue(NSAPI.postRequest(jsonRequestBody,url,"json"), Response.class);
        }
        catch (Exception ex){
            System.out.printf("ERRO: "  + ex); //log
        }
        return null;
    }
}
