package br.com.dio.persistence.entity;

import br.com.dio.persistence.ConnectionUtil;
import com.mysql.cj.jdbc.StatementImpl;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class ContactDAO {
    public void insert(final ContactEntity entity){
        var sql = "INSERT INTO contacts (description, type, employee_id) VALUES (?,?,?)";
        try (
                var conn = ConnectionUtil.getConnection();
                var statement = conn.prepareStatement(sql);
        ) {
            statement.setString(1, entity.getDescription());
            statement.setString(2, entity.getType());
            statement.setLong(3, entity.getEmployee().getId());
            statement.executeUpdate();
            if(statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
            System.out.printf("Foram afetados %s registros na base de dados", statement.getUpdateCount());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<ContactEntity> findByEmployeeId(final Long employeeId){
        List<ContactEntity> entities = new ArrayList<>();
        var sql = "SELECT * FROM contacts WHERE employee_id = ?";
        try (
                var conn = ConnectionUtil.getConnection();
                var statement = conn.prepareStatement(sql);
        ) {
            statement.setLong(1, employeeId);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            while (resultSet.next()) {
                var entity = new ContactEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setDescription(resultSet.getString("description"));
                entity.setType(resultSet.getString("type"));
                entity.setEmployee(new EmployeeEntity());
                entity.getEmployee().setId(resultSet.getLong("employee_id"));;
                entities.add(entity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return entities;
    }


}
