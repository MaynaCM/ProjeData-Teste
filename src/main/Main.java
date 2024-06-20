import java.time.LocalDate;
import java.math.BigDecimal;

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
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
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
