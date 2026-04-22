public class VetorDinamico {

    private Processo[] dados;
    private int tamanho;
    private int capacidadeInicial;

    public VetorDinamico() {
        this(4);
    }

    public VetorDinamico(int capacidade) {
        dados = new Processo[capacidade];
        capacidadeInicial = capacidade;
        tamanho = 0;
    }

    public void adicionar(Processo p) {
        if (tamanho == dados.length) {
            redimensionar(dados.length * 2);
        }
        dados[tamanho++] = p;
    }

    public Processo remover() {
        if (tamanho == 0) return null;

        Processo removido = dados[--tamanho];
        dados[tamanho] = null;

        if (tamanho > 0 && tamanho < dados.length * 0.25 && dados.length > capacidadeInicial) {
            redimensionar(dados.length / 2);
        }

        return removido;
    }

    private void redimensionar(int novaCapacidade) {
        Processo[] novo = new Processo[novaCapacidade];

        for (int i = 0; i < tamanho; i++) {
            novo[i] = dados[i];
        }

        dados = novo;
    }

    public void listar() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println((i + 1) + " - " + dados[i]);
        }
    }

    public int buscarPorProtocolo(int protocolo) {
        for (int i = 0; i < tamanho; i++) {
            if (dados[i].getProtocolo() == protocolo) {
                return i;
            }
        }
        return -1;
    }

    public int tamanho() {
        return tamanho;
    }

    public int capacidade() {
        return dados.length;
    }

    public Processo get(int index) {
        if (index >= 0 && index < tamanho) {
            return dados[index];
        }
        return null;
    }
}
