package nfe.emissao.status;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Body {
    @JsonProperty("CNPJ")
    String cnpj;
    String nsNRec;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNsNRec() {
        return nsNRec;
    }

    public void setNsNRec(String nsNRec) {
        this.nsNRec = nsNRec;
    }
}
