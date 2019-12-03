import java.util.ArrayList;
public interface IRepositorioBairro{
        
        public void adicionaBairro(Bairro Bairro);
        public Bairro getBairro(String nome);
        public ArrayList<Bairro> getBairros();
}