import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que representa o ponto principal do arranque do projeto
 * É nesta classe que são manipulados todos os dados, sendo establecida uma comunicação direta entre o programa e o utilizador através do terminal
 * Através desta comunicação recolhe-se os dados para efetuar o aluguer, desde pedir os dados do utilizador e do veículo até criar e guardar o aluguer no ficheiro de objetos, sendo no final mostrado a lsita de todos os alugueres efetuados
 */
public class UCMobility {
    /**
     * Método prinicipal onde ocorre todo o processo de leitura dos ficheiros, recolha dos dados do utilizador, criação dos respetivos objetos e cálculo do preço total de cada aluguer
     * 
     * 1. Leitura dos utilizadores, veículos e alugueres armazenados em ficheiro
     * 2. Requesição e verificação dos dados pedidos ao utilizador: número mecanográfico, id do veículo, método de pagamento, ínicio e fim do aluguer e serviços adicionais
     * 3. Verificação da disponibilidade do veículo requisitado para aluguer
     * 4. Verificação do tipo de veículo para adição de serviços: se for uma bicicleta para duas pessoas é possível adicionar até dois capacetes
     * 5. Criação do objeto do utilizador e do veículo conforme os dados corretos introduzidos (número mecanográfico e id do veículo)
     * 6. Criação do aluguer do veículo e calculo do preço total do aluguer conforme o definido no enunciado
     * 7. Inserção do aluguer na lista de alugueres e no ficheiro de objetos
     * 8. Impressão de todos os alugueres criados corretamente até ao momento
     * 
     * @param args argumentos da linha de comandos do terminal
     */

    public static void main(String[] args) {
        Ficheiro ficheiros = new Ficheiro();

        ArrayList<String> utilizadores = ficheiros.lerFicheiroUtilizador();
        ArrayList<String> veiculos =  ficheiros.lerFicheiroVeiculos();
        ArrayList<Aluguer> alugueres = ficheiros.lerFicheiroAluguer();

        int n_mecanografico;
        int ID_veiculo;
        boolean cartaoCredito;
        LocalDateTime inicio;
        LocalDateTime fim;
        ArrayList<ServicoAdicional> servicosAdicionais = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("Digite o número mecanografico: ");
        n_mecanografico = input.nextInt();
        System.out.println("Digite o ID do veiculo: (4 digitos)");
        ID_veiculo = input.nextInt();
        //verificaçao do numero de digitos
        String idVeiculoStr = String.valueOf(ID_veiculo);
        if(idVeiculoStr.length() != 4) {
            System.out.println("O ID do veiculo não tem 4 digitos");
            System.exit(0);
        }
        System.out.println("Forma de pagamento: Cartão Credito ou Referência Multibanco\nTrue para Cartão Credito | False para Referência Multibanco ");
        cartaoCredito = input.nextBoolean();

        input.nextLine();
        System.out.println("Introduza a hora do início: (AAAA-MM-DDTHH:MM:SS)");
        inicio = LocalDateTime.parse(input.nextLine());

        System.out.println("Introduza a hora do fim: (AAAA-MM-DDTHH:MM:SS)");
        fim = LocalDateTime.parse(input.nextLine());

        for(int i=0;i<alugueres.size();i++){
            if(alugueres.get(i).getVeiculo().getIdentificador() == ID_veiculo){
                LocalDateTime inicioAntigo = alugueres.get(i).getInicio();
                LocalDateTime fimAntigo = alugueres.get(i).getFim();

                if (inicio.isBefore(fimAntigo) && fim.isAfter(inicioAntigo)) {
                    System.out.println("Este veiculo encontra-se ocupado no tempo de aluguer desejado.");
                    System.exit(0);
                }
            }
        }

        String frase;
        String[] dadosUtilizador = null;
        for(int i=0;i<utilizadores.size();i++){
            frase = utilizadores.get(i);
            dadosUtilizador = frase.split(";");
            if(n_mecanografico == Integer.parseInt(dadosUtilizador[3])){
                break;
            }
        }

        String[] dadosVeiculo = null;
        for(int i=0;i<veiculos.size();i++){
            frase = veiculos.get(i);
            dadosVeiculo = frase.split(";");
            if(ID_veiculo == Integer.parseInt(dadosVeiculo[1])){
                break;
            }
        }

        String resposta, servico;
        int cont_cap = 0;
        if(dadosVeiculo[0].equalsIgnoreCase("Bicicleta") && Boolean.parseBoolean(dadosVeiculo[3]) == true){
            while (true){
                System.out.println("Deseja serviço adicional?");
                resposta = input.next();
                if(resposta.equalsIgnoreCase("Sim")) {
                    System.out.println("O que deseja - Capacete e/ou Luz");
                    servico = input.next();

                    if (servico.equalsIgnoreCase("Capacete")) {
                        if(cont_cap >= 2){
                            System.out.println("Capacete já foram adicionados 2 capacetes.");
                        }else{
                            servicosAdicionais.add(ServicoAdicional.CAPACETE);
                            cont_cap++;
                        }
                    }
                    else if (servico.equalsIgnoreCase("Luz")) {
                        if(servicosAdicionais.contains(ServicoAdicional.LUZ)){
                            System.out.println("Luz já foi adicionada");
                        }else{
                            servicosAdicionais.add(ServicoAdicional.LUZ);
                        }
                    }
                }else{
                    resposta = input.nextLine();
                    break;
                }
            }
        }else{
            while (true){
                System.out.println("Deseja serviço adicional?");
                resposta = input.next();
                if(resposta.equalsIgnoreCase("Sim")) {
                    System.out.println("O que deseja - Capacete e/ou Luz");
                    servico = input.next();

                    if (servico.equalsIgnoreCase("Capacete")) {
                        if(servicosAdicionais.contains(ServicoAdicional.CAPACETE)){
                            System.out.println("Capacete já foi adicionado");
                        }else{
                            servicosAdicionais.add(ServicoAdicional.CAPACETE);
                        }
                    }
                    else if (servico.equalsIgnoreCase("Luz")) {
                        if(servicosAdicionais.contains(ServicoAdicional.LUZ)){
                            System.out.println("Luz já foi adicionada");
                        }else{
                            servicosAdicionais.add(ServicoAdicional.LUZ);
                        }
                    }
                }else{
                    resposta = input.nextLine();
                    break;
                }
            }
        }

        Utilizador utilizador1 = null;
        if(dadosUtilizador[0].equalsIgnoreCase("Estudante")){
            if(dadosUtilizador[2].equalsIgnoreCase("POLO_I")){
                utilizador1 = new Estudante(dadosUtilizador[1],Polos.POLO_I,n_mecanografico,cartaoCredito);
            }
            else if(dadosUtilizador[2].equalsIgnoreCase("POLO_II")){
                utilizador1 = new Estudante(dadosUtilizador[1],Polos.POLO_II,n_mecanografico,cartaoCredito);
            }
            else if(dadosUtilizador[2].equalsIgnoreCase("POLO_III")){
                utilizador1 = new Estudante(dadosUtilizador[1],Polos.POLO_III,n_mecanografico,cartaoCredito);
            }
        }else if(dadosUtilizador[0].equalsIgnoreCase("Funcionario Docente")){
            String[] faculdades = dadosUtilizador[1].split(" ");
            utilizador1 = new FuncDocente(faculdades,Integer.parseInt(dadosUtilizador[2]),n_mecanografico,cartaoCredito);
        }else if(dadosUtilizador[0].equalsIgnoreCase("Funcionario Não Docente")){
            utilizador1 = new FuncNaoDocente(dadosUtilizador[1], Integer.parseInt(dadosUtilizador[2]), n_mecanografico, cartaoCredito);
        }

        VeículoAluguer veiculo1 = null;
        if(dadosVeiculo[0].equalsIgnoreCase("Bicicleta")){
            veiculo1 = new Bicicleta(Boolean.parseBoolean(dadosVeiculo[3]), ID_veiculo, dadosVeiculo[2]);
        }else if(dadosVeiculo[0].equalsIgnoreCase("Trotinete")){
            veiculo1 = new Trotinete(Integer.parseInt(dadosVeiculo[2]), ID_veiculo, dadosVeiculo[3], Boolean.parseBoolean(dadosVeiculo[4]));
        }else if(dadosVeiculo[0].equalsIgnoreCase("Ebike")) {
            veiculo1 = new Ebike(Integer.parseInt(dadosVeiculo[2]), ID_veiculo, dadosVeiculo[3], Boolean.parseBoolean(dadosVeiculo[4]));
        }

        Aluguer aluguer1 = new Aluguer(utilizador1,veiculo1,inicio,fim,servicosAdicionais);
        System.out.println("\n----------Novo Aluguer----------\n" + aluguer1.toString());

        alugueres.add(aluguer1);

        int valorTotalAlugueres = 0;

        System.out.println("\n----------Lista de Alugueres----------");
        for(int i=0;i<alugueres.size();i++){
            valorTotalAlugueres += alugueres.get(i).calcPreco();
            System.out.println(alugueres.get(i).toString());
            System.out.println();
        }
        System.out.println("Valor total dos alugueres=" +  valorTotalAlugueres);

        ficheiros.guardarAlugueres(alugueres);

        input.close();
    }
}
