/**
 * Classe que representa um funcionário não docente da UCMobility
 * Para além dos dados herdados da classe Funcionário e Utilizador, o funcionário não docente também tem associado o nome do serviço onde trabalha
 */

public class FuncNaoDocente extends Funcionario {
    /** Nome do serviço onde o funcionário não docente trabalha */
    private String servicoTrabalho;

    /** Construtor vazio */
    public FuncNaoDocente() {}
    /**
     * Construção do funcionário não docente com o nome do serviço onde trabalha, ano em que o seu contrato começou, número mecanográfico e método de pagamento
     * @param servicoTrabalho nome do serviço onde o funcionário não docente trabalha
     * @param anoContrato ano em que o seu contrato começou (vem da super classe)
     * @param numMecanografico número mecanográfico do docente (vem da super classe)
     * @param cartaoCredito método de pagamento do docente (vem da super classe)
     */
    public FuncNaoDocente(String servicoTrabalho, int anoContrato, int numMecanografico,  boolean cartaoCredito) {
        super(anoContrato, numMecanografico, cartaoCredito);
        this.servicoTrabalho = servicoTrabalho;
    }

    /**
     * Devolve o nome do serviço onde o funcionário não docente trabalha
     * @return nome do serviço onde o funcionário não docente trabalha
     */
    public String getServicoTrabalho() {
        return servicoTrabalho;
    }

    /**
     * Define o nome do serviço onde o funcionário não docente trabalha
     * @param servicoTrabalho nome do serviço onde o funcionário não docente trabalha
     */
    public void setServicoTrabalho(String servicoTrabalho) {
        this.servicoTrabalho = servicoTrabalho;
    }

    /**
     * Informa que este utilizador é um funcionário não docente
     * @return "Funcionário Não Docente" informando que este utilizador é um funcionário não docente
     */
    @Override
    public String getUtilizadorTipo() {
        return "Funcionario Não Docente";
    }

    /**
     * Apresentação das informações do funcionário não docente definidas em texto simples
     * @return texto com os dados principais do funcionário não docente
     */
    @Override
    public String toString(){
        return "Funcionario Não Docente{ Serviço no trabalho=" + servicoTrabalho + ", Ano contrato=" + getAnoContrato() + ", nº mecanografico=" + getNumMecanografico() + '}';
    }
}
