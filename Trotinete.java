/**
 * Classe que representa uma trotinete na UCMobility
 * Para além dos dados herdados da classe VeículoEletrico, a trotinete também pode ter ecrã LCD com mapa (comLCD = true) ou não ter ecrã LCD com mapa (comLCD = false)
 * Nesta classe será possível definir o preço do aluguer por hora de uma trotinete para estudantes, funcionários docentes/não docentes, quer tenha ecrã LCD com mapa ou não
 */

public class Trotinete extends VeiculoEletrico {
    /** Indica se a trotinete tem ecrã LCD com mapa (comLCD = true) ou não (comLCD = false) */
    private boolean comLCD;

    /** Construtor vazio */
    public Trotinete() {}

    /**
     * Construção da trotinete com a informação se tem ecrã LCD com mapa ou não, possuindo o nível atual de bateria, um número inteiro identificador da trotinete e a localização atual da trotinete
     * @param nivelBateria nível de bateria atual da trotinete
     * @param identificador número inteiro identificador da trotinete (4 dígitos)
     * @param localizacaoAtual localização atual da ebike (nome da rua)
     * @param comLCD true se tem ecrã LCD com mapa e false se não tem ecrã LCD com mapa
     */
    public Trotinete(int nivelBateria, int identificador, String localizacaoAtual, boolean comLCD) {
        super(identificador, localizacaoAtual, nivelBateria);
        this.comLCD = comLCD;
    }

    /**
     * Devolve true se tem ecrã LCD com mapa e false se não tem ecrã LCD com mapa
     * @return true se tem ecrã LCD com mapa e false se não tem ecrã LCD com mapa
     */
    public boolean getEcra() {
        return comLCD;
    }

    /**
     * Define se a trotinete tem ecrã LCD com mapa ou não
     * @param comLCD true se tem ecrã LCD com mapa e false se não tem ecrã LCD com mapa
     */
    public void setEcra(boolean comLCD) {
        this.comLCD = comLCD;
    }

    /**
     * Preço por hora do aluguer da trotinete para estudantes
     * Se comLCD = true o preço a pagar por hora pelo aluguer da trotinete são 1,10 euros
     * Se comLCD = false o preço a pagar por hora pelo aluguer da trotinete é 1,00 euro
     * @return preço por hora do aluguer de uma trotinete para estudantes (se tem ecrã LCD com mapa são 1,10 euros por hora e se não tem ecrã LCD com mapa é 1,00 euro por hora)
     */
    @Override
    public double getPrecoHoraEst() {
        if(comLCD == true){
            return 1.1;
        }
        else{
            return 1;
        }
    }

    /**
     * Preço por hora do aluguer da trotinete para funcionários docentes/não docentes
     * Se fixa = true o preço a pagar por hora pelo aluguer da ebike são 2,60 euros
     * Se fixa = false o preço a pagar por horal pelo aluguer da ebike são 2,50 euros
     * @return preço por hora do aluguer de uma ebike para funcionários (se tem ecrã LCD com mapa são 1,10 euros por hora e se não tem ecrã LCD com mapa é 1,00 euro por hora)
     */
    @Override
    public double getPrecoHoraFunc() {
        if(comLCD == true){
            return 2.6;
        }
        else{
            return 2.5;
        }
    }

    /**
     * Informa que este veículo de aluguer é uma trotinete
     * @return "Trotinete" informando que este veículo de aluguer é uma ebike
     */
    public String getVeiculo(){
        return "Trotinete";
    }

    /**
     * Apresentação das informações da trotinete definidas em texto simples
     * @return texto com os dados principais da trotinete
     */
    @Override
    public String toString(){
        return "Trotinete{ Nivel da bateria=" + getNivelBateria() + ", Identificador=" + getIdentificador() + ", Com LCD=" + comLCD + ", Localização inicial=" +  getLocalizacaoAtual() + '}';
    }
}