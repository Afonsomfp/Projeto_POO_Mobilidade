import java.io.*;
import java.util.ArrayList;

/**
 * Classe responsável pela leitura dos ficheiros de texto, bem como a leitura e escrita do ficheiro de objetos
 */

public class Ficheiro {
    /**
     * Devolve o conteudo do ficheiro Utilizador.txt, num array em que cada indice
     * representa um utilizador
     * @return conteudo do ficheiro utilizador.txt
     */

    public ArrayList<String> lerFicheiroUtilizador(){
        ArrayList<String> ficheiro = new ArrayList<>();
        File f = new File("C:/Users/afons/OneDrive/Ambiente de Trabalho/Projeto_POO/src/utilizadores.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linha;
            while ((linha = br.readLine()) != null) {
                ficheiro.add(linha.trim());
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro de texto.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro de texto.");
        }
        return ficheiro;
    }

    /**
     * Devolve o conteudo do ficheiro veiculos.txt, num array em que cada indice
     * representa um veiculo
     * @return conteudo do ficheiro veiculo.txt
     */

    public ArrayList<String> lerFicheiroVeiculos(){
        ArrayList<String> ficheiro = new ArrayList<>();
        File f = new File("C:/Users/afons/OneDrive/Ambiente de Trabalho/Projeto_POO/src/veículos.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linha;
            while ((linha = br.readLine()) != null) {
                ficheiro.add(linha.trim());
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro de texto.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro de texto.");
        }
        return ficheiro;
    }

    /**
     * Devolve o conteudo do ficheiro alugueres.obj, num array em que cada indice
     * representa um aluguer
     * @return conteudo do ficheiro alugueres.obj
     */

    public ArrayList<Aluguer> lerFicheiroAluguer(){
        File f = new File("C:/Users/afons/OneDrive/Ambiente de Trabalho/Projeto_POO/src/alugueres.obj");
        ArrayList<Aluguer> alugueres = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                alugueres = (ArrayList<Aluguer>) ois.readObject();
            } catch (EOFException  eof) { //erro de End of File, ou seja, chegou ao fim do ficheiro
                System.out.println("Erro ao ler alugueres.obj.");
            }
            ois.close();
        } catch (FileNotFoundException ex) {
            /** Este erro aparece quando não existe o ficheiro
             * Logo, criamos um
             */
            System.out.println("Ficheiro não existe, a criar ficheiro...");
            String caminhoDoFicheiro = "C:/Users/afons/OneDrive/Ambiente de Trabalho/Projeto_POO/src/alugueres.obj";
            File ficheiro = new File(caminhoDoFicheiro);

            try {
                if(ficheiro.createNewFile()) {
                    System.out.println("Ficheiro criado com sucesso.\n");
                }
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao criar o ficheiro.");
            }
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
        return alugueres;
    }

    /**
     * Guarda a lista de alugueres no ficheiro alugueres.txt
     * @param alugueres lista de objetos Aluguer a guardar no ficheiro
     */

    public void guardarAlugueres(ArrayList<Aluguer> alugueres){
        File f = new File("C:/Users/afons/OneDrive/Ambiente de Trabalho/Projeto_POO/src/alugueres.obj");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(alugueres);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }
}