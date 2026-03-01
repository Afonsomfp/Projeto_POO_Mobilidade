/**
 * Classe que representa um veículo elétrico na UCMobility
 * Para além dos dados herdados da classe VeículoAluguer, o veículo elétrico também possui o respetivo nível de bateria
 */

public class VeiculoEletrico extends VeículoAluguer{
    /** Nível de bateria atual do veículo */
    private int nivelBateria;

    /** Construtor vazio */
    public VeiculoEletrico() {}
    /**
     * Construção do veículo elétrico com o nível atual de bateria, número inteiro identificador do veículo, localização atual do veículo
     * @param identificador número inteiro identificador do veículo (4 dígitos)
     * @param localizacaoAtual localização atual do veículo (nome da rua)
     * @param nivelBateria nível de bateria atual do veículo
     */
    public VeiculoEletrico(int identificador, String localizacaoAtual, int nivelBateria) {
        super(identificador, localizacaoAtual);
        this.nivelBateria = nivelBateria;
    }

    /**
     * Devolve o nível atual de bateria do veículo elétrico 
     * @return nível atual de bateria do veículo elétrico 
     */
    public int getNivelBateria() {
        return nivelBateria;
    }

    /**
     * Define o nível atual de bateria do veículo elétrico 
     * @param nivelBateria nível atual de bateria do veículo elétrico 
     */
    public void setNivelBateria(int nivelBateria) {
        this.nivelBateria = nivelBateria;
    }
}
