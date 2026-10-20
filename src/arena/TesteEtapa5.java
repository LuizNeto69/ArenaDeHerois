//Autor: Luiz Bernardino da Silva Neto(2026003495)
package arena;

public class TesteEtapa5 {
    public static void main(String[] args) {
        Personagem[] equipe = new Personagem[3];
        equipe[0]= new Guerreiro("Thorin", 120, 15, 5, 3);
        equipe[1]= new Mago("Merlin", 70, 12, 2, 30);
        equipe[2] = new Arqueiro("Legolas", 85, 13, 3, 0);

        Personagem dragao= new Personagem("Dragão", 500, 60, 10);

        dragao.atacar(equipe[0]);

        for(Personagem p : equipe){
            usarHabilidade(p, equipe);

        }
        
    }

    public static void usarHabilidade(Personagem p, Personagem[] equipe) {
    if (p instanceof Mago mago) {
        
        int indiceAlvo = -1;

        for (int i = 0; i < equipe.length; i++) {
            if (equipe[i].estaVivo() && equipe[i].getVida() < equipe[i].getVidaMaxima()) {
                
                if (indiceAlvo == -1 || equipe[i].getVida() < equipe[indiceAlvo].getVida()) {
                    indiceAlvo = i;
                }
            }
        }
        if (indiceAlvo != -1) {
            mago.curarAliado(equipe[indiceAlvo]);
        }

    } else if (p instanceof Arqueiro arqueiro) {
        arqueiro.recarregar();

    } else if (p instanceof Guerreiro guerreiro) {
        guerreiro.gritoDeGuerra();
    }
}

}


