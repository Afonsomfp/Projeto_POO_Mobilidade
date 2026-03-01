  Este projeto teve como objetivo o desenvolvimento de um serviço de Mobilidade para estudantes e funcionários poderem alugar bicicletas, trotinetes eléctricas e e-bikes. Estes alugueres são faturados com base no 
tempo de utilização e podem incluir serviços adicionais, como um capacete ou uma luz. Também vale relembrar que diferentes tipos de utilizadores (estudante, funcionário) beneficiam de regras de preço distintas. 
Para tal, foi necessário o desenvolvimento de certas funcionalidades, como o carregamento dos utilizadores e veículos através de um ficheiro de texto, bem como o carregamento dos alugueres através de um ficheiro 
de objetos (caso exista). Após estes carregamentos e através da solicitação de certos parâmetros ao utilizador, foi possível o desenvolvimento da funcionalidade para criar o aluguer e para listar o mesmo, bem como
todos os produzidos anteriormente. Para terminar, construímos a funcionalidade para exportar todos os alugueres para um ficheiro de objetos, já criado/lido no carregamento dos mesmos através desse mesmo ficheiro.

  - Classe Utilizador e respectivas subclasses: A classe Utilizador é uma super classe que define os atributos número mecanográfico e localização atual, ambos comuns a todos os objetos deste mesmo tipo no sistema.
Desta forma, é possível referenciar qualquer utilizador de forma genérica na classe UCMobility. Através desta superclasse, produzimos as classes Estudante e Funcionário que vão herdar os seus atributos e métodos.
Além disso, a classe Funcionario adiciona também o atributo ano contrato, comum a todos os utilizadores deste tipo. De seguida esta classe subdivide-se ainda nas classes Funcionário docente e não docente que
incluem os atributos faculdades, comum a todos os funcionários docentes, e serviço de trabalho, comum a todos os funcionários não docentes. A organização hierárquica definida permite fazer o uso correto do
polimorfismo ao manipular utilizadores no programa, assim a referência do tipo Utilizador pode representar qualquer tipo específico (Estudante, Funcionário Docente e Funcionário Não Docente).

  - Classe VeículoAluguer e respectivas subclasses: A classe VeiculoAluguer é uma superclasse que estabelece os atributos comuns a todos os objetos do tipo veículo no sistema, nomeadamente o identificador e a
localização atual do mesmo. Desta forma, na classe UCMobility, é possível referenciar qualquer veículo de maneira geral. As classes Bicicleta e VeiculoEletrico são criadas a partir desta superclasse, herdando os
seus atributos e métodos. Para os veículos elétricos, a classe VeiculoEletrico adiciona o atributo nível de bateria, comum a todos os veículos desse tipo. De seguida esta classe é dividida novamente nas subclasses
Trotinete e Ebike, que incluem os atributos comLCD, comum a todas as Trotinetes, e fixa, comum a todas as ebikes. Através desta estrutura hierárquica é possível fazer o uso correto do polimorfismo ao lidar com
veículos no programa, assim a referência do tipo VeículoAluguer pode representar qualquer tipo específico (Bicicleta, Trotinete ou Ebike).

  - Classe Aluguer: Fazendo uso da classe Aluguer criamos um objeto desse mesmo tipo no nosso main, objeto esse que vai representar o aluguer de um veículo por um utilizador. Para fazer esse respectivo aluguer, a
classe começa por definir atributos essenciais para realizá-lo, como por exemplo, define o utilizador, o veículo, o início e fim do aluguer, e define também os serviços adicionais desejados pelo utilizador.
Estes atributos vão ser essenciais para executar uma das partes mais importantes deste projeto, o cálculo do custo do aluguer desejado. Neste método, começamos por verificar o tipo do utilizador, visto que poderá
aplicar-se um desconto de 50%. Após a verificação estar concluída, efetuamos os cálculos do número de horas totais do aluguer e realizamos a respetiva conta para obter o custo apenas do tempo utilizado, dependendo
do preço do tipo de veículo que estamos a lidar. De seguida, adicionamos ao valor do aluguer o custo dos serviços extras solicitados pelo utilizador, e para terminar o cálculo, como referido anteriormente,
verificamos o tipo de utilizador e se este é elegível para desconto.

  - Classe UCMobility e classe Ficheiro: Falando agora sobre o centro do meu projeto, a isto refiro me à classe UCMobility, assim que o programa é inicializado são chamados três métodos pertencentes à classe
Ficheiro: lerFicheiroUtilizador, lerFicheiroVeiculos e lerFicheiroAluguer. O método lerFicheiroUtilizador efetua a leitura correta do ficheiro de texto onde estão armazenadas as informações relativas aos
utilizadores, devolvendo uma lista com a informação dos mesmos. De forma semelhante, o método lerFicheiroVeiculos faz a leitura correta do ficheiro de texto onde estão armazenadas as informações relativas aos
veículos, devolvendo uma lista com a informação dos mesmos. O método lerFicheiroAluguer assegura e efetua a leitura correta do ficheiro de objetos, devolvendo uma lista com todos os alugueres já criados.
Por fim, sempre que for criado um novo aluguer, o método guardaAlugueres atualiza o ficheiro de objetos que contém a lista de todos os alugueres, garantindo que todos são gravados e que possam ser usados em
execuções futuras. Após a leitura dos ficheiros, questionamos o utilizador acerca dos seus dados, isto é, o nº mecanográfico, o id do veículo desejado, a forma de pagamento e o tempo de aluguer que ambiciona.
Logo em seguida a receber o tempo de aluguer pretendido, verificamos a disponibilidade do veículo neste período de tempo, visto que não podemos alugar o mesmo veículo ao mesmo tempo. Só após esta verificação, é
que obtemos, através dos arrays iniciais, os dados do veículo, bem como os do utilizador, que irão efetuar o aluguer. Em seguida, interrogamos o utilizador acerca do seu desejo por serviços adicionais, serviços
estes que apenas diferem numa bicicleta para duas pessoas, posto que esse aluguer pode requisitar dois capacetes, algo que não é comum no resto dos veículos.
Posteriormente, através do uso dos dados do veículo, bem como os do utilizador, criamos os respectivos objetos do tipo já definido nos ficheiros. Com isto, podemos executar a criação do aluguer, uma vez que já
temos todos os dados necessários para a sua criação. Para finalizar, inserimos esse aluguer criado anteriormente no array inicial de alugueres, expomos o custo total de todos os alugueres, e com isto podemos
encerrar o processo com a exportação dos alugueres para o ficheiro aluguer fazendo uso da função citada anteriormente.
