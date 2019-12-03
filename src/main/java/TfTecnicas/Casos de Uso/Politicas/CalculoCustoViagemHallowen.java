// import TfTecnicas.Entidades.Bairro;
// import TfTecnicas.Entidades.Cidade;
// import TfTecnicas.Entidades.Passageiro;
// import TfTecnicas.Entidades.Roteiro;
// import TfTecnicas.Entidades.Geometria.Ponto;
// import TfTecnicas.Entidades.Geometria.Reta;
// import TfTecnicas.Entidades.Geometria.SituacaoReta;
// import TfTecnicas.Entidades.Veiculo.Veiculo;

public class CalculoCustoViagemHallowen extends CalculoCustoViagemBasico {

    private Cidade cidade;
    private Roteiro roteiro;
    private Passageiro passageiro;
    private Veiculo veiculo;

    public CalculoCustoViagemHallowen(Cidade cidade, Roteiro roteiro, Passageiro passageiro, Veiculo veiculo){
            super(cidade,roteiro,passageiro,veiculo);
    }

    
    @Override
    public int calculoCustoBasico(){
        return super.calculoCustoBasico();
    }

    @Override
     public int adicionalVeiculo(){
        return super.adicionalVeiculo();
     }


    @Override
    public int descontoPontuacao(int x){
         return super.descontoPontuacao(x);
    }
    
    public int descontoPromocao(int x){
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
        
        if(x > 100 || x < 0){
            throw new IllegalArgumentException("Valor de promoção inválido!");
        }
        return (y * x)/100;
    }
}