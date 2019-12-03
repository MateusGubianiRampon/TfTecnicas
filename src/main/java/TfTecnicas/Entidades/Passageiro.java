//package TfTecnicas.Entidades;

public class Passageiro {

    private String nome, cpf;
    private int somatorioAval, qtdadeAval;

    public Passageiro(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        somatorioAval = 0;
        qtdadeAval = 0;
    }

    public String getNome(){
        return nome;
    }

    public String getCPF(){
        return cpf;
    }

    public int getSomatorioAval(){
        return somatorioAval;
    }

    public int getQtdadeAval(){
        return qtdadeAval;
    }

    public void novaAvaliacao(int nota){
        if(nota < 0 || nota > 10){
            throw new IllegalArgumentException("Nota inválida!");
        }
        else{
            somatorioAval += nota;
            qtdadeAval++;
        }
    }

    public void zeraAvaliacao(){
        somatorioAval = 0;
        qtdadeAval = 0;
    }

    public int mediaSoma(){
        if(qtdadeAval == 0){
            return 0;
        }
        return somatorioAval / qtdadeAval;
    }

}