import java.io.Serializable;

/** 
 * Classe que repesenta um utilizador na UCMobility
 * As classes Estudante, FuncDocente e FuncNaoDocente são derivadas desta classe
 */

public class Utilizador implements Serializable {
    /** Número mecanográfico do utilizador */
    private int numMecanografico;

    /** Método de pagamento -> true para Cartão de Crédito e false para Referência Multibanco */
    private boolean cartaoCredito;

    /** Construtor vazio */
    public Utilizador() {}

    /** 
     * Construção do utilizador com número mecanográfico e método de pagamento
     * @param numMecanografico número mecanográfico do utilizador
     * @param cartaoCredito true para Cartão de Crédito e false para Referência Multibanco
     */
    public Utilizador(int numMecanografico,  boolean cartaoCredito) {
        this.numMecanografico = numMecanografico;
        this.cartaoCredito = cartaoCredito;
    }

    /**
     * Devolve o número mecanográfico do utilizador
     * @return numMecanografico do utilizador
     */
    public int getNumMecanografico() {
        return numMecanografico;
    }

    /**
     * Define o número mecanográfico
     * @param numMecanografico número mecanográfico do utilizador 
     */
    public void setNumMecanografico(int numMecanografico) {
        this.numMecanografico = numMecanografico;
    }

    /**
     * Devolve o método de pagamento
     * @return true para Cartão de Crédito e false para Referência Multibanco
     */
    public boolean getMetodo() {
        return cartaoCredito;
    }

    /**
     * Define o método de pagamento
     * @param cartaoCredito true para Cartão de Crédito e false para Referência Multibanco
     */
    public void setMetodo(boolean cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    /**
     * Devolve o tipo de utilizador
     * As classes Estudante, FuncDocente e FuncNaoDocente derivadas da classe utilizador devem devolver o seu próprio tipo
     * @return "Utilizador" por defeito
     */
    public String getUtilizadorTipo(){
        return "Utilizador";
    }
}
