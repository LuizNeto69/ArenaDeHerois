//Autor: Luiz Bernardino da Silva Neto(2026003495)
package arena;

public class Guerreiro extends Personagem{
    private int armadura;
    
    public Guerreiro(String nome,int vidaMaxima, int ataque, int defesa, int armadura){
        super( nome,vidaMaxima,ataque, defesa);
        this.armadura= armadura;
    }

    public int getArmadura(){
        return armadura;
    }


   @Override
    public int receberDano(int dano) {
        return super.receberDano(dano - armadura);
    }

    public void gritoDeGuerra(){
        aumentarAtaque(5);

         System.out.println(getNome() + " solta um grito de guerra! Ataque agora: " + getAtaque() + ".");
        
    }

}