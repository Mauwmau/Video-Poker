import java.io.IOException;

/**
 * Classe principal do programa. Cuida do funcionamento do jogo, unindo
 * a parte de embaralhar cartas e pontuacao no placar.
 * @author Maurilio M Meireles*/

public class Poker {

    public static void main(String[] args)throws IOException {

        TrocaCartas hand = new TrocaCartas();
        Placar grana = new Placar();

        while(grana.getMoney() > 0) {
            System.out.print("\n\n");
            System.out.println(grana);
            System.out.print(" - - - Quanto deseja apostar  - - - \n");
            int playerBet = EntradaTeclado.leInt();
            if(playerBet == 0){
                System.out.print("It's Time to Stop!\n");
                break;
            }if(playerBet <= grana.getMoney()) {

                grana.fazerAposta(playerBet);

                int[] maoDoJogador;

                maoDoJogador = hand.shuffle();
                System.out.println(hand);

                int rodada = 0;

                while(rodada < 2) {

                    System.out.print(" - - - Quais cartas deseja trocar - - - \n");
                    String pegadenovo = EntradaTeclado.leString();

                    if (!(pegadenovo.equals("") || pegadenovo.equals("\n"))) {
                        maoDoJogador = hand.shuffle(pegadenovo);
                        System.out.println(hand);
                        rodada++;
                    }else{
                        rodada = 2;
                    }
                }

                int premio = grana.income(maoDoJogador);
                System.out.print("Voce conseguiu " + premio + "x pontos nesta rodada\n");

                grana.addToPlacar(premio);
                hand.voltaBaralho();
            }else{
                System.out.print("Voce não tem toda essa grana, irmão.\n");
            }

        }

        System.out.print("\n\t-=-=-= Resultado final =-=-=-\n\t\t");
        System.out.println(grana);

    }

}
