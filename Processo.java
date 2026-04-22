public class Processo {

    private static int contador = 1;

    private int protocolo;
    private String solicitante;
    private String tipoServico;
    private int prioridade;
    private String dataHora;

    public Processo(String solicitante, String tipoServico, int prioridade) {
        this.protocolo = contador++;
        this.solicitante = solicitante;
        this.tipoServico = tipoServico;
        this.prioridade = prioridade;
    }

    public int getProtocolo() {
        return protocolo;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        String p = (prioridade == 3) ? "Urgente" :
                   (prioridade == 2) ? "Normal" : "Baixa";

        return String.format("[#%03d] %s | %s | %s | %s",
                protocolo, solicitante, tipoServico, p, dataHora);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Processo)) return false;

        Processo outro = (Processo) obj;
        return this.protocolo == outro.protocolo;
    }
}
