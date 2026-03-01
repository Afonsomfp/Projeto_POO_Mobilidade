/**
 * Classe que representa uma bicicleta na UCMobility
 * Para além dos dados herdados da classe VeículoAluguer, a bicicleta também pode ser para duas pessoas (duasPessoas = true) ou para uma pessoa (duasPessoas = false)
 * Nesta classe será possível definir o preço do aluguer por hora de uma bicicleta para estudantes, funcionários docentes/não docentes, quer seja a bicicleta para uma ou duas pessoas
 */

public class Bicicleta extends VeículoAluguer {
    /** Indica se a bicicleta é para duas pessoas (duasPessoas = true) ou para uma pessoa (duasPessoas = false) */
    private boolean duasPessoas;

    /** Construtor vazio */
    public Bicicleta() {}
    /**
     * Construção da bicicleta com a informação se é para uma ou duas pessoas, possuindo um número inteiro identificador da bicicleta e a localização atual da bicicleta
     * @param duasPessoas true se a bicicleta for para duas pessoas e false se a bicicleta for para uma pessoa
     * @param identificador número inteiro identificador da bicicleta (4 dígitos)
     * @param localizacaoAtual localização atual da bicicleta (nome da rua)
     */
    public Bicicleta(boolean duasPessoas, int identificador, String localizacaoAtual) {
        this.duasPessoas = duasPessoas;
        super(identificador, localizacaoAtual);
    }

    /**
     * Devolve se a bicicleta é para uma ou duas pessoas
     * @return true se a bicicleta é para duas pessoas e false se a bicicleta é para uma pessoa
     */
    public boolean getTipo() {
        return duasPessoas;
    }
    /**
     * Define se a bicicleta é para uma ou duas pessoas
     * @param duasPessoas true se a bicicleta é para duas pessoas e false se a bicicleta é para uma pessoa 
     */
    public void setTipo(boolean duasPessoas) {
        this.duasPessoas = duasPessoas;
    }

    /**
     * Preço por hora do aluguer da bicicleta para estudantes
     * Se duasPessoas = true o preço a pagar por hora pelo aluguer da bicicleta é 2,00 euros
     * Se duasPessoas = false o preço a pagar por horal pelo aluguer da bicicleta é 1,00 euros
     * @return preço por hora do aluguer de uma bicicleta para estudantes (se for para duas pessoas são 2 euros por hora e se for para uma pessoa é 1 euro)
     */
    public double getPrecoHoraEst(){
        if(duasPessoas == true){
            return 2;
        }
        else{
            return 1;
        }
    }

    /**
     * Preço por hora do aluguer da bicicleta para funcionários docentes/não docentes
     * Se duasPessoas = true o preço a pagar por hora pelo aluguer da bicicleta é 3,00 euros
     * Se duasPessoas = false o preço a pagar por horal pelo aluguer da bicicleta é 2,00 euros
     * @return preço por hora do aluguer de uma bicicleta para funcionários (se for para duas pessoas são 3 euros por hora e se for para uma pessoa são 2 euros)
     */
    public double getPrecoHoraFunc(){
        if(duasPessoas == true){
            return 3;
        }
        else{
            return 2;
        }
    }

    /**
     * Informa que este veículo de aluguer é uma bicicleta
     * @return "Bicicleta" informando que este veículo de aluguer é uma bicicleta
     */
    public String getVeiculo(){
        return "Bicicleta";
    }

    /**
     * Apresentação das informações da bicicleta definidas em texto simples
     * @return texto com os dados principais da bicicleta
     */
    @Override
    public String toString() {
        return "Bicicleta{ duasPessoas=" + duasPessoas + ", Identificador=" + getIdentificador() + ", localizacao inicial=" + getLocalizacaoAtual() + '}';
    }
}
