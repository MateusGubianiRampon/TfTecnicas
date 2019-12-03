public class Viagem{

    private int identificador;
    private String dataHora;
    private Roteiro roteiro;
    
    Viagem(int identificador,String dataHora, Roteiro roteiro){
        this.identificador = identificador;
        this.dataHora = dataHora;
        this.roteiro = roteiro;
    }

    public int getIdentificador(){
        return identificador;
    }

    public String getDataHora(){
        return dataHora;
    }

    public Roteiro getRoteiro(){
        return roteiro;
    }
}