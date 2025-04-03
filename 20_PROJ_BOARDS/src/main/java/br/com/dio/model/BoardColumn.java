package br.com.dio.model;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BoardColumn {
    protected Long columnId;
    public String name;
    public BoardColumnKindEnum kind;
    public int order;

    public Long boardId;
    private List<Card> cards;

    public BoardColumn() {

    }

    public BoardColumn(Long columnId, String name, BoardColumnKindEnum kind, int order, Long boardId) {
        this.columnId = columnId;
        this.name = name;
        this.kind = kind;
        this.order = order;
        this.boardId = boardId;
        this.cards = new ArrayList<>();
    }
}
