
/**
 * Classe responsável pela contabilizacao de pontos do jogador conforme a composicao
 * final das cartas em sua mao.
 * @author Maurilio M Meireles
 * */

public class Placar {

    private int dinheiro;
    private int bet;
    /**Construtor padrao - Inicia o jogo dando 200 de Crédito ao jogador.*/
    public Placar(){
        this.dinheiro = 200;
    }

    /**Getter do valor de dinheiro que o jogador possui.
     * @return o dinheiro que o jogador possui.*/
    public int getMoney(){
        return this.dinheiro;
    }

    /**Quando o jogador faz uma aposta, subtrai o valor da aposta de seu dinheiro atual e armazena o valor
     * da aposta feita.
     * @param x aposta feita pelo usuário.*/
    public void fazerAposta(int x){

        this.bet = x;
        this.dinheiro -= bet;
    }

    /**Determina a recompensa do jogador conforme a composicao das cartas em sua mao.
     *
     * @param cartas o valor das cartas na mao do jogador.
     *
     * @return o fator multiplicativo da aposta feita pelo jogador após a rodada.*/
    public int income(int[] cartas){

        /*Fazer um panorama das cartas e dos naipes*/
        int[] numero = new int[5];
        int[] naipe = new int[5];

        for(int i=0; i<5; i++){
            numero[i] = cartas[i]%13;
            naipe[i] = cartas[i]/13;
        }

        int[] pilhasnum = new int[13];
        int[] pilhasnaip = new int[4];

        for(int i=0; i<13; i++){
            pilhasnum[i] = 0;
        }

        for(int i=0; i<4; i++){
            pilhasnaip[i] = 0;
        }

        for(int i=0; i<5; i++){
            pilhasnum[numero[i]]++;
            pilhasnaip[naipe[i]]++;
        }

        // Dois pares

        // Trinca

        // Straight - 5 seguidas, naipes diferentes

        // Flush - 5 mesmo naipe, não seguidos

        // F U L L _ H O U S E - trinca + par

        //Quadra

        // Straight Flush - 5 seguidas, mesmo naipe

        // Royal Straight Flush - 10, J, Q, K, A mesmo naipe

        int par = 0;
        int trinca = 0;
        int quadra = 0;
        boolean sequencia = false;
        boolean seqflag = true;
        boolean flush = false;

        for(int i=0; i<13;i++){

            if(pilhasnum[i] == 2)par++;
            if(pilhasnum[i] == 3)trinca++;
            if(pilhasnum[i] == 4)quadra++;

            if(pilhasnum[i] <= 1){
                if (seqflag && !sequencia && pilhasnum[i] == 1){
                    int contadorn = 0;

                    for(int j =0; j<5; j++){
                        if(pilhasnum[(i+j)%13] == 1){
                            contadorn++;
                        }
                    }

                    if (contadorn == 5) {
                        sequencia = true;
                    }
                }
            }else{
                seqflag = false;
            }

        }

        for(int i=0; i<4;i++){
            if(pilhasnaip[i] == 5) {
                flush = true;
                break;
            }
        }

        if(par == 2){
            // Dois Pares
            System.out.print("Two Pairs!\n");
            return 1;

        }else if(par == 1 && trinca == 1){
            // FULL HOUSE
            System.out.print("FULL HOUSE!\n");
            return 20;

        }else if(trinca == 1){
            // Trinca
            System.out.print("Three of a Kind!\n");
            return 2;

        }else if(quadra == 1) {
            // Quadra
            System.out.print("Four of a kind!\n");
            return 50;

        }else if(sequencia && flush && (pilhasnum[7] == 0 && pilhasnum[8] == 1)){
            // Battle Royale Staight Flush
            System.out.print("ROYAL STRAIGHT FLUSH!\n");
            return 200;

        }else if(sequencia && flush){
            // Straight Flush
            System.out.print("Straight Flush!\n");
            return 100;

        }else if(sequencia){
            // Straight
            System.out.print("Straight!\n");
            return 5;

        }else if(flush){
            //Flush
            System.out.print("Flush!\n");
            return 10;

        }else{
            //Zé bosta
            System.out.print("Nadinha ¯\\_(ツ)_/¯\n");
            return 0;
        }
    }

    /**Adiciona a aposta feita pelo jogador multiplicada pela recompensa daquela rodada, ao montante de
     * créditos do jogador.
     *
     * @param premio o fator multiplicativo da aposta no calculo da recompensa.*/
    public void addToPlacar(int premio){
        this.dinheiro += (premio*bet);
    }

    /**Representa o dinheiro do jogador de forma basica ao imprimir o Placar em forma de string.*/
    @Override
    public String toString () {

        String money = "Seus Créditos:  $ "+dinheiro;
        return money;
    }
}
