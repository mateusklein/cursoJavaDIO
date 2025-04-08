package br.com.dio.service;

import br.com.dio.dto.BoardDetailDTO;
import br.com.dio.persistence.dao.BoardColumnDAO;
import br.com.dio.persistence.dao.BoardDAO;
import br.com.dio.persistence.entity.BoardColumnEntity;
import br.com.dio.persistence.entity.BoardColumnKindEnum;
import br.com.dio.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@AllArgsConstructor
public class BoardQuerryService {
    private final Connection conn;

    public Optional<BoardEntity> findById(final Long id) throws SQLException {
        var dao = new BoardDAO(conn);
        var boardColumnDao = new BoardColumnDAO(conn);
        var optional = dao.findById(id);
        if (optional.isPresent()) {
            var entity = optional.get();
            entity.setBoardColumns(boardColumnDao.findByBoardId(entity.getId()));
            return Optional.of(entity);
        }
        return Optional.empty();
    }

    public Optional<BoardDetailDTO> showBoardDetails(final Long id) throws SQLException {
        var dao = new BoardDAO(conn);
        var boardColumnDao = new BoardColumnDAO(conn);
        var optional = dao.findById(id);
        if (optional.isPresent()) {
            var entity = optional.get();
            var columns = boardColumnDao.findByBoardIdWithDetails(entity.getId());
            var dto = new BoardDetailDTO(entity.getId(), entity.getName(), columns);
            return Optional.of(dto);
        }
        return Optional.empty();
    }

}
