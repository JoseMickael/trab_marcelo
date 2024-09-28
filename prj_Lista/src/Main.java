import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    private String titulo;
    private String descricao;

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return titulo + "\n    " + descricao;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\nLista de Tarefas:");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }

            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Editar título de uma tarefa");
            System.out.println("3. Editar descrição de uma tarefa");
            System.out.println("4. Deletar tarefa");
            System.out.println("5. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título da tarefa:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite a descrição da tarefa:");
                    String descricao = scanner.nextLine();
                    Tarefa novaTarefa = new Tarefa(titulo, descricao);
                    tarefas.add(novaTarefa);
                    break;

                case 2:
                    System.out.println("Digite o número da tarefa que deseja editar o título:");
                    int numEditarTitulo = scanner.nextInt();
                    scanner.nextLine();
                    if (numEditarTitulo > 0 && numEditarTitulo <= tarefas.size()) {
                        System.out.println("Digite o novo título:");
                        String novoTitulo = scanner.nextLine();
                        tarefas.get(numEditarTitulo - 1).setTitulo(novoTitulo);
                    } else {
                        System.out.println("Tarefa inválida!");
                    }
                    break;

                case 3:
                    System.out.println("Digite o número da tarefa que deseja editar a descrição:");
                    int numEditarDesc = scanner.nextInt();
                    scanner.nextLine();
                    if (numEditarDesc > 0 && numEditarDesc <= tarefas.size()) {
                        System.out.println("Digite a nova descrição:");
                        String novaDescricao = scanner.nextLine();
                        tarefas.get(numEditarDesc - 1).setDescricao(novaDescricao);
                    } else {
                        System.out.println("Tarefa inválida!");
                    }
                    break;

                case 4:
                    System.out.println("Digite o número da tarefa que deseja deletar:");
                    int numDeletar = scanner.nextInt();
                    if (numDeletar > 0 && numDeletar <= tarefas.size()) {
                        tarefas.remove(numDeletar - 1);
                    } else {
                        System.out.println("Tarefa inválida!");
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }
}
