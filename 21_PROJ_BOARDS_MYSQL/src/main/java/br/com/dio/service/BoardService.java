package br.com.dio.service;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.dio.persistence.dao.BoardColumnDAO;
import br.com.dio.persistence.dao.BoardDAO;
import br.com.dio.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardService {
    private final Connection conn;

    public BoardEntity insert(final BoardEntity entity) throws SQLException {
        var dao = new BoardDAO(conn);
        var boardColumnDAO = new BoardColumnDAO(conn);
        try {
            dao.insert(entity);
            var columns = entity.getBoardColumns().stream().map(c -> {
                c.setBoard(entity);
                return c;
            }).toList();
            for(var column : columns) {
                boardColumnDAO.insert(column);
            }
            conn.commit();
        }catch (SQLException e) {
            conn.rollback();
            throw e;
        }
        return entity;
    }

    public Boolean delete(final Long id)throws SQLException {
        var dao = new BoardDAO(conn);
        try {
            if(!dao.exists(id)){
                return false;
            }
            dao.delete(id);
            conn.commit();
            return true;
        }catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

}
