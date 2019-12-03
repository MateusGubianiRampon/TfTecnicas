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

public abstract class CalculoCustoViagemBasico extends CalculoCustoViagem {

    private Cidade cidade;
    private Roteiro roteiro;
    private Passageiro passageiro;
    private Veiculo veiculo;

    
    CalculoCustoViagemBasico(Cidade cidade, Roteiro roteiro, Passageiro passageiro, Veiculo veiculo){
        super(cidade,roteiro,passageiro,veiculo);
    }

    @Override
    public Roteiro getRoteiro(){
        return super.getRoteiro();
    }

    @Override
    public Cidade getCidade(){
        return super.getCidade();
    }

    @Override
    public Passageiro getPassageiro(){
        return super.getPassageiro();
    }

    @Override
    public Veiculo getVeiculo(){
        return super.getVeiculo();
    }

    public int calculoCustoBasico(){
        return super.custoViagem();
    }

    public int adicionalVeiculo(){
        if(veiculo instanceof VeiculoSimples){
            return calculoCustoBasico();
        }
        else if(veiculo instanceof VeiculoNormal){
            return (calculoCustoBasico()*110)/100;
        }
        else if(veiculo instanceof VeiculoLuxo){
            int y = 0;;
            int count = 0;
            Reta r = new Reta(new Ponto(
                (roteiro.getOrigem().getArea().getPSupEsq().getX() - roteiro.getOrigem().getArea().getPInfDir().getX())
                        / 2,
                (roteiro.getOrigem().getArea().getPSupEsq().getY() - roteiro.getOrigem().getArea().getPInfDir().getY())
                        / 2),
                new Ponto(
                        (roteiro.getDestino().getArea().getPSupEsq().getX()
                                - roteiro.getDestino().getArea().getPInfDir().getX()) / 2,
                        (roteiro.getDestino().getArea().getPSupEsq().getY()
                                - roteiro.getDestino().getArea().getPInfDir().getY()) / 2));
            for(Bairro b : cidade.getBairros()){
                if(b.getArea().classifica(r) == SituacaoReta.INTERSECTA ||
                b.getArea().classifica(r) == SituacaoReta.TODA_DENTRO){
                    y += b.getCustoBasico();
                    count+=2;
                }
            }
            return (calculoCustoBasico()*(110 + count))/100; 
        }
        return 0;
    }

        public int descontoPontuacao(int x){
        int y = 0;
        Reta r = new Reta(new Ponto(
                (roteiro.getOrigem().getArea().getPSupEsq().getX() - roteiro.getOrigem().getArea().getPInfDir().getX())
                        / 2,
                (roteiro.getOrigem().getArea().getPSupEsq().getY() - roteiro.getOrigem().getArea().getPInfDir().getY())
                        / 2),
                new Ponto(
                        (roteiro.getDestino().getArea().getPSupEsq().getX()
                                - roteiro.getDestino().getArea().getPInfDir().getX()) / 2,
                        (roteiro.getDestino().getArea().getPSupEsq().getY()
                                - roteiro.getDestino().getArea().getPInfDir().getY()) / 2));
        passageiro.novaAvaliacao(x);
        if(x >= 8 && x <= 10){
            return (y*50)/100;
        }
        return y;
    }

    
    public abstract int descontoPromocao(int x);

}