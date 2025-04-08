package br.com.dio.persistence.dao;

import br.com.dio.dto.CardDetails;
import br.com.dio.persistence.converter.OffSetDateTimeConverter;
import br.com.dio.persistence.entity.CardEntity;
import com.mysql.cj.jdbc.StatementImpl;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import static java.util.Objects.nonNull;

@AllArgsConstructor
public class CardDAO {
    private final Connection connection;

    public CardEntity insert(final CardEntity entity) throws SQLException{
        var sql = "INSERT INTO CARDS (title, description, board_column_id) VALUES (?,?,?)";
        try (var stmt = connection.prepareStatement(sql)) {
            var i = 1;
            stmt.setString(i++, entity.getTitle());
            stmt.setString(i++, entity.getDescription());
            stmt.setLong(i, entity.getBoardColumn().getId());
            stmt.executeUpdate();
            if(stmt instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
        }
        return entity;
    }

    public void moveToColumn(final Long columnId, final Long cardId) throws SQLException{
        var sql = "UPDATE CARDS SET board_column_id = ? WHERE id = ?;";
        try (var stmt = connection.prepareStatement(sql)) {
            var i = 1;
            stmt.setLong(i++, columnId);
            stmt.setLong(i, cardId);
            stmt.executeUpdate();
        }

    }

    public Optional<CardDetails> findById(final long id) throws SQLException {
        var sql = """ 
                SELECT
                    c.id,
                    c.title,
                    c.description,
                    b.blocked_at,
                    b.block_reason,
                    c.board_column_id,
                    bc.name,
                    (SELECT COUNT(sub_b.id) from BLOCKS sub_b where sub_b.card_id = c.id) blocks_amount
                FROM CARDS c
                LEFT JOIN BLOCKS b ON c.id = b.card_id
                AND b.unblocked_at IS NULL
                INNER JOIN BOARDS_COLUMNS bc on bc.id = c.board_column_id
                WHERE c.id = ?;
                """;
        try (var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeQuery();
            var rs = statement.getResultSet();
            if(rs.next()) {
                var dto = new CardDetails(
                        rs.getLong("c.id"),
                        rs.getString("c.title"),
                        rs.getString("c.description"),
                        nonNull(rs.getString("b.block_reason")),
                        OffSetDateTimeConverter.toOffsetDateTime(rs.getTimestamp("b.blocked_at")),
                        rs.getString("b.block_reason"),
                        rs.getInt("blocks_amount"),
                        rs.getLong("c.board_column_id"),
                        rs.getString("bc.name")
                );
                return Optional.of(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
