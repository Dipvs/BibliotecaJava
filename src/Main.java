import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        boolean executando = true;
        while (executando) {
            System.out.println("\n=== Sistema de Gerenciamento de Biblioteca ===");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Adicionar Membro");
            System.out.println("3 - Listar Livros");
            System.out.println("4 - Listar Membros");
            System.out.println("5 - Realizar Empréstimo");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            String entrada = scanner.nextLine();
            int opcao;

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite uma opção válida (1-6).");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    biblioteca.adicionar(new Livro(titulo, autor));
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome do membro: ");
                    String nome = scanner.nextLine();
                    biblioteca.adicionarMembro(new Membro(nome));
                    System.out.println("Membro adicionado com sucesso!");
                    break;

                case 3:
                    System.out.println("=== Livros Disponíveis ===");
                    biblioteca.listar().forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("=== Membros Cadastrados ===");
                    biblioteca.listarMembros();
                    break;

                case 5:
                    System.out.print("Digite o título do livro para empréstimo: ");
                    String livroTitulo = scanner.nextLine();
                    System.out.print("Digite o nome do membro: ");
                    String membroNome = scanner.nextLine();

                    Livro livro = biblioteca.buscarLivro(livroTitulo);
                    if (livro != null) {
                        Membro membro = biblioteca.buscarMembro(membroNome);
                        if (membro != null) {
                            new Emprestimo(livro, membro);
                            System.out.println("Empréstimo realizado com sucesso!");
                        } else {
                            System.out.println("Membro não encontrado.");
                        }
                    } else {
                        System.out.println("Livro não disponível.");
                    }
                    break;

                case 6:
                    executando = false;
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 6.");
            }
        }

        scanner.close();
    }
}
