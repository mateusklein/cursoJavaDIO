package br.com.dio.service;

import br.com.dio.dto.BoardColumnInfoDTO;
import br.com.dio.dto.CardDetails;
import br.com.dio.exception.CardBlockedException;
import br.com.dio.exception.CardFinishedException;
import br.com.dio.exception.EntityNotFoundException;
import br.com.dio.persistence.dao.BlockDAO;
import br.com.dio.persistence.dao.CardDAO;
import br.com.dio.persistence.entity.BoardColumnKindEnum;
import br.com.dio.persistence.entity.CardEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class CardService {
    private final Connection connection;

    public CardEntity insert(final CardEntity entity) throws SQLException {
        try {
            var dao = new CardDAO(connection);
            dao.insert(entity);
            connection.commit();
            return entity;
        }catch (SQLException ex){
            connection.rollback();
            throw ex;
        }
    }

    public void moveToNextColumn(final Long cardId, final List<BoardColumnInfoDTO> boardColumnsInfo) throws SQLException {
        try {
            var dao = new CardDAO(connection);
            var optional = dao.findById(cardId);
            var dto = optional.orElseThrow(
                    () -> new EntityNotFoundException("O card de id %s não foi encontrado".formatted(cardId))
            );
            if(dto.blocked()){
                var msg = "O card %s está bloqueado, é necessário debloquear para mover".formatted(cardId);
                throw new CardBlockedException(msg);
            }
            var currentColumn = boardColumnsInfo.stream()
                    .filter(bc -> bc.id().equals(dto.columnId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("O card informado pertence a outro board"));
            if(currentColumn.kind().equals(BoardColumnKindEnum.FINAL)){
                throw new CardFinishedException("O card já está na coluna de itens finalizados");
            }
            var nextColumn = boardColumnsInfo.stream()
                    .filter(bc -> bc.order() == currentColumn.order() + 1)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("O card esta cancelado"));
            dao.moveToColumn(nextColumn.id(), cardId);
            connection.commit();
        }catch (SQLException ex){
            connection.rollback();
            throw ex;
        }
    }

    public void cancel(final Long cardId, final Long cancelColumnId,final List<BoardColumnInfoDTO> boardColumnsInfo) throws SQLException {
        try {
            var dao = new CardDAO(connection);
            var optional = dao.findById(cardId);
            var dto = optional.orElseThrow(
                    () -> new EntityNotFoundException("O card de id %s não foi encontrado".formatted(cardId))
            );
            if(dto.blocked()){
                var msg = "O card %s está bloqueado, é necessário debloquear para mover".formatted(cardId);
                throw new CardBlockedException(msg);
            }
            var currentColumn = boardColumnsInfo.stream()
                    .filter(bc -> bc.id().equals(dto.columnId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("O card informado pertence a outro board"));
            if(currentColumn.kind().equals(BoardColumnKindEnum.FINAL)){
                throw new CardFinishedException("O card já está na coluna de itens finalizados");
            }
            boardColumnsInfo.stream()
                    .filter(bc -> bc.order() == currentColumn.order() + 1)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("O card esta cancelado"));
            dao.moveToColumn(cancelColumnId, cardId);
            connection.commit();
        }catch (SQLException ex){
            connection.rollback();
            throw ex;
        }
    }

    public void block(final Long cardId, final String reason,final List<BoardColumnInfoDTO> boardColumnsInfo) throws SQLException {
        try {
            var dao = new CardDAO(connection);
            var blockDAO = new BlockDAO(connection);
            var optional = dao.findById(cardId);
            var dto = optional.orElseThrow(
                    () -> new EntityNotFoundException("O card de id %s não foi encontrado".formatted(cardId))
            );
            if(dto.blocked()){
                var msg = "O card %s já está bloqueado".formatted(cardId);
                throw new CardBlockedException(msg);
            }
            var currentColumn = boardColumnsInfo.stream()
                    .filter(bc -> bc.id().equals(dto.columnId()))
                    .findFirst()
                    .orElseThrow();
            if(currentColumn.kind().equals(BoardColumnKindEnum.FINAL) || currentColumn.kind().equals(BoardColumnKindEnum.CANCEL)){
                throw new IllegalStateException("O card está em uma coluna do tipo %s e não pode ser bloqueado".formatted(currentColumn.kind()));
            }
            blockDAO.block(reason, cardId);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }


    public void unblock(final Long cardId, final String reason) throws SQLException{
        try{
            var dao = new CardDAO(connection);
            var blockDAO = new BlockDAO(connection);
            var optional = dao.findById(cardId);
            var dto = optional.orElseThrow(
                    () -> new EntityNotFoundException("O card de id %s não foi encontrado".formatted(cardId))
            );
            if(!dto.blocked()){
                var msg = "O card %s não está bloqueado".formatted(cardId);
                throw new CardBlockedException(msg);
            }
            blockDAO.unblock(reason, cardId);
            connection.commit();
        }catch (SQLException ex){
            connection.rollback();
            throw ex;
        }

    }
}
