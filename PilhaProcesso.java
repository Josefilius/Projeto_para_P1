public class PilhaProcesso {

    private VetorDinamico vetor;

    public PilhaProcesso() {
        vetor = new VetorDinamico();
    }

    public void push(Processo p) {
        vetor.adicionar(p);
    }

    public Processo pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha vazia!");
        }
        return vetor.remover();
    }

    public Processo peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha vazia!");
        }
        return vetor.get(vetor.tamanho() - 1);
    }

    public boolean estaVazia() {
        return vetor.tamanho() == 0;
    }

    public int tamanho() {
        return vetor.tamanho();
    }

    public void imprimir() {
        System.out.println("Topo -> Base");
        for (int i = vetor.tamanho() - 1; i >= 0; i--) {
            System.out.println(vetor.get(i));
        }
    }
}
