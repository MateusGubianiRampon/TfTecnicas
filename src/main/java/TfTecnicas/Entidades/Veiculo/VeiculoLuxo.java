package TfTecnicas.Entidades.Veiculo;

public class VeiculoLuxo extends Veiculo {
    
    private String placa, marca, cor;
    private boolean catInf;
    private boolean bagageiro;

    public VeiculoLuxo (String placa, String marca, String cor){
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.catInf = true;
        this.bagageiro = true;
    }

    @Override
    public String getPlaca(){ return placa;  }

    @Override
    public String getMarca(){ return marca;  }

    @Override
    public String getCor(){   return cor;    }

    public boolean tipoBagageiro(){
        return bagageiro;
    }
    
    public boolean categoriaInferior(){
        return catInf;
    }

    @Override
    public String getCategoria() {
        // TODO Auto-generated method stub
        return null;
    }

}