package nfe.emissao.download;

public class Response {

    public String status;
    public String motivo;
    public String chNFe;
    public String cStat;
    public String xMotivo;
    public String nProt;
    public String dhRecbto;
    public String xml;
    public String erro;

    public Response() {}

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

    public String getChNFe() {
        return chNFe;
    }

    public void setChNFe(String chNFe) {
        this.chNFe = chNFe;
    }

    public String getcStat() {
        return cStat;
    }

    public void setcStat(String cStat) {
        this.cStat = cStat;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public void setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
    }

    public String getnProt() {
        return nProt;
    }

    public void setnProt(String nProt) {
        this.nProt = nProt;
    }

    public String getDhRecbto() {
        return dhRecbto;
    }

    public void setDhRecbto(String dhRecbto) {
        this.dhRecbto = dhRecbto;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
