public class Emprestimo {
    private Livro livro;
    private Membro membro;

    public Emprestimo(Livro livro, Membro membro) {
        this.livro = livro;
        this.membro = membro;
        livro.setDisponivel(false);
    }

    @Override
    public String toString() {
        return "Livro: " + livro.getTitulo() + " | Emprestado para: " + membro.getNome();
    }
}