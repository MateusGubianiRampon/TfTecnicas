import java.util.ArrayList;

public interface IRepositorioViagem{
    public void cadastrarViagem(Viagem viagem);
    public ArrayList<Viagem> getViagens();
}