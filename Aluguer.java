import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Classe que representa um aluguer na UCMobility
 * Esta classe permite guardar todos os dados associados a um aluguer, nomeadamente o utilizador que o fez, o veículo escolhido, o início e o fim do aluguer e ainda os serviços adicionais que escolheu (opcionais)
 * Ao introduzir os dados a classe conseguirá determinar o preço total do aluguer
 */

public class Aluguer implements Serializable {
    /** Utilizador que está a fazer o aluguer */
    private Utilizador utilizador;

    /** Veículo escolhido pelo utilizador */
    private VeículoAluguer veiculo;

    /** Data e hora do início do aluguer */
    private LocalDateTime inicio;

    /** Data e hora do fim do aluguer (AAAA-MM-DDTHH:MM:SS)*/
    private LocalDateTime fim;

    /** Lista onde serão armazenados os serviços adicionais que o utilizador poderá adicionar */
    private ArrayList<ServicoAdicional> servicosAdicionais =  new ArrayList<ServicoAdicional>();

    /** Construtor vazio */
    public Aluguer() {}
    /**
     * Construção do aluguer com a informação do utilizador que o efetuou, veículo escolhido, início do aluguer, fim do aluguer e serviços adicionais (opcionais)
     * @param utilizador utilizador que está a efetuar o aluguer do veículo
     * @param veiculo veículo escolhido pelo utilizador para alugar
     * @param inicio data e hora do início do aluguer
     * @param fim data e hora do fim do aluguer
     * @param servicosAdicionais lista de serviços adicionais escolhidos pelo utilizador (opcinais)
     */
    public Aluguer(Utilizador utilizador, VeículoAluguer veiculo, LocalDateTime inicio, LocalDateTime fim, ArrayList<ServicoAdicional> servicosAdicionais) {
         this.utilizador = utilizador;
         this.veiculo = veiculo;
         this.inicio = inicio;
         this.fim = fim;
         this.servicosAdicionais = servicosAdicionais;
    }

    /**
     * Devolve o utilizador que efetuou o aluguer
     * @return utilizador que efetuou o aluguer
     */
    public Utilizador getUtilizador() {
        return utilizador;
    }

    /**
     * Define o utilizador que efetuou o aluguer
     * @param utilizador utilizador que efetuou o aluguer
     */
    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Devolve o veículo que foi alugado pelo utilizador
     * @return veículo alugado 
     */
    public VeículoAluguer getVeiculo() {
        return veiculo;
    }

    /**
     * Define o veículo que foi alugado pelo utilizador
     * @param veiculo veículo alugado
     */
    public void setVeiculo(VeículoAluguer veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * Devolve a data e hora do início do aluguer no formato AAAA-MM-DDTHH:MM:SS
     * @return data e hora do início do aluguer
     */
    public LocalDateTime getInicio() {
        return inicio;
    }

    /**
     * Define a data e hora do início do aluguer no formato AAAA-MM-DDTHH:MM:SS
     * @param inicio data e hora do início do aluguer
     */
    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    /**
     * Devolve a data e hora do fim do aluguer no formato AAAA-MM-DDTHH:MM:SS
     * @return data e hora do fim do aluguer
     */
    public LocalDateTime getFim() {
        return fim;
    }

    /**
     * Define a data e hora do fim do aluguer no formato AAAA-MM-DDTHH:MM:SS
     * @param fim data e hora do fim do aluguer
     */
    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    /**
     * Devolve a lista dos serviços adicionais escolhidos pelo utilizador (opcional)
     * @return serviços adicionais escolhidos pelo utilizador
     */
    public ArrayList<ServicoAdicional> getServicosAdicionais() {
        return servicosAdicionais;
    }
    
    /**
     * Define a lista dos serviços adicionais escolhidos pelo utilizador (opcional)
     * @param servicosAdicionais serviços adicionais escolhidos pelo utilizador
     */
    public void setServicosAdicionais(ArrayList<ServicoAdicional> servicosAdicionais) {
        this.servicosAdicionais = servicosAdicionais;
    }

    /**
     * Este método calcPreco() permite calcular o preço final do aluguer de acordo com os dados introduzidos (utilizador,veículo,início,fim,serviços adicionais)
     * 
     * Em primeiro é devolvido o preço por hora de acordo com o tipo de utilizador introduzido
     * De seguida é analisado o tempo do aluguer e é calculado o preço conforme o tempo:
     *  -> Se o aluguer tiver menos de 24 horas o preço a pagar é calculado por hora
     *  -> Se o aluguer tiver mais de 24 horas, cada dia irá corresponder ao preço de 8 horas
     *  -> Para os serviços adicionais, capacete e luz, o preço dos mesmos é cobrado por dia
     *  -> Os utilizadores do tipo Funcionário Não Docente terão um desconto de 50% no preço final do aluguer 
     * 
     * @return preço total a pagar pelo aluguer
     */
    public double calcPreco() {
        double valorHora = 0;
        boolean docente = true;
        double valorTotal = 0;
        
        if(utilizador.getUtilizadorTipo().equalsIgnoreCase("Estudante")){
            valorHora = veiculo.getPrecoHoraEst();
            docente = true;
        } else if (utilizador.getUtilizadorTipo().equalsIgnoreCase("Funcionario Não Docente")) {
            valorHora = veiculo.getPrecoHoraFunc();
            docente = false;
        } else if (utilizador.getUtilizadorTipo().equalsIgnoreCase("Funcionario Docente")) {
            valorHora = veiculo.getPrecoHoraFunc();
            docente = true;
        }
        long horas = Duration.between(inicio, fim).toHours();

        long dias = horas / 24;
        long horasRestantes = horas % 24;
        if(horas >= 24){
            valorTotal += dias * (8 * valorHora);
            valorTotal += horasRestantes * valorHora;
        } else {
            valorTotal += (horas * valorHora);
        }

        for(int i = 0; i < servicosAdicionais.size(); i++){
            if(servicosAdicionais.get(i) == ServicoAdicional.LUZ){
                if(horas % 24 == 0){
                    valorTotal += dias * 2.5;
                } else {
                    valorTotal += (dias + 1) * 2.5;
                }
            }
            if(servicosAdicionais.get(i) == ServicoAdicional.CAPACETE){
                if(horas % 24 == 0){
                    valorTotal += dias * 5;
                } else {
                    valorTotal += (dias + 1) * 5;
                }
            }
        }

        if(docente == false){
            valorTotal = valorTotal * 0.5;
        }

        return valorTotal;
    }

    /**
     * Apresentação das informações da bicicleta definidas em texto simples
     * @return texto com os dados principais da bicicleta
     */
    @Override
    public String toString() {
        return utilizador.toString() + "\n" + veiculo.toString() + "\nInicio do Aluguer e o fim:" + inicio.toString() + " | " + fim.toString() + "\nServiços adicionais=" + servicosAdicionais.toString() + "\nPreço total=" + calcPreco();
    }
}
