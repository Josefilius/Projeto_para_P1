public class PilhaPrioridade {

    private PilhaProcesso urgente;
    private PilhaProcesso normal;
    private PilhaProcesso baixa;

    public PilhaPrioridade() {
        urgente = new PilhaProcesso();
        normal = new PilhaProcesso();
        baixa = new PilhaProcesso();
    }

    public void push(Processo p) {
        switch (p.getPrioridade()) {
            case 3:
                urgente.push(p);
                break;
            case 2:
                normal.push(p);
                break;
            case 1:
                baixa.push(p);
                break;
            default:
                System.out.println("Prioridade inválida!");
        }
    }

    public Processo pop() {
        if (!urgente.estaVazia()) {
            return urgente.pop();
        } else if (!normal.estaVazia()) {
            return normal.pop();
        } else if (!baixa.estaVazia()) {
            return baixa.pop();
        } else {
            throw new PilhaVaziaException("Nenhum processo na fila!");
        }
    }

    public Processo peek() {
        if (!urgente.estaVazia()) {
            return urgente.peek();
        } else if (!normal.estaVazia()) {
            return normal.peek();
        } else if (!baixa.estaVazia()) {
            return baixa.peek();
        } else {
            throw new PilhaVaziaException("Nenhum processo disponível!");
        }
    }

    public int tamanho() {
        return urgente.tamanho() + normal.tamanho() + baixa.tamanho();
    }

    public void listar() {
        System.out.println("\n--- URGENTES ---");
        urgente.imprimir();

        System.out.println("\n--- NORMAIS ---");
        normal.imprimir();

        System.out.println("\n--- BAIXA ---");
        baixa.imprimir();
    }

    public boolean estaVazia() {
        return tamanho() == 0;
    }
}
