package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.example.model.Filme;
import org.example.model.NotaAluguel;
import org.example.model.TipoAluguel;
import org.example.service.AluguelService;
import org.example.utils.DateUtils;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

public class AlugarFilmeSteps {

    private Filme filme;
    private AluguelService aluguelService = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private TipoAluguel tipoAluguel;

    @Dado("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(Integer int1) {
        filme = new Filme();
        filme.setEstoque(int1);
    }

    @Dado("um filme")
    public void umFilme(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        filme = new Filme();
        filme.setEstoque(Integer.parseInt(map.get("estoque")));
        filme.setAluguel(Integer.parseInt(map.get("preco")));

        String tipo = map.get("tipo");
        tipoAluguel = tipo.equals("semanal") ?
                TipoAluguel.SEMANAL :
                tipo.equals("extendido") ?
                        TipoAluguel.EXTENDIDO :
                        TipoAluguel.COMUM;
    }

    @Dado("que o preço do aluguel seja R$ {int}")
    public void queOPreçoDoAluguelSejaR$(Integer int1) {
        filme.setAluguel(int1);
    }

    @Quando("alugar")
    public void alugar() {
       try {
           nota = aluguelService.alugar(filme, tipoAluguel);
       } catch (RuntimeException e) {
           erro = e.getMessage();
       }
    }

    @Então("o preço do aluguel será R$ {int}")
    public void oPreçoDoAluguelSeráR$(int int1) {
        Assert.assertEquals(int1, nota.getPreco());
    }

    @Então("o estoque do filme será {int} unidade")
    public void oEstoqueDoFilmeSeráUnidade(int int1) {
        Assert.assertEquals(int1, filme.getEstoque());
    }

    @Então("não será possível por falta de estoque")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assert.assertEquals("Filme sem estoque", erro);
    }

    @Dado("^que o tipo do aluguel seja (.*)$")
    public void queOTipoDoAluguelSejaExtendido(String tipo) {
        tipoAluguel = tipo.equals("semanal") ?
                TipoAluguel.SEMANAL :
                tipo.equals("extendido") ?
                        TipoAluguel.EXTENDIDO :
                        TipoAluguel.COMUM;
    }

    @Então("^a data de entrega será em (\\d+) dias?$")
    public void aDataDeEntregaSeráEmDias(Integer int1) {
        Date dataEsperada = DateUtils.obterDataDiferencaDias(int1);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Então("a pontuação será de {int} pontos")
    public void aPontuaçãoSeráDePontos(Integer int1) {
       Assert.assertEquals(int1, nota.getPontuacao());
    }

}
