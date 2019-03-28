
/**Classe principal das Cartas. Permite que o jogador 5 cartas a mao,
 * embaralhar as cartas e devolve-las ao baralho
 * @author Maurilio M Meireles*/

public class TrocaCartas {

    private Carta[] mao = new Carta[5];
    private boolean[] baralho = new boolean[52];

    /**Construtor padrao - Inicia um baralho com TODAS as cartas, inicia o vetor de cartas da mao do usuario.*/
    public TrocaCartas(){
        for(int i=0; i<5; i++){
            this.mao[i] = new Carta();
        }
        for(int i = 0; i<52; i++){
            baralho[i] = true;
        }
    }

    /**Embaralha todas as cartas da mao do jogador.
     * @return o novo valor das cartas do jogador, apos terem sido embaralhadas*/
    public int[] shuffle(){
        int[] valores = new int[5];

        for(int i=0; i<5; i++){
            valores[i] = this.mao[i].trocar();
            if(baralho[valores[i]] == false){
                i--;
            }else{
                baralho[valores[i]] = false;
            }
        }

        return valores;
    }

    /**Embaralha apenas algumas cartas da mao do jogador, informadas como parametro
     * @param s string digitada pelo usuario, informando quais cartas de sua mao deseja trocar.
     * @return o valor das cartas do usuario apos as trocas, tanto as que foram trocadas quanto as mantidas.*/
    public int[] shuffle(String s){
        int[] valores = new int[5];

        String normalize = "";
        if(s.contains("1")){
            normalize +="1 ";
        }if(s.contains("2")){
            normalize +="2 ";
        }if(s.contains("3")){
            normalize +="3 ";
        }if(s.contains("4")){
            normalize +="4 ";
        }if(s.contains("5")){
            normalize +="5 ";
        }

        String[] limpa = normalize.split(" ");
        int tam = limpa.length;

        int[] aux = new int[tam];

        for(int i=0; i<tam; i++){
            aux[i] = Integer.parseInt(limpa[i]) -1 ;
        }

        for(int i=0; i<tam; i++){
            valores[aux[i]] = this.mao[aux[i]].trocar();
            if(baralho[valores[aux[i]]] == false){
                i--;
            }else{
                baralho[valores[aux[i]]] = false;
            }
        }

        for(int i=0; i<5; i++){
            valores[i] = mao[i].getCarta();
        }

        return valores;
    }

    /**Faz com que o baralho possua todas as cartas novamente, util ao fim da rodada.*/
    public void voltaBaralho(){
        for(int i=0; i<52; i++){
            this.baralho[i] = true;
        }
    }

    /**
     * Representacao das cartas na mao do usuario em forma de string. Mostram os valores das cartas ja processados,
     * estando entre A - K, e seus respectivos naipes.
     *
     *               */
    @Override
    public String toString () {

        String resultado = "===========================================================\n";
        resultado += "Sua Mão:\n\n";

          resultado += "+-----+\t\t+-----+\t\t+-----+\t\t+-----+\t\t+-----+\n";

        for(int i=0; i<=4; i++) {
            resultado +="|     |\t\t";
        }   resultado+="\n";

        for(int i=0; i<=4; i++) {
            int naipe = mao[i].getCarta()/13;

            int nro = mao[i].getCarta()%13;

            String numero;

            String simbolo = "X";

            switch (naipe){
                case 0:
                    simbolo = "\u2666";
                    break;

                case 1:
                    simbolo = "\u2664";
                    break;

                case 2:
                    simbolo = "\u2665";
                    break;

                case 3:
                    simbolo = "\u2667";
                    break;
            }

            switch (nro){
                case 9:
                    numero = "J";
                    break;

                case 10:
                    numero = "Q";
                    break;

                case 11:
                    numero = "K";
                    break;

                case 12:
                    numero = "A";
                    break;

                default:
                    int h = nro + 2;
                    numero = "" + h;
            }

            if(nro == 8) {
                resultado += "| "+numero+" "+simbolo+"|\t\t";
            }else{
                resultado += "| "+numero+" "+simbolo+" |\t\t";
            }
        }   resultado+="\n";

        for(int i=0; i<=4; i++) {
            resultado+="|     |\t\t";
        }   resultado+="\n";

        resultado+="+-----+\t\t+-----+\t\t+-----+\t\t+-----+\t\t+-----+\n" +
                "   1    \t   2    \t   3    \t   4    \t   5\n";

        resultado += "===========================================================\n";

        return resultado;
    }

}
