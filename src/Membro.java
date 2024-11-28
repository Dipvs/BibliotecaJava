public class Membro extends Pessoa {
    public Membro(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Membro: " + getNome();
    }
}
