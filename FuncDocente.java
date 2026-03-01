import java.util.Arrays;

/**
 * Classe que representa um funcionário docente da UCMobility
 * Para além dos dados herdados das classes Funcionário e Utilizador, o funcionário docente também tem associada uma lista de faculdades onde leciona
 */

public class FuncDocente extends Funcionario {
    /** Lista das faculdades onde o funcionário docente leciona */
    private String[] faculdades;

    /** Construtor Vazio */
    public FuncDocente(){}
    /**
     * Construção do funcionário docente com a lista das faculdades onde leciona, ano em que o seu contrato começou, número mecanográfico e método de pagamento
     * @param faculdades lista das faculdades onde o docente leciona
     * @param anoContrato ano em que o seu contrato começou (vem da super classe)
     * @param numMecanografico número mecanográfico do docente (vem da super classe)
     * @param cartaoCredito método de pagamento do docente (vem da super classe)
     */
    public FuncDocente(String[] faculdades, int anoContrato, int numMecanografico,  boolean cartaoCredito) {
        super(anoContrato, numMecanografico, cartaoCredito);
        this.faculdades = faculdades;
    }

    /**
     * Devolve a lista das faculdades onde o docente leciona
     * @return lista das faculdades onde o docente leciona
     */
    public String[] getFaculdades() {
        return faculdades;
    }

    /**
     * Define a lista das faculdades onde o docente leciona
     * @param faculdades lista das faculdades onde o docente leciona
     */
    public void setFaculdades(String[] faculdades) {
        this.faculdades = faculdades;
    }

    /**
     * Informa que este utilizador é um funcionário docente
     * @return "Funcionário Docente" informando que este utilizador é um funcionário docente
     */
    
    public String getUtilizadorTipo() {
        return "Funcionario Docente";
    }

    /**
     * Apresentação das informações do funcionário docente definidas em texto simples
     * @return texto com os dados principais do funcionário docente
     */
    @Override
    public String toString(){
        return "Funcionario Docente{ faculdades=" + Arrays.toString(faculdades) + ", Ano contrato=" + getAnoContrato() + ", nº mecanografico=" + getNumMecanografico() + '}';
    }
}
