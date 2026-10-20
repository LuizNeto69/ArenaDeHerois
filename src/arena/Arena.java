package arena;
import java.util.Scanner;
public class Arena {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Personagem[] herois= new Personagem[3];
        herois[0]= new Guerreiro("Thorin", 120, 15, 5, 3);
        herois[1]= new Mago("Merlin", 70, 12, 2, 40);
        herois[2] = new Arqueiro("Legolas", 85, 13, 3, 5);

        Personagem[] monstros = new Personagem[3];
        monstros[0] = new Personagem("Goblin", 40, 12, 2);
        monstros[1] = new Personagem("Orc", 80, 18, 4);
        monstros[2] = new Personagem("Troll", 140, 22, 6);

         int turno = 1;
        while (algumVivo(herois) && algumVivo(monstros)) {
            System.out.println("===== TURNO " + turno + " =====");
            mostrarTimes(herois, monstros);
 
            // vez de cada heroi vivo
            for (Personagem heroi : herois) {
                if (!algumVivo(monstros)) break;
                if (!heroi.estaVivo()) continue;
 
                System.out.println();
                int opcao;
                do {
                    System.out.println("Vez de " + heroi.status()
                            + ": 1) Atacar  2) Habilidade especial");
                    System.out.print("> ");
                    opcao = sc.nextInt();
                } while (opcao != 1 && opcao != 2);
 
                if (opcao == 1) {
                    Personagem alvo = escolherAlvo(monstros, sc);
                    heroi.atacar(alvo);
                } else {
                    usarHabilidade(heroi, herois, sc);
                }
            }
 
            // vez de cada monstro vivo
            System.out.println();
            for (Personagem monstro : monstros) {
                if (!algumVivo(herois)) break;
                if (!monstro.estaVivo()) continue;
                Personagem alvo = maisFraco(herois); // recalculado a cada ataque
                monstro.atacar(alvo);
            }
 
            turno++;
        }
 
        
        System.out.println();
        if (algumVivo(herois)) {
            System.out.println("VITORIA! Os herois venceram em " + (turno - 1) + " turnos.");
        } else {
            System.out.println("DERROTA... os monstros dominaram a arena.");
        }
    }
 
    
    public static boolean algumVivo(Personagem[] time) {
        for (Personagem p : time) {
            if (p.estaVivo()==true) return true;
        }
        return false;
    }
 

    public static void mostrarTimes(Personagem[] herois, Personagem[] monstros) {
        System.out.println("Herois:");
        for (int i = 0; i < herois.length; i++) {
            System.out.println("  " + i + ") " + herois[i].status());
        }
        System.out.println("Monstros:");
        for (int i = 0; i < monstros.length; i++) {
            System.out.println("  " + i + ") " + monstros[i].status());
        }
    }
 

    public static Personagem escolherAlvo(Personagem[] time, Scanner sc) {//select de personagem
        return escolherAlvo(time, sc, "Escolha o alvo (numero): ");
    }
 
    private static Personagem escolherAlvo(Personagem[] time, Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem + "> ");
            int i = sc.nextInt();
            if (i >= 0 && i < time.length && time[i].estaVivo()) {
                return time[i];
            }
        }
    }
 
    public static Personagem maisFraco(Personagem[] time) {
        Personagem fraco = null;
        for (Personagem p : time) {

            if (p.estaVivo() && (fraco == null || p.getVida() < fraco.getVida())) {
                fraco = p;
            }
        }
        return fraco;
    }
 
    public static void usarHabilidade(Personagem p, Personagem[] herois, Scanner sc) {
        if (p instanceof Guerreiro) {
            ((Guerreiro) p).gritoDeGuerra();
        } else if (p instanceof Mago) {
            Personagem aliado = escolherAlvo(herois, sc, "Escolha o aliado (numero): ");
            ((Mago) p).curarAliado(aliado);
        } else if (p instanceof Arqueiro) {
            ((Arqueiro )p).recarregar();
        }
    }

}
