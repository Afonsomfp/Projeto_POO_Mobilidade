/**
 * Classe que representa uma Ebike (bicicleta elétrica) na UCMobility
 * Para além dos dados herdados da classe VeículoEletrico, a ebike também pode ter bateria fixa (fixa = true) ou bateria removível (fixa = false)
 * Nesta classe será possível definir o preço do aluguer por hora de uma ebike para estudantes, funcionários docentes/não docentes, quer seja a bateria da ebike fixa ou não
 */

public class Ebike extends VeiculoEletrico {
    /** Indica se a bateria da ebike é fixa (fixa = true) ou removível (fixa = false) */
    private boolean fixa;

    /** Construtor vazio */
    public Ebike() {}
    /**
     * Construção da ebike com a informação se a bateria é fixa ou não, possuindo o nível atual de bateria, um número inteiro identificador da ebike e a localização atual da ebike
     * @param nivelBateria nível de bateria atual da ebike
     * @param identificador número inteiro identificador da ebike (4 dígitos)
     * @param localizacaoAtual localização atual da ebike (nome da rua)
     * @param fixa true se a bateria for removível e false se a bateria for fixa
     */
    public Ebike(int nivelBateria, int identificador, String localizacaoAtual, boolean fixa) {
        super(identificador, localizacaoAtual, nivelBateria);
        this.fixa = fixa;
    }

    /**
     * Devolve true se a bateria da ebike é fixa ou false se a bateria da ebike é removível
     * @return true se bateria é fixa e false se a bateria é removível
     */
    public boolean getBateria() {
        return fixa;
    }

    /**
     * Define se a bateria da ebike é fixa (true) ou se a bateria da ebike for removível (false) 
     * @param fixa true se bateria é fixa e false se a bateria é removível
     */     
    public void setBateria(boolean fixa) {
        this.fixa = fixa;
    }

    /**
     * Preço por hora do aluguer da ebike para estudantes
     * Se fixa = true o preço a pagar por hora pelo aluguer da ebike é 1,25 euros
     * Se fixa = false o preço a pagar por hora pelo aluguer da ebike é 1,50 euros
     * @return preço por hora do aluguer de uma ebike para estudantes (se a bateria for fixa são 1,25 euros por hora e se a bateria for removível são 1,50 euros por hora)
     */
    @Override
    public double getPrecoHoraEst(){
        if(fixa == true){
            return 1.25;
        }
        else{
            return 1.5;
        }
    }

    /**
     * Preço por hora do aluguer da ebike para funcionários docentes/não docentes
     * Se fixa = true o preço a pagar por hora pelo aluguer da ebike são 2,75 euros
     * Se fixa = false o preço a pagar por horal pelo aluguer da ebike são 3,00 euros
     * @return preço por hora do aluguer de uma ebike para funcionários (se a bateria for fixa são 2,75 euros por hora e se a bateria for removível são 3,00 euros por hora)
     */
    @Override
    public double getPrecoHoraFunc() {
        if(fixa == true){
            return 2.75;
        }
        else{
            return 3;
        }
    }

    /**
     * Informa que este veículo de aluguer é uma ebike
     * @return "Ebike" informando que este veículo de aluguer é uma ebike
     */
    public String getVeiculo(){
        return "Ebike";
    }

    /**
     * Apresentação das informações da ebike definidas em texto simples
     * @return texto com os dados principais da ebike
     */
    @Override
    public String toString(){
        return "Ebike{ Nivel da bateria=" + getNivelBateria() + ", Identificador=" + getIdentificador() + ", Bateria fixa=" + fixa + ", Localização inicial=" + getLocalizacaoAtual() + '}';
    }
}
