import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Adicionando autores e livros
        Autor autor1 = new Autor(1, "J.K. Rowling", LocalDate.of(1965, 7, 31));
        Autor autor2 = new Autor(2, "George R.R. Martin", LocalDate.of(1948, 9, 20));

        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);

        biblioteca.adicionarLivro(new Livro(1, "Harry Potter e a Pedra Filosofal", autor1));
        biblioteca.adicionarLivro(new Livro(2, "A Guerra dos Tronos", autor2));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBem-vindo à Biblioteca! Escolha uma opção:");
            System.out.println("1. Listar livros disponíveis");
            System.out.println("2. Adicionar um novo livro");
            System.out.println("3. Realizar empréstimo");
            System.out.println("4. Listar todos os livros");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                biblioteca.listarLivrosDisponiveis();

            } else if (opcao == 2) {
                // Listar autores
                System.out.println("Autores disponíveis:");
                for (Autor autor : biblioteca.listarAutores()) {
                    System.out.println(autor);
                }

                // Adicionar livro
                System.out.print("Digite o título do livro: ");
                String tituloLivro = scanner.nextLine();

                System.out.print("Digite o ID do autor: ");
                int idAutor = scanner.nextInt();
                scanner.nextLine();

                Autor autorSelecionado = null;
                for (Autor autor : biblioteca.listarAutores()) { // verificando o autor de acordo com seu id
                    if (autor.getId() == idAutor) {
                        autorSelecionado = autor;
                        break;
                    }
                }

                if (autorSelecionado != null) {
                    int idLivro = biblioteca.listarLivros().size() + 1; // Gerar ID para o novo livro
                    Livro novoLivro = new Livro(idLivro, tituloLivro, autorSelecionado);
                    biblioteca.adicionarLivro(novoLivro);
                    System.out.println("Livro '" + tituloLivro + "' adicionado com sucesso!");
                } else {
                    System.out.println("Autor não encontrado.");
                }


            } else if (opcao == 3) {
                System.out.print("Digite o ID do livro que deseja emprestar: ");
                int idLivro = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha
                System.out.print("Digite seu nome: ");
                String nomeUsuario = scanner.nextLine();
                biblioteca.realizarEmprestimo(idLivro, nomeUsuario);

            } else if (opcao == 4) {
                System.out.println("Lista com todos os livros: ");
                biblioteca.listarTodosLivros();
                break;

            } else if (opcao == 5) {
                System.out.println("Sistema encerrado. Até mais!");
                break;

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}