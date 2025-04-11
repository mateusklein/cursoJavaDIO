package br.com.dio.persistence.entity;

import br.com.dio.persistence.ConnectionUtil;
import com.mysql.cj.jdbc.StatementImpl;

import java.lang.constant.ModuleDesc;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.sql.Types;

import static java.time.ZoneOffset.UTC;

public class EmployeeDAO {
    private final ContactDAO contactDAO = new ContactDAO();

    private final AccessDAO accessDAO = new AccessDAO();

    public void insert(final EmployeeEntity entity){
        var sql = "INSERT INTO employees (name, salary, birthday) VALUES (?,?,?)";
        try (
                var conn = ConnectionUtil.getConnection();
                var statement = conn.prepareStatement(sql);
        ) {
            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setString(3, formatOffSetDateTime(entity.getBirthday()));
            statement.executeUpdate();


            System.out.printf("Foram afetados %s registros na base de dados", statement.getUpdateCount());
            if(statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
            entity.getModules().stream().map(ModuleEntity::getId).forEach(m -> accessDAO.insert(m, entity.getId()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertBatch(final List<EmployeeEntity> entities) {
        var sql = "INSERT INTO employees (name, salary, birthday) VALUES (?,?,?)";
        try (var conn = ConnectionUtil.getConnection()) {
            try (var statement = conn.prepareStatement(sql)) {
                conn.setAutoCommit(false);
                for(var entity : entities){
                    statement.setString(1, entity.getName());
                    statement.setBigDecimal(2, entity.getSalary());
                    statement.setTimestamp(3,
                            Timestamp.valueOf(entity.getBirthday().atZoneSameInstant(UTC).toLocalDateTime()));
                    statement.addBatch();
                }
                statement.executeBatch();
                conn.commit();
            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void update(final EmployeeEntity entity){
        var sql = "UPDATE employees SET name = ? , salary = ? , birthday = ? WHERE id = ?";
        try (
                var conn = ConnectionUtil.getConnection();
                var statement = conn.prepareStatement(sql);
        ) {
            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setString(3, formatOffSetDateTime(entity.getBirthday()));
            statement.setLong(4, entity.getId());
            statement.executeUpdate();
            System.out.printf("Foram afetados %s registros na base de dados", statement.getUpdateCount());

            if(statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(final Long id){
        var sql = "DELETE FROM employees WHERE id = ?";
        try (
                var conn = ConnectionUtil.getConnection();
                var statement = conn.prepareStatement(sql);
        ) {
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.printf("Foram afetados %s registros na base de dados", statement.getUpdateCount());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<EmployeeEntity> findAll(){
        List<EmployeeEntity> entities = new ArrayList<>();
        var sql = "SELECT * FROM employees";
        try (
                var conn = ConnectionUtil.getConnection();
                var statement = conn.prepareStatement(sql);
        ) {
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            while (resultSet.next()) {
                var entity = new EmployeeEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                entity.setContact(contactDAO.findByEmployeeId(resultSet.getLong("id")));
                var birthday = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthday, UTC));
                entities.add(entity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return entities;
    }

    public EmployeeEntity findById(final Long id){
        var entity = new EmployeeEntity();
        var sql = "SELECT * FROM employees WHERE id = ?";
        try (
                var conn = ConnectionUtil.getConnection();
                var statement = conn.prepareStatement(sql);
        ) {
            statement.setLong(1, id);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            if (resultSet.next()) {
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthday = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthday, UTC));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return entity;
    }


    public void insertWithProc(final EmployeeEntity entity){
        var sql = "CALL prc_insert_employee(?, ?, ?, ?) ";
        try (
                var conn = ConnectionUtil.getConnection();
                var statement = conn.prepareCall(sql);
        ) {
            statement.registerOutParameter(1, Types.BIGINT);
            statement.setString(2, entity.getName());
            statement.setBigDecimal(3, entity.getSalary());
            statement.setTimestamp(4,
                    Timestamp.valueOf(entity.getBirthday().atZoneSameInstant(UTC).toLocalDateTime()));
            statement.execute();
            entity.setId(statement.getLong(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String formatOffSetDateTime(final OffsetDateTime dateTime){
        var utcDateTime = dateTime.withOffsetSameInstant(UTC);
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
