package exemplo.stream.main;

import exemplo.stream.model.Fatura;
import exemplo.stream.dao.FaturaDao;
import java.util.List;

public class ExemploStream2 {

    public static void main(String[] args) {
        
        List<Fatura> faturas = new FaturaDao().buscarFaturas();

        /* Multiplica a propriedade valor de cada item do stream por 2. */
        faturas.stream()
                .map(f -> f.getValor() * 2)
                .forEach(f -> System.out.println(f));
        
        /* A propriedade valor da lista original nao foi alterada. */
        for (Fatura f : faturas) {
            System.out.println(f.getValor());
        }
    }
}
