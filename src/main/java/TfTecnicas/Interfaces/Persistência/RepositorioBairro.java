import java.util.ArrayList;

public class RepositorioBairro implements IRepositorioBairro{

    ArrayList<Bairro> listaBairros;

    public RepositorioBairro(){
        listaBairros = new ArrayList<Bairro>();
        adicionarBairros();
    }

    public void adicionarBairros(){
        listaBairros.add(new Bairro("Menino Deus",new Area( new Ponto(20,30), new Ponto(40,50)),10));
        listaBairros.add(new Bairro("Zona Norte",new Area( new Ponto(30,40), new Ponto(50,60)),35));
        listaBairros.add(new Bairro("Zona Sul",new Area( new Ponto(40,50), new Ponto(60,70)),25));
        listaBairros.add(new Bairro("Zona Leste",new Area( new Ponto(50,60), new Ponto(70,80)),20));
        listaBairros.add(new Bairro("Centro",new Area( new Ponto(60,70), new Ponto(80,90)),40));
        listaBairros.add(new Bairro("Floresta",new Area( new Ponto(70,80), new Ponto(90,100)),30));
        listaBairros.add(new Bairro("Ipica",new Area( new Ponto(80,90), new Ponto(110,110)),50));
        listaBairros.add(new Bairro("Viamao",new Area( new Ponto(90,100), new Ponto(120,120)),100));       
    }
    public void adicionaBairro(Bairro bairro){
        listaBairros.add(bairro);
    }
    public Bairro getBairro(String nome){
       for (Bairro b : listaBairros){
            if(b.getNome().equals(nome)){
                return b;
            }
        }    
        return null;
    }
    public ArrayList<Bairro> getBairros(){
        return listaBairros;
    }


}