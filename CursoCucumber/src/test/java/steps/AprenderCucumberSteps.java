package steps;

import io.cucumber.java.pt.*;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AprenderCucumberSteps {

    // Cenário 01
    @Dado("que criei o arquivo corretamente")
    public void queCrieiOArquivoCorretamente() {

    }

    @Quando("executa-lo")
    public void executaLo() {

    }

    @Entao("a especificacao deve finalizar com sucesso")
    public void aEspecificacaoDeveFinalizarComSucesso() {

    }

    // Cenário 02
    private Integer contador = 0;

    @Dado("que o valor do contador é {int}")
    public void queOValorDoContadorÉ(Integer valor) {
        contador = valor;
    }

    @Quando("eu incrementar em {int}")
    public void euIncrementarEm(Integer valor) {
       contador += valor;
    }

    @Então("o valor do contador será {int}")
    public void oValorDoContadorSerá(Integer valor) {
        Assert.assertEquals(valor, contador);
    }

    // Cenário 03

    Date entrega = new Date();

    @Dado("que a entrega é dia {data}")
    public void queAEntregaÉDia(Date data) {
        entrega = data;
    }

    @Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
    public void aEntregaAtrasarEmDias(Integer valor, String tempo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        if (tempo.equals("dias")) {
            cal.add(Calendar.DAY_OF_MONTH, valor);
        } else {
            cal.add(Calendar.MONTH, valor);
        }
        entrega = cal.getTime();
    }

    @Então("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void aEntregaSeráEfetuadaEm(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals(data, dataFormatada);
    }

    /**
     * Cenário 03, 04 e 05
     */

    @Dado("^que o ticket( especial)? é A.(\\d{3})$")
    public void queOTicketÉAF(String tipo, String arg) {

    }

    @E("que o valor da passagem é R$ {double}")
    public void queOValorDaPassagemÉR$(Double double1) {

    }

    @E("^que o nome do passageiro é \"(.{5,20})\"$")
    public void queONomeDoPassageiroÉ(String string) {

    }

    @E("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
    public void queOTelefoneDoPassageiroÉ(String telefone) {

    }

    @Quando("criar os steps")
    public void criarOsSteps() {

    }

    @Então("o teste vai funcionar")
    public void oTesteVaiFuncionar() {

    }

}
