package pacotecliente.clientescadastro.packagemain.main.util;

import java.util.List;

public interface Dao {
    void insert(Object o);
    void update(Object o);
    void delete(Object o);
    Object select(int i);
    List select();
}
