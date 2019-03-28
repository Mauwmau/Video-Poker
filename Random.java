import java.util.Calendar;

/** gerador simples de numeros aleatorios.
 *
 * @author delamaro*/

public class Random {

    private long p = 2147483648L;
    private long m = 843314861;
    private long a = 453816693;


    private long seed ; //  Semente


    /**Retorna um numero aleatorio no intervalo (0,1[
     *
     * @return o numero gerado*/
    public double getRand() {
        seed = (a + m * seed) % p;
        double d = seed; // Faz cast para double
        return d / p;
    }

    /**Retorna um valor inteiro no intervalo (0,max[
     *
     * @param max o valor limite para a geracao do numero inteiro
     *
     * @return o numero gerado*/
    public int getIntRand(int max)
    {
        double d = getRand() * max;
        return (int) d;
    }

    /**Permite alterar a semente de geracao de numeros aleatorios. Supostamente deve ser chamada antes de
     * iniciar a geracao, mas se for chamado a qualquer instante, reseta o valor da semante
     *
     * @param semente o valor da nova semente de geracao*/
    public void setSemente(int semente) {
        seed = semente;
    }

    /**Construtor que permite criar o gerador, especificando o valor inicial da semente.
     *
     * @param k o valor inicial da semente*/
    public Random(int k)
    {
        seed = k;
    }

    /**Construtor que usa uma semente aleatoria, adquerida usando o metodo Calendar.getTimeInMillis().*/
    public Random() {
        seed = Calendar.getInstance().getTimeInMillis() % p;
    }

}
