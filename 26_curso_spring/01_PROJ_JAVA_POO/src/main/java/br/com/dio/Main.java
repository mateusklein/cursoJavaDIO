package br.com.dio;

import br.com.dio.DAO.BootcampDAO;
import br.com.dio.DAO.CoursesDAO;
import br.com.dio.DAO.DevsDAO;
import br.com.dio.DAO.MentoringDAO;
import br.com.dio.Model.Bootcamp;
import br.com.dio.Model.Courses;
import br.com.dio.Model.Devs;
import br.com.dio.Model.Mentoring;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static BootcampDAO bootcampDAO = new BootcampDAO();
    public static DevsDAO devsDAO = new DevsDAO();
    public static CoursesDAO coursesDAO = new CoursesDAO();
    public static MentoringDAO mentoringDAO = new MentoringDAO();

    public static void main(String[] args) {
        //ADICIONANDO EXEMPLOS
        bootcampDAO.insertBootcamp(new Bootcamp("Bootcamp ciencia de dados", "aprendendo ciencia de dados com sql e python"));
        bootcampDAO.insertBootcamp(new Bootcamp("Bootcamp java dev", "aprendendo java do zero"));
        devsDAO.insertDev(new Devs("Mateus"));
        devsDAO.insertDev(new Devs("Carlos"));
        var course1 = new Courses("Modelo Entidade Relacionamento", "Aprendendo modelos de banco de dados", 20);
        var course2 = new Courses("Aprendendo SQL", "Lógica SQL", 10);
        var course3 = new Courses("Objetos banco de dados", "Views e functions", 15);
        var course4 = new Courses("Criacao de usuarios em sql", "SQL users", 7);
        var course5 = new Courses("Lógica programacao", "Logica programacao", 15);
        var course6 = new Courses("Estruturas repeticao em python", "Python loops", 5);
        var course7 = new Courses("Usando funcoes em java", "Aprendendo function", 5);
        var course8 = new Courses("POO com java", "Orientacao a objetos", 16);
        var mentoring1 = new Mentoring("Ciencia de dados no mercado de trabalho", "Importancia da ciencia de dados no mercado");
        var mentoring2 = new Mentoring("Python", "Mentoria de python");
        var mentoring3 = new Mentoring("MYSQL", "Mentoria de SQL usando MYSQL");
        var mentoring4 = new Mentoring("JAVA DEVS", "Mentoria de JAVA");
        var mentoring5 = new Mentoring("Praticando poo com java", "Pratica de poo com java");
        var bootcamp1 = bootcampDAO.getBootcamps().get(0);
        var bootcamp2 = bootcampDAO.getBootcamps().get(1);
        bootcamp1.getContents().add(course1);
        bootcamp1.getContents().add(course2);
        bootcamp1.getContents().add(course3);
        bootcamp1.getContents().add(course4);
        bootcamp1.getContents().add(course5);
        bootcamp1.getContents().add(course6);
        bootcamp2.getContents().add(course5);
        bootcamp2.getContents().add(course7);
        bootcamp2.getContents().add(course8);
        bootcamp1.getContents().add(mentoring1);
        bootcamp1.getContents().add(mentoring2);
        bootcamp1.getContents().add(mentoring3);
        bootcamp2.getContents().add(mentoring4);
        bootcamp2.getContents().add(mentoring5);
        devsDAO.getDevs().get(0).registeredBootcamp(bootcamp1);
        devsDAO.getDevs().get(1).registeredBootcamp(bootcamp2);

        var option = 0;
        do{
            System.out.println("\n1 - Criar um bootcamp");
            System.out.println("2 - Criar um dev");
            System.out.println("3 - Criar um curso");
            System.out.println("4 - Criar uma mentoria");
            System.out.println("5 - Adicionar dev ao bootcamp");
            System.out.println("6 - Adicionar curso ao bootcamp");
            System.out.println("7 - Adicionar mentoria ao bootcamp");
            System.out.println("8 - Progredir com usuario");
            System.out.println("9 - Verificar XP do usuario");
            System.out.println("10 - Ver informacoes de todos os bootcamps");
            System.out.println("11 - Ver informacoes de todos os devs");
            System.out.println("Digite -1 para sair");
            System.out.println("Digite a opcao desejada: ");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    createBootcamp();
                    break;
                case 2:
                    createDev();
                    break;
                case 3:
                    createCourse();
                    break;
                case 4:
                    createMentoring();
                    break;
                case 5:
                    addDevBootcamp();
                    break;
                case 6:
                    addCourseBootcamp();
                    break;
                case 7:
                    addMentoringBootcamp();
                    break;
                case 8:
                    progressDev();
                    break;
                case 9:
                    calcXP();
                    break;
                case 10:
                    viewBootcamp();
                    break;
                case 11:
                    viewDev();
                    break;
                default:
                    break;
            }
        }while (option != -1);
    }

    private static void viewDev() {
        if(devsDAO.getDevs().isEmpty()){
            return;
        }
        for(var dev : devsDAO.getDevs()){
            System.out.println("===============\n");
            System.out.printf("Nome: %s\n", dev.getName());
            System.out.printf("Conteudos inscritos: %s\n", dev.getRegisteredContents());
            System.out.printf("Conteudos finalizados: %s\n", dev.getFinishedContents());
            System.out.println("===============\n");
        }
    }

    public static void viewBootcamp() {
        if(bootcampDAO.getBootcamps().isEmpty()){
            return;
        }

        for(Bootcamp bootcamp : bootcampDAO.getBootcamps()){
            System.out.println("==============\n");
            System.out.printf("Nome: %s\n", bootcamp.getName());
            System.out.printf("Descricao: %s\n", bootcamp.getDescription());
            System.out.printf("Data de inicio: %s\n", bootcamp.getStartDate());
            System.out.printf("Data final: %s\n", bootcamp.getEndDate());
            System.out.printf("Conteúdos: %s\n", bootcamp.getContents());
            System.out.printf("Devs inscritos: %s\n", bootcamp.getDevs());
            System.out.println("==============\n\n");
        }
    }


    public static void addDevBootcamp(){
        if(bootcampDAO.getBootcamps().isEmpty() || devsDAO.getDevs().isEmpty()){
            return;
        }
        var i = 1;
        for(Bootcamp bootcamp : bootcampDAO.getBootcamps()){
            System.out.printf("%s - %s\n", i++, bootcamp.getName());
        }
        System.out.println("Selecione um bootcamp:");
        var numBootcamp = scanner.nextInt();
        i = 1;
        for(Devs dev : devsDAO.getDevs()){
            System.out.printf("%s - %s\n", i++, dev.getName());
        }
        System.out.println("Selecione um dev:");
        var numDev = scanner.nextInt();
        Bootcamp bootcamp = bootcampDAO.getBootcamps().get(numBootcamp-1);
        Devs dev = devsDAO.getDevs().get(numDev-1);
        dev.registeredBootcamp(bootcamp);
    }

    public static void addCourseBootcamp(){
        if(bootcampDAO.getBootcamps().isEmpty() || coursesDAO.getCourses().isEmpty()){
            return;
        }
        var i = 1;
        for(Bootcamp bootcamp : bootcampDAO.getBootcamps()){
            System.out.printf("%s - %s\n", i++, bootcamp.getName());
        }
        System.out.println("Selecione um bootcamp:");
        var numBootcamp = scanner.nextInt();
        i = 1;
        for(Courses course : coursesDAO.getCourses()){
            System.out.printf("%s - %s\n", i++, course.getTitle());
        }
        System.out.println("Selecione um curso:");
        var numCurso = scanner.nextInt();
        Bootcamp bootcamp = bootcampDAO.getBootcamps().get(numBootcamp-1);
        Courses course = coursesDAO.getCourses().get(numCurso-1);
        bootcamp.getContents().add(course);
    }

    public static void addMentoringBootcamp(){
        if(bootcampDAO.getBootcamps().isEmpty() || mentoringDAO.getMentorings().isEmpty()){
            return;
        }
        var i = 1;
        for(Bootcamp bootcamp : bootcampDAO.getBootcamps()){
            System.out.printf("%s - %s\n", i++, bootcamp.getName());
        }
        System.out.println("Selecione um bootcamp:");
        var numBootcamp = scanner.nextInt();
        i = 1;
        for(Mentoring mentoring : mentoringDAO.getMentorings()){
            System.out.printf("%s - %s\n", i++, mentoring.getTitle());
        }
        System.out.println("Selecione uma mentoria:");
        var numMentoria = scanner.nextInt();
        Bootcamp bootcamp = bootcampDAO.getBootcamps().get(numBootcamp-1);
        Mentoring mentoring = mentoringDAO.getMentorings().get(numMentoria-1);
        bootcamp.getContents().add(mentoring);
    }

    public static void progressDev(){
        if(devsDAO.getDevs().isEmpty()){
            return;
        }
        var i = 1;
        for(Devs dev : devsDAO.getDevs()){
            System.out.printf("%s - %s\n", i++, dev.getName());
        }
        System.out.println("Selecione um dev:");
        var numDev = scanner.nextInt();
        Devs dev = devsDAO.getDevs().get(numDev-1);
        if(dev.getRegisteredContents().isEmpty()){
            return;
        }
        dev.progredir();
    }

    public static void calcXP(){
        if(devsDAO.getDevs().isEmpty()){
            return;
        }
        var i = 1;
        for(Devs dev : devsDAO.getDevs()){
            System.out.printf("%s - %s\n", i++, dev.getName());
        }
        System.out.println("Selecione um dev:");
        var numDev = scanner.nextInt();
        Devs dev = devsDAO.getDevs().get(numDev-1);
        System.out.printf("Total de xp: %s", dev.calcTotalXp());
    }

    public static void createBootcamp() {
        System.out.println("Digite o nome do bootcamp: ");
        var name = scanner.next();
        System.out.println("Digite a descricao do bootcamp: ");
        var description = scanner.next();
        bootcampDAO.insertBootcamp(new Bootcamp(name, description));
    }

    public static void createDev() {
        System.out.println("Digite o nome do dev: ");
        var name = scanner.next();
        devsDAO.insertDev(new Devs(name));
    }

    public static void createCourse() {
        System.out.println("Digite o titulo do curso: ");
        var title = scanner.next();
        System.out.println("Digite o descricao do curso: ");
        var description = scanner.next();
        System.out.println("Digite a carga horaria do curso (inteiro): ");
        var hours = scanner.nextInt();
        coursesDAO.insertCourse(new Courses(title, description, hours));
    }

    public static void createMentoring() {
        System.out.println("Digite o titulo do curso: ");
        var title = scanner.next();
        System.out.println("Digite o descricao do curso: ");
        var description = scanner.next();
        mentoringDAO.insertMentoring(new Mentoring(title, description));
    }

}
