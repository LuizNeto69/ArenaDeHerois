//Autor: Luiz Bernardino da Silva Neto(2026003495)

package arena;

public class Personagem {  //atributos
    private String nome;
    private int vidaMaxima;
    private int vida;
    private int ataque;
    private int defesa;

    public Personagem(String nome, int vidaMaxima,int ataque, int defesa ){ //construtor
        this.nome=nome;
        this.vidaMaxima= vidaMaxima;
        this.ataque=ataque;
        this.defesa=defesa;
        vida=vidaMaxima;
    }

    public String getNome(){
        return nome;
    }

    public int getVidaMaxima(){
        return vidaMaxima;
    }

    public int getVida(){
        return vida;
    }

    public int getAtaque(){
        return ataque;
    }

    public int getDefesa(){
        return defesa;
    }

    public boolean estaVivo(){ //checa se está vivo
        if (vida>0) {
            return true;
        }
        return false;
    }


    public int receberDano(int dano){ //dano que o oponente vai receber/ataque do personagem
            int danoReal =dano-defesa;
            
            if(danoReal>vida){
                int reserva = danoReal;
                danoReal=vida;
            }

            if (danoReal<1) {
                danoReal=1;
            }
            vida=vida-danoReal;
            return danoReal;
    }

    public void curar(int pontos){// cura
        if (estaVivo()!= false && vida<vidaMaxima) {
            vida= vida+pontos;
            if (vida>vidaMaxima) {
                vida=vidaMaxima;
            }
        }
    }

    public void atacar(Personagem alvo){//diz quem o personagem vai atacar
        
        System.out.print(getNome()+ " ataca "+ alvo.getNome() + " e causa "+alvo.receberDano(ataque)+" de dano");
        System.out.println("");
        
    }


    public String status(){
        return nome+" [HP "+ vida + "/" + vidaMaxima+"]";
    }

    protected void aumentarAtaque(int num){
        ataque += num;
    }

}
