import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CentralAtendimento central = new CentralAtendimento();

        int opcao;

        do {
            System.out.println("\n1 - Abrir processo");
            System.out.println("2 - Atender próximo");
            System.out.println("3 - Desfazer último");
            System.out.println("4 - Listar pendentes");
            System.out.println("5 - Listar histórico");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcao) {

                    case 1:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Serviço: ");
                        String servico = sc.nextLine();

                        System.out.print("Prioridade (1-3): ");
                        int prioridade = sc.nextInt();
                        sc.nextLine();

                        Processo p = new Processo(nome, servico, prioridade);
                        p.setDataHora("21/04/2026 10:00");

                        central.abrirProcesso(p);
                        break;

                    case 2:
                        central.atenderProximo();
                        break;

                    case 3:
                        central.desfazerUltimoAtendimento();
                        break;

                    case 4:
                        central.listarPendentes();
                        break;

                    case 5:
                        central.listarHistorico();
                        break;
                }

            } catch (PilhaVaziaException e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);

        sc.close();
    }
}
