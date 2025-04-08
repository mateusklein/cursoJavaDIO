package br.com.dio.service;


import br.com.dio.dto.CardDetails;
import br.com.dio.persistence.dao.CardDAO;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class CardQuerryService {
    public final Connection connection;

    public Optional<CardDetails> findById(final Long id) throws SQLException{
        var dao = new CardDAO(connection);
        return dao.findById(id);
    }

}
