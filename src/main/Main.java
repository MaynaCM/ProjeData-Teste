import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.time.Month;
import java.util.*;


import classes.Funcionario;

public class Main {

    private static List<Funcionario> funcionarios = new ArrayList<>();

        public static void main(String[] args) {
            inicializarFuncionarios();
            try (Scanner scanner = new Scanner(System.in)) {
                boolean continuar = true;
                while (continuar) {
                    menuInicial();
                    int opcao = scanner.nextInt();
    
                    switch (opcao) {
                        case 1:
                            removerFuncionario();
                            break;
                        case 2:
                            exibirFuncionarios();
                            break;
                        case 3:
                            aplicarAumento();
                            break;
                        case 4:
                            agruparPorFuncao();
                            break;
                        case 5:
                            mostrarAniversariantes();
                            break;
                        case 6:
                            mostrarMaisVelho();
                            break;
                        case 7:
                            ordenarPorNome();
                            break;
                        case 8:
                            mostrarSalarioTotal();
                            break;
                        case 9:
                            break;
                        case 10:
                            System.out.println("Saindo...");
                            return;
                        default:
                            System.out.println("Opção inválida!");
                    }
    
                    continuar = perguntarSeDesejaContinuar(scanner);
                }
            }
            System.out.println("Obrigada!");
        }
    
    private static void menuInicial() {
        System.out.println("\nSistema de gerenciamento de funcionários - Teste Técnico Escolha uma opção:");
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Remover funcionário \"João\"");
        System.out.println("2 - Mostrar todos os funcionários");
        System.out.println("3 - Aplicar aumento de 10% a todos");
        System.out.println("4 - Agrupar e mostrar por função");
        System.out.println("5 - Mostrar aniversariantes dos meses 10 e 12");
        System.out.println("6 - Mostrar o funcionário mais velho");
        System.out.println("7 - Ordenar e mostrar funcionários por ordem alfabética");
        System.out.println("8 - Mostrar total dos salários");
        System.out.println("9 - Mostrar salários mínimos de cada funcionário");
        System.out.println("10 - Sair");
        System.out.print("\nOpção: ");
    }

    private static boolean perguntarSeDesejaContinuar(Scanner scanner) {
        System.out.println("\nDeseja continuar testando? (sim/não)");
        String resposta = scanner.next();
        return resposta.equalsIgnoreCase("sim");
    }

    private static void inicializarFuncionarios() {
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
    }

    private static void removerFuncionario() {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
        System.out.println("Funcionário 'João' removido.");
    }
    
    private static void exibirFuncionarios() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
        System.out.println("Funcionários Cadastrados:");
    
        for (Funcionario funcionario : funcionarios) {
            System.out.printf("Nome: %s, Data Nascimento: %s, Salário: %,.2f, Função: %s%n",
                    funcionario.getNome(), 
                    funcionario.getDataNascimento().format(formatter), 
                    funcionario.getSalario(), 
                    funcionario.getFuncao());
        }
    }

    private static void aplicarAumento() {
        for (Funcionario funcionario : funcionarios) {
            BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal("0.10"));
            funcionario.setSalario(funcionario.getSalario().add(aumento));
        }
        System.out.println("Aumento de 10% aplicado a todos os funcionários!!");
    }

    private static void agruparPorFuncao() {
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("\nFunção: " + entry.getKey());
            for (Funcionario funcionario : entry.getValue()) {
                System.out.printf("Nome: %s, Data Nascimento: %s, Salário: %,.2f, Função: %s%n",
                        funcionario.getNome(), 
                        funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
                        funcionario.getSalario(), 
                        funcionario.getFuncao());
            }
        }
    }

    private static void mostrarAniversariantes() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().getMonth() == Month.OCTOBER || 
                funcionario.getDataNascimento().getMonth() == Month.DECEMBER) {
                System.out.printf("Nome: %s, Data Nascimento: %s%n",
                        funcionario.getNome(), 
                        funcionario.getDataNascimento().format(formatter));
            }
        }
    }
    
    private static void mostrarMaisVelho() {
        Funcionario maisVelho = Collections.min(funcionarios, Comparator.comparing(Funcionario::getDataNascimento));
        LocalDate hoje = LocalDate.now();
        int idade = hoje.getYear() - maisVelho.getDataNascimento().getYear();
        if (hoje.getDayOfYear() < maisVelho.getDataNascimento().getDayOfYear()) {
            idade--;
        }
        System.out.printf("O funcionário mais velho é: Nome: %s, Idade: %d%n", maisVelho.getNome(), idade);
    }

    private static void ordenarPorNome() {
        List<Funcionario> funcionariosOrdenados = new ArrayList<>(funcionarios);
        funcionariosOrdenados.sort(Comparator.comparing(Funcionario::getNome));
        for (Funcionario funcionario : funcionariosOrdenados) {
            System.out.printf("Nome: %s%n", funcionario.getNome());
        }
    }
    
    private static void mostrarSalarioTotal() {
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("Valor total dos salários: %,.2f%n", totalSalarios);
    }
