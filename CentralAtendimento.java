public class CentralAtendimento {

    private PilhaPrioridade pendentes;
    private PilhaProcesso historico;

    public CentralAtendimento() {
        pendentes = new PilhaPrioridade();
        historico = new PilhaProcesso();
    }

    public void abrirProcesso(Processo p) {
        pendentes.push(p);
        historico = new PilhaProcesso();
    }

    public void atenderProximo() {
        Processo p = pendentes.pop();
        historico.push(p);
        System.out.println("Atendido: " + p);
    }

    public void desfazerUltimoAtendimento() {
        if (historico.estaVazia()) {
            throw new PilhaVaziaException("Nada para desfazer!");
        }

        Processo p = historico.pop();
        pendentes.push(p);
        System.out.println("Desfeito: " + p);
    }

    public void listarPendentes() {
        pendentes.listar();
    }

    public void listarHistorico() {
        historico.imprimir();
    }
}
