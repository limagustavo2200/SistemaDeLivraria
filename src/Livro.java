import java.time.LocalDate;

public class Livro {

    private int id;
    private String titulo;
    private Autor autor;
    private boolean disponivel;
    private LocalDate dataCadastrado;
    private LocalDate dataAtualizacao;

    public Livro( int id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastrado = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public LocalDate getDataCadastrado() {
        return dataCadastrado;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    // Setters
    public void atualizarData() {
        this.dataAtualizacao = LocalDate.now();
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Título: " + titulo + " | Autor: " + autor.getNome() +
                " | Disponível: " + (disponivel ? "Sim" : "Não");
    }
}

