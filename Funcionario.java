/**
 * Classe que represnta um Funcionario na UCMobility
 * Para além dos dados herdados da classe Utilizador, o funcionário também possui o respetivo ano de contrato
 */
public class Funcionario extends Utilizador{
    /** Ano em que começou o contrato do funcionário */
    private int anoContrato;

    /** Construtor vazio */
    public Funcionario() {}

    /** 
     * Construção do utilizador com ano de contrato, número mecanográfico e método de pagamento 
     * @param anoContrato ano em que começou o contrato do utilizador
     * @param numMecanografico número mecanográfico (vem da super classe)
     * @param cartaoCredito método de pagamento (vem da super classe)
    */
    public Funcionario(int anoContrato, int numMecanografico,  boolean cartaoCredito) {
        this.anoContrato = anoContrato;
        super(numMecanografico, cartaoCredito);
    }

    /**
     * Devolve o ano em que começou o contrato do funcionário
     * @return ano que começou o contrato do funcionário
     */
    public int getAnoContrato() {
        return anoContrato;
    }

    /**
     * Define o ano em que começou o contrato do funcionário
     * @param anoContrato ano em que começou o contrato do funcionário
     */
    public void setAnoContrato(int anoContrato) {
        this.anoContrato = anoContrato;
    }
}
