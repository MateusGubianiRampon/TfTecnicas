import java.util.ArrayList;

public class RepositorioViagem implements IRepositorioViagem{

    ArrayList<Viagem> listaViagens;
    RepositorioPassageiro rp;
    RepositorioMotorista rm;

    RepositorioViagem(){
        listaViagens = new ArrayList<Viagem>();  
        rp = new RepositorioPassageiro();
        rm = new RepositorioMotorista();
        adicionarViagens();
    }


    private void adicionarViagens(){
        listaViagens.add(new Viagem(rm.recuperaPorCPF("01461816033"), rp.recuperaPorCPF("01461816033")));
    }

    public void cadastrarViagem(Viagem viagem){
        listaViagens.add(viagem);
    }
    
    public ArrayList<Viagem> getViagens(){
        return listaViagens;
    }

}