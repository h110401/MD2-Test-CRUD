package Service;

import java.util.List;

public interface IGeneric<E> {

    List<E> finAll();

    void create(E element);

    void edit(E element);

    void delete(int index);

}