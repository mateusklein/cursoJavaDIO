package br.com.dio;

import br.com.dio.persistence.ConnectionUtil;
import br.com.dio.persistence.entity.*;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import net.datafaker.Faker;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;

import static java.time.ZoneOffset.UTC;

public class Main {

    private final static EmployeeDAO employeeDAO = new EmployeeDAO();
    private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();
    private final static Faker faker = new Faker(Locale.of("pt", "BR")); //GERA REGISTROS ALEATÓRIOS
    private final static ContactDAO contactDAO = new ContactDAO();
    private final static ModuleDAO moduleDAO = new ModuleDAO();

    public static void main(final String[] args) {
        /*
        //PASSO 1 -> MIGRACOES
        //COLOCAR MIGRACOES DENTRO DA PASTA RESOURCES/DB/MIGRATION
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/store", "mlourenco", "senha#123")
                .load();
        flyway.migrate();
        */


        /*
        //PASSO 2 -> INSERINDO NA TABELA EMPLOYEE (1 POR 1)
        var employee = new EmployeeEntity();
        employee.setName("Lucas");
        employee.setSalary(new BigDecimal("3500"));
        employee.setBirthday(OffsetDateTime.now().minusYears(21));
        var employee2 = new EmployeeEntity();
        employee2.setName("Maria");
        employee2.setSalary(new BigDecimal("2800"));
        employee2.setBirthday(OffsetDateTime.now().minusYears(26));
        var employee3 = new EmployeeEntity();
        employee3.setName("Jorge");
        employee3.setSalary(new BigDecimal("2100"));
        employee3.setBirthday(OffsetDateTime.now().minusYears(26));
        employeeDAO.insert(employee);
        employeeDAO.insert(employee2);
        employeeDAO.insert(employee3);
        System.out.println(employee);
         */


        /*
        //PASSO 3 -> PROCURANDO TODOS E PROCURANDO PELO ID
        employeeDAO.findAll().forEach(System.out::println); //PROCURA TODOS
        System.out.println(employeeDAO.findById(1L)); //PROCURA PELO ID
        */



        /*
        //PASSO 4 -> FAZENDO UPDATE
        EmployeeEntity employee4 = new EmployeeEntity();
        employee4.setName("Mateus Klein");
        employee4.setSalary(new BigDecimal("3500"));
        employee4.setBirthday(OffsetDateTime.now().minusYears(21));
        employeeDAO.insert(employee4);

        var employee = new EmployeeEntity();
        employee.setId(1L);
        employee.setName("Clebinho");
        employee.setSalary(new BigDecimal("5500.00"));
        employee.setBirthday(OffsetDateTime.now().minusYears(27));
        employeeDAO.update(employee);
        */


        /*
        //PASSO 5 -> FAZENDO DELETE
        employeeDAO.delete(1L);
        */



        /*
        //PASSO 6 -> INSERINDO COM PROCEDURE
        EmployeeEntity employee5 = new EmployeeEntity();
        employee5.setId(1L);
        employee5.setName("Mateus Lourenco");
        employee5.setSalary(new BigDecimal("3800.00"));
        employee5.setBirthday(OffsetDateTime.now().minusYears(21));
        employeeDAO.insertWithProc(employee5);*/
        /*


        /*
        //PASSO 7 -> INSERINDO COM FUNCAO BATCH
        var entities = Stream.generate(() -> {
            var employee = new EmployeeEntity();
            employee.setName(faker.name().fullName());
            employee.setSalary(new BigDecimal(faker.number().digits(4)));
            employee.setBirthday(OffsetDateTime.of(LocalDate.now().minusYears(faker.number().numberBetween(40,20)), LocalTime.MIN, UTC));
            return employee;
        }).limit(10000)
                .toList();


        employeeDAO.insertBatch(entities);
        */

        /*
        //PASSO 8 -> RELACIONAMENTO DE 1 PARA 1
        EmployeeEntity employee6 = new EmployeeEntity();
        employee6.setName("Mateus Lourenco");
        employee6.setSalary(new BigDecimal("3800.00"));
        employee6.setBirthday(OffsetDateTime.now().minusYears(21));
        employeeDAO.insert(employee6);


        ContactEntity contact1 = new ContactEntity();
        contact1.setDescription("mateus@mateus.com");
        contact1.setType("email");
        contact1.setEmployee(employee6);
        contactDAO.insert(contact1);
         */


        /*
        //PASSO 9 -> RELACIONAMENTO DE 1 PARA N
        EmployeeEntity employee7 = new EmployeeEntity();
        employee7.setName("Joaozinho");
        employee7.setSalary(new BigDecimal("3800.00"));
        employee7.setBirthday(OffsetDateTime.now().minusYears(21));
        employeeDAO.insert(employee7);

        ContactEntity contact2 = new ContactEntity();
        contact2.setDescription("joaozinho@joaozinho.com");
        contact2.setType("email");
        contact2.setEmployee(employee7);
        contactDAO.insert(contact2);

        ContactEntity contact1 = new ContactEntity();
        contact1.setDescription("11921312312");
        contact1.setType("celular");
        contact1.setEmployee(employee7);
        contactDAO.insert(contact1);
        */


        /*
        //PASSO 10 -> ALTERANDO PARA BUSCAR CONTATO
        employeeDAO.findAll().forEach(System.out::println);
         */


        /*
        //PASSO 11 -> RELACIONAMENTO N PARA N
        var entities2 = Stream.generate(() -> {
                    var employee = new EmployeeEntity();
                    employee.setName(faker.name().fullName());
                    employee.setSalary(new BigDecimal(faker.number().digits(4)));
                    employee.setBirthday(OffsetDateTime.of(LocalDate.now().minusYears(faker.number().numberBetween(40,20)), LocalTime.MIN, UTC));
                    employee.setModules(new ArrayList<>());
                    var moduleAmount = faker.number().numberBetween(1, 4);
                    for (int i = 0; i < moduleAmount; i++) {
                        var module = new ModuleEntity();
                        module.setId(i +1L);
                        employee.getModules().add(module);
                    }
                    return employee;
                }).limit(3)
                .toList();
        entities2.forEach(employeeDAO::insert);
         */


        /*
        PASSO 12 -> FAZENDO O FIND ALL DO RELACIONAMENTO N PARA N
        moduleDAO.findAll().forEach(System.out::println);
        */





    }


}
