package br.com.dio.persistence.dao;
import br.com.dio.dto.BoardColumnDTO;
import br.com.dio.persistence.entity.BoardColumnEntity;
import br.com.dio.persistence.entity.BoardColumnKindEnum;
import br.com.dio.persistence.entity.CardEntity;
import com.mysql.cj.jdbc.StatementImpl;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@AllArgsConstructor
public class BoardColumnDAO {
    private final Connection connection;


    public BoardColumnEntity insert(final BoardColumnEntity entity) throws SQLException {
        var sql = "INSERT INTO boards_columns (NAME, `ORDER`, KIND, BOARD_ID) VALUES (?, ?, ?, ?);";
        try(var statement  = connection.prepareStatement(sql)) {
            var i = 1;
            statement.setString(i++, entity.getName());
            statement.setInt(i++, entity.getOrder());
            statement.setString(i++, entity.getKind().name());
            statement.setLong(i, entity.getBoard().getId());
            statement.executeUpdate();
            if(statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
            return entity;
        }
    }


    public List<BoardColumnEntity> findByBoardId(final Long id) throws SQLException {
        List<BoardColumnEntity> entities = new ArrayList<>();
        var sql = "SELECT id, name, `order`, kind FROM boards_columns WHERE board_id = ? ORDER BY `ORDER`";
        try (var stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeQuery();
            var rs = stmt.getResultSet();
            while (rs.next()) {
                var entity = new BoardColumnEntity();
                entity.setId(rs.getLong("id"));
                entity.setName(rs.getString("name"));
                entity.setOrder(rs.getInt("order"));
                entity.setKind(BoardColumnKindEnum.findByName(rs.getString("kind")));
                entities.add(entity);
            }
            return entities;
        }
    }

    public List<BoardColumnDTO> findByBoardIdWithDetails(final Long id) throws SQLException {
        List<BoardColumnDTO> dtos = new ArrayList<>();
        var sql = """
        SELECT bc.id, 
               bc.name, 
               bc.`order`, 
               bc.kind,
               (SELECT COUNT(c.id) FROM CARDS c WHERE c.board_column_id = bc.id) cards_amount
        FROM boards_columns bc 
        WHERE board_id = ? 
        ORDER BY `ORDER`;
        """;
        try (var stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeQuery();
            var rs = stmt.getResultSet();
            while (rs.next()) {
                var entity = new BoardColumnDTO(
                        rs.getLong("bc.id"),
                        rs.getString("bc.name"),
                        rs.getInt("bc.order"),
                        BoardColumnKindEnum.findByName(rs.getString("bc.kind")),
                        rs.getInt("cards_amount")
                );
                dtos.add(entity);
            }
            return dtos;
        }
    }

    public Optional<BoardColumnEntity> findById(final Long id) throws SQLException {
        var sql = """
        SELECT bc.name, bc.kind, c.id, c.title, c.description
        FROM boards_columns bc 
        LEFT join CARDS c 
        ON c.board_column_id = bc.id
        WHERE bc.id = ?;
        """;
        try (var stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeQuery();
            var rs = stmt.getResultSet();
            if(rs.next()) {
                var entity = new BoardColumnEntity();
                entity.setName(rs.getString("name"));
                entity.setKind(BoardColumnKindEnum.findByName(rs.getString("kind")));
                do {
                    if(isNull(rs.getString("c.title"))) {
                        break;
                    }
                    var card = new CardEntity();
                    card.setId(rs.getLong("c.id"));
                    card.setTitle(rs.getString("c.title"));
                    card.setDescription(rs.getString("c.description"));
                    entity.getCards().add(card);
                } while (rs.next());
                return Optional.of(entity);
            }
            return Optional.empty();
        }
    }
}
