
/** Classe raiz. Gera o elemento "carta", o qual possui um inteiro
 * @author Maurilio M Meireles*/

public class Carta {

    private int valor;
    /* 1 a 13   -   Ouros
    *  14 a 26  -   Epadas
    *  27 a 39  -   Copas
    *  40 a 52* -   Zap/Paus
    **/

    private static Random r = new Random();

    /**Gera um valor aleatorio entre 0 e 51 e armazena no valor da classe Carta
     * @return o valor armazenado na 'Carta'.*/
    public int trocar(){
        this.valor = r.getIntRand(52);
        return valor;
    }

    /**Getter do valor da carta.
     * @return o valor armazenado em 'Carta'.*/
    public int getCarta(){
        return this.valor;
    }

    /**Quando a classe Carta eh impressa em forma de string, ela deve mostrar um retangulo
     * com seu valor dentro.
     **/
    @Override
    public String toString(){
        return "+-----+" +
                "|     |" +
                "| "+valor+" |" +
                "|     |" +
                "+-----+";
    }

}
