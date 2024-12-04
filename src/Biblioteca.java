import java.util.ArrayList;
import java.util.List;


public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();


    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public void listarTodosLivros() {
        livros.forEach( livro -> System.out.println(livro));
    }

    public List<Autor> listarAutores() {
        return autores;
    }

    public void  listarLivrosDisponiveis() {
        System.out.println("Livros disponíveis:");
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro);
            }
        }
    }

    public void realizarEmprestimo(int idLivro, String nomeUsuario) {
        for (Livro livro : livros) {
            if (livro.getId() == idLivro && livro.isDisponivel()) {
                livro.setDisponivel(false);
                System.out.println("O livro '" + livro.getTitulo() + "' foi emprestado com sucesso para " + nomeUsuario + "!");
                return;
            }
        }
        System.out.println("Livro não encontrado ou já emprestado.");
    }
}
