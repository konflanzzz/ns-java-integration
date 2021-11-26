package ns.commons;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class NSAPI {

    public static String postRequest(String requestBody, String url, String tpConteudo) throws JsonProcessingException {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response responseAPI;

        try {
            if (tpConteudo.equals("json")) {
                responseAPI = target.request(MediaType.APPLICATION_JSON)
                        .header("X-AUTH-TOKEN", ConfigParceiro.getToken())
                        .header("Content-Type","application/json;charset=utf-8")
                        .post(Entity.json(requestBody));
            }

            else {
                responseAPI = target.request(MediaType.APPLICATION_XML)
                        .header("X-AUTH-TOKEN", ConfigParceiro.getToken())
                        .header("Content-Type","application/xml;charset=utf-8")
                        .post(Entity.xml(requestBody));
            }
        }

        catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build().toString();
        }

        return responseAPI.readEntity(String.class);
    }
}

