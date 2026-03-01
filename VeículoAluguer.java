import java.io.Serializable;

/**
 * Classe que representa um veículo que pode ser alugado no UCMobility
 * Guardamos os parâmetros comuns a todos os veículos: identificador e localização atual
 * As classes Bicicleta, Trotinete e Ebike são derivadas desta classe
 */

public class VeículoAluguer implements Serializable {
    /** Identificador do veículo com 4 dígitos */
    private int identificador;
    /**Localização atual do veículo (nome da rua) */
    private String localizacaoAtual;

    /**Construtor vazio */
    public VeículoAluguer(){}

    /** Construção do veículo que pode ser alugado possuindo um número inteiro identificador do veículo e a localização atual do veículo
     *@param identificador número inteiro identificador do veículo (4 dígitos)
     *@param localizacaoAtual localização atual do veículo (nome da rua)
     */
    public VeículoAluguer(int identificador, String localizacaoAtual) {
        this.identificador = identificador;
        this.localizacaoAtual = localizacaoAtual;
    }
    /**
     * Devolve o identificador do veículo
     * @return identificador do veículo (4 dígitos)
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Define o identificador do veículo
     * @param identificador identificador do veículo (4 dígitos)
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * Devolve a localização atual do veículo (nome da rua)
     * @return localizacaoAtual localização atual do veículo
     */
    public String getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    /**
     * Define a localização atual do veículo (nome da rua)
     * @param localizacaoAtual localização atual do veículo
     */
    public void setLocalizacaoAtual(String localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
    }

    /**
     * Preço do aluguer por hora para estudantes (inicializado a zero por padrão)
     * As classes descendentes correspondentes devem definir o valor do aluguer para Estudantes conforme o tipo de veículo
     * @return preço por hora para estudantes, 0 é o valor padrão que deve ser substituído na classe
     */
    public double getPrecoHoraEst(){
        return 0;
    }

    /**
     * Preço do aluguer por hora para funcionários (inicializado a zero por padrão)
     * As classes descendentes correspondentes devem definir o valor do aluguer para Funcionários Docentes/Funcionários Não Docentes conforme o tipo de veículo
     * @return preço por hora para funcionários, 0 é o valor padrão que deve ser substituído na classe
     */
    public double getPrecoHoraFunc(){
        return 0;
    }
}
