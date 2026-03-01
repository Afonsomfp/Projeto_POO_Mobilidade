/**
 * Classe que representa um estudante na UCMobility
 * Para além dos dados herdados da classe Utilizador o estudante também possui o nome do curso em que está matriculado e o polo em que estuda
 */

public class Estudante extends Utilizador{
    /** Nome do curso em que está matriculado */
    private String nomeCurso;
    /** Polo que frequenta */
    private Polos polo;

    /** Construtor vazio */
    public Estudante() {}

    /** Construção do estudante com o nome do curso que está matriculado e polo que frequenta, número número mecanográfico e método de pagamento
     * @param nomeCurso curso que o estudante está matriculado 
     * @param polo polo que o estudante frequenta
     * @param numMecanografico número mecanografico (vem da super classe)
     * @param cartaoCredito método de pagamento (vem da super classe)
     */
    public Estudante(String nomeCurso, Polos polo, int numMecanografico, boolean cartaoCredito) {
        super(numMecanografico, cartaoCredito);
        this.nomeCurso = nomeCurso;
        this.polo = polo;
    }

    /**
     * Devolve o nome do curso que o estudante está matriculado
     * @return nome do curso que o estudante está matriculado 
     */
    public String getNomeCurso() {
        return nomeCurso;
    }

    /**
     * Define o nome do curso que o estudante está matriculado
     * @param nomeCurso nomde do curso que o estudante está matriculado
     */
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    /**
     * Devolve polo que o estudante frequenta
     * @return polo que o estudante frequenta
     */
    public Polos getPolo() {
        return polo;
    }

    /**
     * Define polo que o estudante frequenta
     * @param polo polo que o estudante frequenta
     */
    public void setPolo(Polos polo) {
        this.polo = polo;
    }

    /**
     * Informa que este utilizador é um Estudante
     * @return "Estudante" informando que este utilizador é Estudante
     */
    @Override
    public String getUtilizadorTipo() {
        return "Estudante";
    }

    /**
     * Apresentação das informações do estudante definidas em texto simples
     * @return texto com os dados principais do estudante
     */
    @Override
    public String toString() {
        return "Estudante{" + "nomeCurso=" + nomeCurso +  ", polo=" + polo + ", nº mecanografico=" + getNumMecanografico() + '}';
    }
}
