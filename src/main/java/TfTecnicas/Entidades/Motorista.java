//package TfTecnicas.Entidades;
//import TfTecnicas.Entidades.Veiculo.Veiculo;
public class Motorista {

    private String nome, cpf;
    private int somatorioAval, qtdadeAval;
    private Veiculo veiculo;
    private FormaPagamento formaPagmto;

    
    private void MotoristaDinheiro(String nome, String cpf, Veiculo veiculo, FormaPagamento formaPagmto){
        this.nome = nome;
        this.cpf = cpf;
        somatorioAval = 0;
        qtdadeAval = 0;
        this.veiculo = veiculo;
        if(FormaPagamento.DINHEIRO.equals(formaPagmto)){
             this.formaPagmto = formaPagmto;
        }
    }

    private void MotoristaCredito(String nome, String cpf, Veiculo veiculo, FormaPagamento formaPagmto){
        this.nome = nome;
        this.cpf = cpf;
        somatorioAval = 0;
        qtdadeAval = 0;
        this.veiculo = veiculo;
        if(FormaPagamento.CREDITO.equals(formaPagmto)){
            this.formaPagmto = formaPagmto;
        }
        return;
    }

    private void MotoristaDebito(String nome, String cpf, Veiculo veiculo, FormaPagamento formaPagmto){
        this.nome = nome;
        this.cpf = cpf;
        somatorioAval = 0;
        qtdadeAval = 0;
        this.veiculo = veiculo;
        if(FormaPagamento.DEBITO.equals(formaPagmto)){
            this.formaPagmto = formaPagmto;
        }
    }


    public Motorista(String aceitaPagamento, String nome, String cpf, Veiculo veiculo){

        if(aceitaPagamento.equals("DINHEIRO")){
            MotoristaDinheiro(nome,cpf,veiculo,FormaPagamento.DINHEIRO);
        }
        else if(aceitaPagamento.equals("DEBITO")){
            MotoristaDebito(nome,cpf,veiculo,FormaPagamento.DEBITO);       
         }
        else if(aceitaPagamento.equals("CREDITO")){
            MotoristaCredito(nome,cpf,veiculo,FormaPagamento.CREDITO);
        }
        else{

        }
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

    public Veiculo getVeiculo(){
        return veiculo;
    }

    public FormaPagamento getFormaPagmto(){
        return formaPagmto;
    }

}