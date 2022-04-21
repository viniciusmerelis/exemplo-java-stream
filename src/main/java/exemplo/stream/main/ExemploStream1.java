package exemplo.stream.main;

import exemplo.stream.dao.FaturaDao;
import exemplo.stream.model.Fatura;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploStream1 {

    public static void main(String[] args) {
        
        List<Fatura> faturas = new FaturaDao().buscarFaturas();

        /* Utilizando Stream */
        faturas.stream()
                .filter(Fatura::estaEmRisco)
                .forEach(fatura -> System.out.println("Faturas acima de R$250,00. Usuario: " + fatura.getEmail()));

        /* Cria uma nova coleção de faturas que foram filtradas da coleção original.
            faturasNaoPagas aponta para a coleção faturas(coleção original). */
        List<Fatura> faturasNaoPagas = faturas.stream()
                .filter(fatura -> !fatura.isPago())
                .collect(Collectors.toList());
        
        faturasNaoPagas.stream()
                .forEach(fatura -> System.out.println("Fatura do usuário " + fatura.getEmail() + " foi paga? " + fatura.isPago()));
        
        /* Altera a propriedade 'pago' para true de cada item de faturas. */
        faturas.stream()
                .filter(fatura -> fatura.isPago() == false)
                .forEach(fatura -> {
                    fatura.setPago(true);
                    System.out.println("Fatura atualizada do usuario: " + fatura.getEmail());
                });

        /* A propriedade 'pago' da coleção de faturasNaoPagas agora é true, mesmo que essa propriedade foi
            alterada na coleção faturas. Isso ocorre porque as duas estão apontando para o mesmo endereço de Fatura. */
        faturasNaoPagas.stream()
                .forEach(fatura -> System.out.println("Faturas não pagas agora estão pagas? " + fatura.isPago()));
    }
}
