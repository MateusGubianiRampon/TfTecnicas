import java.util.ArrayList;

public class RepositorioMotorista implements IRepositorioMotorista{

    ArrayList<Motorista> listaMotoristas;
    VeiculoFactory vf;

    RepositorioMotorista(){
        listaMotoristas = new ArrayList<Motorista>();  
        vf = new VeiculoFactory();
        adicionarMotoristas();
    }

    private void adicionarMotoristas(){
         listaMotoristas.add(new Motorista("DINHEIRO","Joao","01461816033",vf.getVeiculo("HHH-0001","FORD","PRETO","LUXO")));
         listaMotoristas.add(new Motorista("DEBITO","Maria","01461816001",vf.getVeiculo("HHH-0002","NISSAN","PRETO","LUXO")));
         listaMotoristas.add(new Motorista("CREDITO","Rodrigo","01461816002",vf.getVeiculo("HHH-0003","NISSAN","PRETO","NORMAL")));
         listaMotoristas.add(new Motorista("DINHEIRO","Yago","01461816003",vf.getVeiculo("HHH-0004","FORD","PRETO","NORMAL")));
         listaMotoristas.add(new Motorista("DEBITO","Juandir","01461816004",vf.getVeiculo("HHH-0005","FORD","PRETO","SIMPLES")));
         listaMotoristas.add(new Motorista("CREDITO","Cleiton","01461816005",vf.getVeiculo("HHH-0006","FORD","PRETO","LUXO")));
         listaMotoristas.add(new Motorista("CREDITO","Heriberto","01461816006",vf.getVeiculo("HHH-0007","FORD","PRETO","SIMPLES")));
         listaMotoristas.add(new Motorista("DINHEIRO","Joesley","01461816007",vf.getVeiculo("HHH-0008","VOLKWAGEN","PRETO","NORMAL")));
         listaMotoristas.add(new Motorista("DEBITO","Capivara","01461816008",vf.getVeiculo("HHH-0009","VOLKSWAGEN","PRETO","LUXO")));

    }


    public Motorista recuperaPorCPF(String cpf){
        for (Motorista p : listaMotoristas){
            if(p.getCPF().equals(cpf)){
                return p;
            }
        }
        return null;
    }

    public void atualizaMotorista(Motorista motorista){
        listaMotoristas.add(motorista);
    }
}