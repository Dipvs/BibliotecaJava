import java.util.List;

public interface Gerenciavel<T> {
    void adicionar(T item);
    void remover(T item);
    List<T>listar();
}
