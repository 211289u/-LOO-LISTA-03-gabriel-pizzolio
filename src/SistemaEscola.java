import java.util.ArrayList;
import java.util.Scanner;

public class SistemaEscola {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Aluno> alunosCadastrados = new ArrayList<>();
    private ArrayList<Turma> turmasCadastradas = new ArrayList<>();

    public void executar() {
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Criar Nova Turma");
            System.out.println("3. Inserir Aluno na Turma");
            System.out.println("4. Remover Aluno da Turma");
            System.out.println("5. Listar Alunos da Turma");
            System.out.println("6. Definir Idade de um Aluno");
            System.out.println("7. Remover Todos Alunos da Turma");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    criarTurma();
                    break;
                case 3:
                    inserirAlunoNaTurma();
                    break;
                case 4:
                    removerAlunoDaTurma();
                    break;
                case 5:
                    listarAlunosDaTurma();
                    break;
                case 6:
                    definirIdadeAluno();
                    break;
                case 7:
                    removerTodosAlunosDaTurma();
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

    public void criarTurma() {
        System.out.print("Digite o nome da nova turma: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o código da nova turma: ");
        String codigo = scanner.nextLine();

        Turma turma = new Turma(nome, codigo);
        turmasCadastradas.add(turma);
        System.out.println("Turma criada com sucesso!");
    }

    public void inserirAlunoNaTurma() {
        Turma turma = buscarTurmaPorCodigo();
        if (turma != null) {
            System.out.print("Digite o CPF do aluno a ser inserido: ");
            String cpf = scanner.nextLine();

            Aluno aluno = buscarAlunoPorCpf(cpf);
            if (aluno != null) {
                turma.adicionarAluno(aluno);
            } else {
                System.out.println("Aluno não encontrado. Certifique-se de que o aluno foi cadastrado.");
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    public void removerAlunoDaTurma() {
        Turma turma = buscarTurmaPorCodigo();
        if (turma != null) {
            System.out.print("Digite o CPF do aluno a ser removido: ");
            String cpf = scanner.nextLine();

            Aluno aluno = buscarAlunoPorCpf(cpf);
            if (aluno != null) {
                turma.removerAluno(aluno);
                System.out.println("Aluno removido da turma com sucesso.");
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    public void listarAlunosDaTurma() {
        Turma turma = buscarTurmaPorCodigo();
        if (turma != null) {
            turma.listarAlunos();
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    public void definirIdadeAluno() {
        System.out.print("Digite o CPF do aluno a ser editado: ");
        String cpf = scanner.nextLine();

        Aluno aluno = buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            System.out.print("Digite a idade do aluno: " + aluno.getNome() + ": ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            aluno.setIdade(idade);
            System.out.println(aluno.toString());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void removerTodosAlunosDaTurma() {
        Turma turma = buscarTurmaPorCodigo();
        if (turma != null) {
            System.out.println("Você tem certeza que deseja remover todos alunos da turma? 1. Sim 2. Não");
            int confirmacao = scanner.nextInt();
            scanner.nextLine();

            if (confirmacao == 1) {
                turma.removerTodosAlunos();
                System.out.println("Todos os alunos foram removidos da turma.");
            } else {
                System.out.println("Ação cancelada.");
            }
        } else {
            System.out.println("Turma não encontrada.");
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

    public Turma buscarTurmaPorCodigo() {
        System.out.print("Digite o código da turma: ");
        String codigo = scanner.nextLine();
        for (Turma turma : turmasCadastradas) {
            if (turma.getCodigo().equals(codigo)) {
                return turma;
            }
        }
        return null;
    }
}
