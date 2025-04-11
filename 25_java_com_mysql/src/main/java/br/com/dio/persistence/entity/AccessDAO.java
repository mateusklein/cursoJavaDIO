package br.com.dio.persistence.entity;

import br.com.dio.persistence.ConnectionUtil;
import com.mysql.cj.jdbc.StatementImpl;

public class AccessDAO {

    public void insert(final Long module_id, final Long employee_id){
        var sql = "INSERT INTO accesses (module_id, employee_id) VALUES (?,?)";
        try (
                var conn = ConnectionUtil.getConnection();
                var statement = conn.prepareStatement(sql);
        ) {
            statement.setLong(1, module_id);
            statement.setLong(2, employee_id);
            statement.executeUpdate();
            System.out.printf("Foram afetados %s registros na base de dados", statement.getUpdateCount());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
