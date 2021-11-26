package nfe.emissao.issue;

public class Response {
    public String status;
    public String motivo;
    public String nsNRec;

    public Response() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNsNRec() {
        return nsNRec;
    }

    public void setNsNRec(String nsNRec) {
        this.nsNRec = nsNRec;
    }
}
