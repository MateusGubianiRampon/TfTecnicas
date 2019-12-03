//package TfTecnicas.Entidades;
//import TfTecnicas.Entidades.Geometria.Area;

public class Bairro {

    private String nome;
    private Area area;
    private int custoBasico;

    public Bairro(String nome, Area area, int custoBasico){
        this.nome = nome;
        this.area = area;
        this.custoBasico = custoBasico;
    }

    public String getNome(){
        return nome;
    }

    public Area getArea(){
        return area;
    }

    public int getCustoBasico(){
        return custoBasico;
    }

}