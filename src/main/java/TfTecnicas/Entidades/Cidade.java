//package TfTecnicas.Entidades;
import java.util.ArrayList;

public class Cidade{

    private String nome;
    private ArrayList<Bairro> bairros;
    private RepositorioBairro rb;

    public Cidade(String nome){
        this.nome = nome;
        bairros = new ArrayList<Bairro>(); 
        rb = new RepositorioBairro();
    }

    public String getNome(){
        return nome;
    }

    public ArrayList<Bairro> getBairros(){
        return rb.getBairros();
    }

} 