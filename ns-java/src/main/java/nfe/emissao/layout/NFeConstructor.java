package nfe.emissao.layout;

import nfe.emissao.xsd.*;
import ns.commons.Util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.util.*;

public class NFeConstructor {

    // Method to convert the TNFe object to XML string do send via http - post
    public static String nfeToXML(TNFe NFe) throws JAXBException {

        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(TNFe.class);
        Marshaller m = context.createMarshaller();
        m.marshal(new JAXBElement(new QName(TNFe.class.getSimpleName()), TNFe.class, NFe), writer);

        String xml_nfe = writer.toString();
        xml_nfe = xml_nfe.replaceAll("xmlns:ns[0-9]=", "")
                .replaceAll("\"http://www.w3.org/2000/09/xmldsig#\"","")
                .replaceAll("ns[0-9]:","")
                .replaceAll("<\\?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"\\?>", "")
                .replaceAll("/TNFe", "/NFe")
                .replaceAll("TNFe", "NFe xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"")
                .replaceAll("  \"http://www.portalfiscal.inf.br/nfe\"", "")
                .replaceAll("</http://www.portalfiscal.inf.br/nfe>","")
                .replaceAll("<http://www.portalfiscal.inf.br/nfe>", "");
        System.out.println(xml_nfe);
        return xml_nfe;
    }

    // generate de full TNFe object
    public static TNFe generateTNFe(){
        TNFe NFe = new TNFe();
        NFe.setInfNFe(
                generateInfNFe(
                        "",
                        generateIde(),
                        generateEmit(
                                generateEnderEmit()
                        ),
                        generateDest(
                                generateEnderDest()
                        ),generateListOfDet(
                                genarateProdutos(3),
                                generateImposto(3)
                        ),generateTotal(
                                generateListOfDet(
                                genarateProdutos(3),
                                        generateImposto(3)
                                )
                        ),generateTransp(),
                        generatePag(),
                        generateInfAdic()
                )
        );
        return NFe;
    }

    public static TNFe.InfNFe generateInfNFe( String Id, TNFe.InfNFe.Ide ide, TNFe.InfNFe.Emit emit, TNFe.InfNFe.Dest dest, List<TNFe.InfNFe.Det> det, TNFe.InfNFe.Total total, TNFe.InfNFe.Transp transp, TNFe.InfNFe.Pag pag, TNFe.InfNFe.InfAdic infAdic){
        TNFe.InfNFe nfeInfNFe = new TNFe.InfNFe();

        nfeInfNFe.setId(Id);
        nfeInfNFe.setIde(ide);
        nfeInfNFe.setEmit(emit);
        nfeInfNFe.setDest(dest);
        nfeInfNFe.getDet().addAll(det);
        nfeInfNFe.setTotal(total);
        nfeInfNFe.setTransp(transp);
        nfeInfNFe.setPag(pag);
        nfeInfNFe.setInfAdic(infAdic);

        return nfeInfNFe;
    }

    public static TNFe.InfNFe.Ide generateIde(){
        TNFe.InfNFe.Ide infNFeIde = new TNFe.InfNFe.Ide();

        infNFeIde.setTpAmb("2");
        infNFeIde.setCUF("43");
        infNFeIde.setCNF("");
        infNFeIde.setNatOp("VENDA A PRAZO - SEM VALOR FISCAL");
        infNFeIde.setMod("55");
        infNFeIde.setSerie("0");
        infNFeIde.setNNF("22539");
        infNFeIde.setDhEmi(Util.setDhEmi());
        infNFeIde.setTpNF("1");
        infNFeIde.setIdDest("1");
        infNFeIde.setCMunFG("4305108");
        infNFeIde.setTpImp("1");
        infNFeIde.setTpEmis("2");
        infNFeIde.setCDV("");
        infNFeIde.setFinNFe("1");
        infNFeIde.setIndFinal("0");
        infNFeIde.setIndPres("9");
        infNFeIde.setProcEmi("0");
        infNFeIde.setVerProc("4.00");

        return infNFeIde;
    }

    public static TNFe.InfNFe.Emit generateEmit(TEnderEmi enderEmit){
        TNFe.InfNFe.Emit nfeInfNFeEmit = new TNFe.InfNFe.Emit();

        nfeInfNFeEmit.setCNPJ("07364617000135");
        nfeInfNFeEmit.setXNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
        nfeInfNFeEmit.setIE("0170108708");
        nfeInfNFeEmit.setCRT("1");
        nfeInfNFeEmit.setEnderEmit(enderEmit);

        return nfeInfNFeEmit;
    }

    public static TEnderEmi generateEnderEmit(){

        TEnderEmi enderEmit = new TEnderEmi();

        enderEmit.setXLgr("Rua Bento Osvaldo Trisch");
        enderEmit.setNro("777");
        enderEmit.setXCpl("CX POSTAL 91");
        enderEmit.setXBairro("Pendancino");
        enderEmit.setCMun("4303509");
        enderEmit.setXMun("Caxias do Sul");
        enderEmit.setUF(TUfEmi.valueOf("RS"));
        enderEmit.setCEP("95046600");
        enderEmit.setFone("005432200200");

        return enderEmit;
    }

    public static TNFe.InfNFe.Dest generateDest(TEndereco enderDest){

        TNFe.InfNFe.Dest nfeInfNFeDest = new TNFe.InfNFe.Dest();

        nfeInfNFeDest.setCNPJ("07364617000135");
        nfeInfNFeDest.setIE("01701008708");
        nfeInfNFeDest.setIndIEDest("1");
        nfeInfNFeDest.setEnderDest(enderDest);

        return nfeInfNFeDest;
    }

    public static TEndereco generateEnderDest(){

        TEndereco enderDest = new TEndereco();
        enderDest.setXLgr("AV ANTONIO DURO");
        enderDest.setNro("870");
        enderDest.setXBairro("OLARIA");
        enderDest.setCMun("4303509");
        enderDest.setXMun("CAMAQUA");
        enderDest.setUF(TUf.valueOf("RS"));
        enderDest.setCEP("96180000");
        enderDest.setCPais("1058");
        enderDest.setXPais("BRASIL");

        return enderDest;
    }

    // generate de data for de Det field in NFe
    public static List<TNFe.InfNFe.Det> generateListOfDet(TNFe.InfNFe.Det.Prod[] prodArray, TNFe.InfNFe.Det.Imposto[] impostoArray){

        List<TNFe.InfNFe.Det> nfeInfNFeDetList = new ArrayList<>();

        if (prodArray.length == impostoArray.length) {

            for (int i = 0; i < prodArray.length; i++) {

                TNFe.InfNFe.Det uniqueDet = new TNFe.InfNFe.Det();

                uniqueDet.setNItem(String.valueOf(i));
                uniqueDet.setProd(prodArray[0]);
                uniqueDet.setImposto(impostoArray[0]);

                nfeInfNFeDetList.add(uniqueDet);
            }
        }

        return nfeInfNFeDetList;
    }

    // generate de data of single product
    public static TNFe.InfNFe.Det.Prod[] genarateProdutos(int amoutProdutos){

        TNFe.InfNFe.Det.Prod[] arrayOfProdutos = new TNFe.InfNFe.Det.Prod[amoutProdutos];

        for (int i = 0; i < amoutProdutos; i++) {

            TNFe.InfNFe.Det.Prod dadosProdutoNFe = new TNFe.InfNFe.Det.Prod();

            dadosProdutoNFe.setCEAN("SEM GTIN");
            dadosProdutoNFe.setCEANTrib("SEM GTIN");
            dadosProdutoNFe.setCProd("123456789");
            dadosProdutoNFe.setXProd("COCA-COLA LT 250ML");
            dadosProdutoNFe.setNCM("22021000");
            dadosProdutoNFe.setCEST("0301100");
            dadosProdutoNFe.setCFOP("5101");
            dadosProdutoNFe.setUCom("UN");
            dadosProdutoNFe.setQCom("1.0000");
            dadosProdutoNFe.setVUnCom("3.00");
            dadosProdutoNFe.setVProd("3.00");
            dadosProdutoNFe.setUTrib("UN");
            dadosProdutoNFe.setQTrib("1.0000");
            dadosProdutoNFe.setVUnTrib("3.00");
            dadosProdutoNFe.setIndTot("1");
            dadosProdutoNFe.setNItemPed("0");

            arrayOfProdutos[i] = dadosProdutoNFe;
        }

        return arrayOfProdutos;
    }

    public static TNFe.InfNFe.Det.Imposto[] generateImposto(int amoutProdutos){

        TNFe.InfNFe.Det.Imposto[] arrayOfNFeInfNFeDetImposto = new TNFe.InfNFe.Det.Imposto[amoutProdutos];

        for (int i = 0; i < amoutProdutos; i++) {
            TNFe.InfNFe.Det.Imposto NFeInfNFeDetImposto = new TNFe.InfNFe.Det.Imposto();

            JAXBElement<TNFe.InfNFe.Det.Imposto> NFeInfNFeDetImpostoJAXBElement = new JAXBElement(
                    new QName("http://www.portalfiscal.inf.br/nfe"),
                    TNFe.InfNFe.Det.Imposto.ICMS.class,
                    NFeInfNFeDetImposto
            );

            NFeInfNFeDetImposto.getContent().add(generateIcms());
            NFeInfNFeDetImposto.getContent().add(generatePis());
            NFeInfNFeDetImposto.getContent().add(generateCofins());

            NFeInfNFeDetImpostoJAXBElement.setValue(NFeInfNFeDetImposto);

            arrayOfNFeInfNFeDetImposto[i] = NFeInfNFeDetImposto;

        }

        return arrayOfNFeInfNFeDetImposto;
    }

    public static JAXBElement<TNFe.InfNFe.Det.Imposto.ICMS> generateIcms(){

        TNFe.InfNFe.Det.Imposto.ICMS NFeInfNFeDetImpostoIcms = new TNFe.InfNFe.Det.Imposto.ICMS();

        TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN102 icmssn102 = new TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN102();

        icmssn102.setOrig("0");
        icmssn102.setCSOSN("102");
        NFeInfNFeDetImpostoIcms.setICMSSN102(icmssn102);

        return new JAXBElement(
                new QName("http://www.portalfiscal.inf.br/nfe"),
                TNFe.InfNFe.Det.Imposto.ICMS.class,
                NFeInfNFeDetImpostoIcms
        );

    }

    public static JAXBElement<TNFe.InfNFe.Det.Imposto.PIS> generatePis(){

        TNFe.InfNFe.Det.Imposto.PIS NFeInfNFeDetImpostoPis = new TNFe.InfNFe.Det.Imposto.PIS();
        TNFe.InfNFe.Det.Imposto.PIS.PISAliq pisAliq = new TNFe.InfNFe.Det.Imposto.PIS.PISAliq();

        pisAliq.setCST("1");
        pisAliq.setVBC("3.00");
        pisAliq.setPPIS("1.65");
        pisAliq.setVPIS("0.05");
        NFeInfNFeDetImpostoPis.setPISAliq(pisAliq);

        return new JAXBElement(
                new QName("http://www.portalfiscal.inf.br/nfe"),
                TNFe.InfNFe.Det.Imposto.PIS.class,
                NFeInfNFeDetImpostoPis
        );
    }

    public static JAXBElement<TNFe.InfNFe.Det.Imposto.COFINS> generateCofins(){

        TNFe.InfNFe.Det.Imposto.COFINS NFeInfNFeDetImpostoCofins = new TNFe.InfNFe.Det.Imposto.COFINS();
        TNFe.InfNFe.Det.Imposto.COFINS.COFINSAliq cofinsAliq = new TNFe.InfNFe.Det.Imposto.COFINS.COFINSAliq();

        cofinsAliq.setCST("01");
        cofinsAliq.setVBC("3.00");
        cofinsAliq.setPCOFINS("7.00");
        cofinsAliq.setVCOFINS("0.21");
        NFeInfNFeDetImpostoCofins.setCOFINSAliq(cofinsAliq);

        return new JAXBElement(
                new QName("http://www.portalfiscal.inf.br/nfe"),
                TNFe.InfNFe.Det.Imposto.COFINS.class,
                NFeInfNFeDetImpostoCofins
        );
    }

    public static TNFe.InfNFe.Total generateTotal(List<TNFe.InfNFe.Det> nfeInfNFeListOfDet){

        TNFe.InfNFe.Total nfeInfNFeTotal = new TNFe.InfNFe.Total();

        nfeInfNFeTotal.setICMSTot(generateIcmsTot(nfeInfNFeListOfDet));

        return nfeInfNFeTotal;
    }

    public static TNFe.InfNFe.Total.ICMSTot generateIcmsTot (List<TNFe.InfNFe.Det> nfeInfNFeListOfDet){

        TNFe.InfNFe.Total.ICMSTot nfeInfNFeTotalIcmsTot = new TNFe.InfNFe.Total.ICMSTot();

        nfeInfNFeTotalIcmsTot.setVBC("0");
        nfeInfNFeTotalIcmsTot.setVICMS("0");
        nfeInfNFeTotalIcmsTot.setVICMSDeson("0.00");
        nfeInfNFeTotalIcmsTot.setVFCPUFDest("0.00");
        nfeInfNFeTotalIcmsTot.setVICMSUFDest("0.00");
        nfeInfNFeTotalIcmsTot.setVICMSUFRemet("0.00");
        nfeInfNFeTotalIcmsTot.setVFCP("0");
        nfeInfNFeTotalIcmsTot.setVBCST("0");
        nfeInfNFeTotalIcmsTot.setVST("0");
        nfeInfNFeTotalIcmsTot.setVFCPST("0");
        nfeInfNFeTotalIcmsTot.setVFCPSTRet("0.00");

        // create a metohod to calculate it
        nfeInfNFeTotalIcmsTot.setVProd(calculateIcmsTotVProd(nfeInfNFeListOfDet));

        nfeInfNFeTotalIcmsTot.setVFrete("0.00");
        nfeInfNFeTotalIcmsTot.setVSeg("0.00");
        nfeInfNFeTotalIcmsTot.setVDesc("0.00");
        nfeInfNFeTotalIcmsTot.setVII("0.00");

        // create a metohod to calculate it
        nfeInfNFeTotalIcmsTot.setVIPI("0.00");

        nfeInfNFeTotalIcmsTot.setVIPIDevol("0.00");

        // create a metohod to calculate it
        nfeInfNFeTotalIcmsTot.setVPIS(calculateIcmsTotVPis(nfeInfNFeListOfDet));

        // create a metohod to calculate it
        nfeInfNFeTotalIcmsTot.setVCOFINS("0.21");
        nfeInfNFeTotalIcmsTot.setVOutro("0.00");

        // create a metohod to calculate it
        nfeInfNFeTotalIcmsTot.setVNF("3.00");
        nfeInfNFeTotalIcmsTot.setVTotTrib("0.00");

        return nfeInfNFeTotalIcmsTot;
    }

    public static String calculateIcmsTotVProd(List<TNFe.InfNFe.Det> nfeInfNFeListOfDet){

        int icmsTotVProd = 0;

        for (TNFe.InfNFe.Det det : nfeInfNFeListOfDet) {
            icmsTotVProd += 3;
        }

        return String.valueOf(icmsTotVProd);
    }

    public static String calculateIcmsTotVPis(List<TNFe.InfNFe.Det> nfeInfNFeListOfDet ){

        int icmsTotVPis = 0;

        for (int i = 0; i < nfeInfNFeListOfDet.size(); i++) {
            icmsTotVPis += 3;
        }

        return String.valueOf(icmsTotVPis);
    }

    public static TNFe.InfNFe.Transp generateTransp(){

        TNFe.InfNFe.Transp nfeInfNFeTransp = new TNFe.InfNFe.Transp();
        nfeInfNFeTransp.setModFrete("9");

        return nfeInfNFeTransp;
    }

    public static TNFe.InfNFe.Pag generatePag(){

        TNFe.InfNFe.Pag nfeInfNFePag = new TNFe.InfNFe.Pag();

        ArrayList<TNFe.InfNFe.Pag.DetPag> detPagArrayList = new ArrayList<>();
        TNFe.InfNFe.Pag.DetPag detPag = new TNFe.InfNFe.Pag.DetPag();
        detPag.setTPag("16");
        detPag.setVPag("5.00");
        nfeInfNFePag.getDetPag().add(detPag);

        return nfeInfNFePag;
    }

    public static TNFe.InfNFe.InfAdic generateInfAdic(){

        TNFe.InfNFe.InfAdic nfeInfNFeInfAdic = new TNFe.InfNFe.InfAdic();
        nfeInfNFeInfAdic.setInfCpl("TESTE DE EMISSAO COM NOVO EXEMPLO EM JAVA");

        return nfeInfNFeInfAdic;
    }

}

