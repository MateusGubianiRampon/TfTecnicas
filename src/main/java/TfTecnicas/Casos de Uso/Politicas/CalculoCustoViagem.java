// import  TfTecnicas.Entidades.Bairro;
// import  TfTecnicas.Entidades.Cidade;
// import  TfTecnicas.Entidades.Passageiro;
// import  TfTecnicas.Entidades.Roteiro;
// import  TfTecnicas.Entidades.Geometria.Ponto;
// import  TfTecnicas.Entidades.Geometria.Reta;
// import  TfTecnicas.Entidades.Geometria.SituacaoReta;
// import  TfTecnicas.Entidades.Veiculo.Veiculo;
// import  TfTecnicas.Entidades.Veiculo.VeiculoLuxo;
// import  TfTecnicas.Entidades.Veiculo.VeiculoNormal;
// import  TfTecnicas.Entidades.Veiculo.VeiculoSimples;

public abstract class CalculoCustoViagem{

    private Cidade cidade;
    private Roteiro roteiro;
    private Passageiro passageiro;
    private Veiculo veiculo;

    CalculoCustoViagem(Cidade cidade, Roteiro roteiro, Passageiro passageiro,Veiculo veiculo){

        this.cidade = cidade;
        this.roteiro = roteiro;
        this.passageiro = passageiro;
        this.veiculo = veiculo;
    }


    public Roteiro getRoteiro(){
        return roteiro;
    }

    
    public Cidade getCidade(){
        return cidade;
    }

    
    public Passageiro getPassageiro(){
        return passageiro;
    }

    
    public Veiculo getVeiculo(){
        return veiculo;
    }


    public int custoViagem() {
        int y = 0;
        Reta r = new Reta(new Ponto(
                                   (roteiro.getOrigem().getArea().getPSupEsq().getX() - roteiro.getOrigem().getArea().getPInfDir().getX()) / 2,  //Criando os pontos
                                   (roteiro.getOrigem().getArea().getPSupEsq().getY() - roteiro.getOrigem().getArea().getPInfDir().getY()) / 2),
                        
                         new Ponto((roteiro.getDestino().getArea().getPSupEsq().getX() - roteiro.getDestino().getArea().getPInfDir().getX()) / 2,
                                  (roteiro.getDestino().getArea().getPSupEsq().getY() - roteiro.getDestino().getArea().getPInfDir().getY()) / 2));
        
        for (final Bairro b : cidade.getBairros()) {                        //procurando quais bairros o motorista passou 
            if(b.getArea().classifica(r) == SituacaoReta.INTERSECTA ||
            b.getArea().classifica(r) == SituacaoReta.TODA_DENTRO){
                y += b.getCustoBasico();
            }
        }
        return y;
    }

    //Metodo Strategy
    public abstract int calculoCustoBasico();
    public abstract int adicionalVeiculo();
    public abstract int descontoPontuacao(int x);
}
