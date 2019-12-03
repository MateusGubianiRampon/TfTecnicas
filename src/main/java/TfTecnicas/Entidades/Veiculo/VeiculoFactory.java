package TfTecnicas.Entidades.Veiculo;

public class VeiculoFactory {


    public static Veiculo getVeiculo(String placa, String marca, String cor, String categoria){

        if(categoria.toUpperCase().equals("LUXO")){
            return new VeiculoLuxo(placa,marca,cor);
        }

        else if(categoria.toUpperCase().equals("NORMAL")) { 
            return new VeiculoNormal(placa,marca,cor);
        }

        else{
            return new VeiculoSimples(placa,marca,cor);
        }
    }
}