package exemplo.stream.dao;

import exemplo.stream.model.Fatura;
import java.util.ArrayList;
import java.util.List;

public class FaturaDao {
    
    public List<Fatura> buscarFaturas() {
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(new Fatura("joao@gmail.com", 350.0, false));
        faturas.add(new Fatura("maria@gmail.com", 150.0, true));
        faturas.add(new Fatura("jose@hotmail.com", 290.0, false));
        return faturas;        
    }
}
