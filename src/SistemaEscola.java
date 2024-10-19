import java.util.ArrayList;
import java.util.Scanner;

public class SistemaEscola {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Aluno> alunosCadastrados = new ArrayList<>();
    private Turma turma = new Turma("Turma A");

    public void executar() {
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Inserir Aluno na Turma");
            System.out.println("3. Remover Aluno da Turma");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    inserirAlunoNaTurma();
                    break;
                case 3:
                    removerAlunoDaTurma();
                    break;
                case 9:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 9);
    }

    public void cadastrarAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        Aluno aluno = new Aluno(nome, cpf);
        alunosCadastrados.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public void inserirAlunoNaTurma() {
        System.out.print("Digite o CPF do aluno a ser inserido: ");
        String cpf = scanner.nextLine();

        Aluno aluno = buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            turma.adicionarAluno(aluno);
        } else {
            System.out.println("Aluno não encontrado. Certifique-se de que o aluno foi cadastrado.");
        }
    }

    public void removerAlunoDaTurma() {
        System.out.print("Digite o CPF do aluno a ser removido: ");
        String cpf = scanner.nextLine();

        Aluno aluno = buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            turma.removerAluno(aluno);
            System.out.println("Aluno removido da turma com sucesso.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public Aluno buscarAlunoPorCpf(String cpf) {
        for (Aluno aluno : alunosCadastrados) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }
}
