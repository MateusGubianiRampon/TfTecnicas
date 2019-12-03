import java.util.ArrayList;

public class RepositorioPassageiro implements IRepositorioPassageiro{

    ArrayList<Passageiro> listaPassageiros;

    RepositorioPassageiro(){
        listaPassageiros = new ArrayList<Passageiro>(); 
        adicionarPassageiros();
    }

    private void adicionarPassageiros(){
         listaPassageiros.add(new Passageiro("Mateus","01461816033"));
         listaPassageiros.add(new Passageiro("Rodrigo","01461816001"));
         listaPassageiros.add(new Passageiro("Fabio","01461816002"));
         listaPassageiros.add(new Passageiro("Fabio","01461816002"));
         listaPassageiros.add(new Passageiro("Marcelo","01461816003"));
         listaPassageiros.add( new Passageiro("Igor","01461816004"));
         listaPassageiros.add( new Passageiro("Daniele","01461816005"));
         listaPassageiros.add( new Passageiro("Lucas","01461816006"));
         listaPassageiros.add( new Passageiro("Dayenne","01461816007"));

    }


    public Passageiro recuperaPorCPF(String cpf){
        for (Passageiro p : listaPassageiros){
            if(p.getCPF().equals(cpf)){
                return p;
            }
        }
        return null;
    }
    public void atualizaPassageiro(Passageiro passageiro){
        listaPassageiros.add(passageiro);
    }
}