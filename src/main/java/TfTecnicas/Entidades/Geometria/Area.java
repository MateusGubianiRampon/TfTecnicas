public class Area {

    private Ponto pSupEsq, pInfDir;
    
    public Area(Ponto pSupEsq, Ponto pInfDir) {
    
    if ((pSupEsq.getX() >= pInfDir.getX()) || (pSupEsq.getY() <= pInfDir.getY())) {
    
    throw new IllegalArgumentException("O retangulo deve ser definido pela diagonal principal");
    
    } else {
    
    this.pSupEsq = pSupEsq;
    
    this.pInfDir = pInfDir;
    
    }
    
    }
    
    public Ponto getPSupEsq() {
    
    return pSupEsq;
    
    }
    
    public Ponto getPInfDir() {
    
    return pInfDir;
    
    }
    
    public SituacaoReta classifica(Reta reta) {
        
        AlgoritmodeCohenESutherland cohenSutherland = new AlgoritmodeCohenESutherland();
        return cohenSutherland.clip(reta);
         
        //return SituacaoReta.AlgoritmodeCohenE Sutherland.clip(reta);
        // TO DO: implementar Cohen e Shuterland
    }
    
    @Override
    
    public String toString() {
    
        return "Area [pInfDir=" + pInfDir + ", pSupEsq=" + pSupEsq + "]";
    
    } 
    
}