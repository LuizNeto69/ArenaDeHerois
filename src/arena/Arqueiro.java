package arena;

public class Arqueiro extends Personagem {
    private int flechas;
    
    public Arqueiro(String nome, int vidaMaxima,int ataque, int defesa,int flechas ){
        super(nome,vidaMaxima, ataque, defesa);
        this.flechas=flechas;
    }

    public int getFlechas(){
        return flechas;
    }

   
    @Override 
    public void atacar(Personagem alvo){//diz quem o personagem vai atacar
        if (flechas>0) {
            flechas--;
            if(flechas<=0){
                flechas=0;
            }
            int danoBase= getAtaque()+5;//ataque com flecha
            int dano=alvo.receberDano(danoBase);

            System.out.print(getNome()+ " dispara uma flecha em "+ alvo.getNome() + " e causa "+dano+" de dano");
            System.out.println("");
            System.out.println("(Flechas: "+ getFlechas()+ " restante)");
            System.out.println("");
        
            }
        else{
            int danoBase= getAtaque()/2;
            int dano=alvo.receberDano(danoBase);
            System.out.print(getNome()+ " está sem flechas e dá um soco em "+ alvo.getNome() + " e causa "+ dano +" de dano");
            System.out.println("");
        }
        
    }

    public  void recarregar(){
        flechas= flechas+3;
        
        System.out.println( getNome()+" recolhe flechas do chão. "+"(" +getFlechas()+")");
    }
}
