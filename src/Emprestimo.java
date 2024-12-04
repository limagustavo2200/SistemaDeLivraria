import java.time.LocalDate;

public class Emprestimo {

    private int id;
    private static int contadorId = 1;
    private Livro livro;
    private String nomeUsuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;
}
