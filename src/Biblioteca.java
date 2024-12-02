import java.util.ArrayList;
import java.util.List;

public class Biblioteca implements Gerenciavel<Livro> {
    private List<Livro> livros = new ArrayList<>();
    private List<Membro> membros = new ArrayList<>();

    public void adicionar(Livro livro) {
        livros.add(livro);
    }

    public void remover(Livro livro) {
        livros.remove(livro);
    }

    public List<Livro> listar() {
        return livros;
    }

    public void adicionarMembro(Membro membro) {
        membros.add(membro);
    }

    public void listarMembros() {
        membros.forEach(System.out::println);
    }

    public Livro buscarLivro(String titulo) {
        return livros.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo) && livro.isDisponivel())
                .findFirst()
                .orElse(null);
    }

    public Membro buscarMembro(String nome) {
        return membros.stream()
                .filter(membro -> membro.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }
}