//package TfTecnicas.Entidades;

public class Roteiro {

    private Bairro bairroOrig, bairroDest;
    private Cidade c;

    public Roteiro(Bairro bairroOrig, Bairro bairroDest, Cidade c){
        this.bairroOrig = bairroOrig;
        this.bairroDest = bairroDest;
        this.c = c;
    }

    public Bairro getOrigem(){
        return bairroOrig;
    }
    
    public Bairro getDestino(){
        return bairroDest;
    }

    public Cidade getCidade(){
        return c;
    }

}