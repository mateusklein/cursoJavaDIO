package br.com.dio.persistence.entity;

import br.com.dio.persistence.ConnectionUtil;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class ModuleDAO {
    public List<ModuleEntity> findAll(){
        List<ModuleEntity> entities = new ArrayList<>();
        var sql = "select m.id module_id,\n" +
                "\t\tm.name module_name,\n" +
                "        e.id employee_id,\n" +
                "        e.name employee_name,\n" +
                "        e.salary employee_salary,\n" +
                "        e.birthday employee_birthday\n" +
                " from modulers m inner join accesses a on a.module_id = m.id inner join employees e on e.id = a.employee_id\n" +
                " ORDER BY m.id;";
        try (
                var conn = ConnectionUtil.getConnection();
                var statement = conn.prepareStatement(sql);
        ) {
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            var hasNext = resultSet.next();
            while (hasNext) {
                ModuleEntity module = new ModuleEntity();
                module.setId(resultSet.getLong("module_id"));
                module.setName(resultSet.getString("module_name"));
                module.setEmployees(new ArrayList<>());
                do{
                    var employee = new EmployeeEntity();
                    employee.setId(resultSet.getLong("employee_id"));
                    employee.setName(resultSet.getString("employee_name"));
                    employee.setSalary(resultSet.getBigDecimal("employee_salary"));
                    var birthday = resultSet.getTimestamp("employee_birthday").toInstant();
                    employee.setBirthday(OffsetDateTime.ofInstant(birthday, UTC));
                    module.getEmployees().add(employee);
                    hasNext = resultSet.next();
                }while((hasNext) && (module.getId() == resultSet.getLong("module_id")));
                entities.add(module);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return entities;
    }


}
