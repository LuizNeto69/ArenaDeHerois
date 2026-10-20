//Autor: Luiz Bernardino da Silva Neto(2026003495)
package arena;

public class Mago extends Personagem {
    private int mana;
    
    public Mago(String nome, int vidaMaxima,int ataque, int defesa, int mana){
        super( nome, vidaMaxima, ataque,defesa);
        this.mana=mana;
    }

    public int getMana(){
        return mana;
    }


    @Override 
    public void atacar(Personagem alvo){//diz quem o personagem vai atacar
        if (mana>=10) {
            mana=mana-10;
            if(mana<=0){
                mana=0;
            }
            int danoBase= getAtaque()*2;// bola de fogo
            int dano= alvo.receberDano(danoBase);
            System.out.print(getNome()+ " lança uma bola de fogo em "+ alvo.getNome() + " e causa "+dano+" de dano");
            System.out.println("");
            System.out.println("(Mana: "+ getMana()+ " restante)");
            System.out.println("");
        }
        else{
            System.out.print(getNome()+ " ataca "+ alvo.getNome() + " e causa "+alvo.receberDano(getAtaque())+" de dano");
            System.out.println("");
        }
    }

    public void curarAliado(Personagem p){
       if(getMana()>=15){
            mana=- 15;
            p.curar(25);

            System.out.println(getNome()+ "cura " + p.getNome() +"."+ p.getNome()+" [HP "+ p.getVida() + "/" + p.getVidaMaxima()+"]");
            
       }
    }
    
}

