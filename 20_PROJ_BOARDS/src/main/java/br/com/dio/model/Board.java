package br.com.dio.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Board {
    protected Long boardId;
    public String name;

    private List<BoardColumn> columns;
    private List<Block> blocks;

    public Board(Long boardId, String name) {
        this.boardId = boardId;
        this.name = name;
        columns = new ArrayList<>();
        columns.add(new BoardColumn(1L, "Coluna inicial", BoardColumnKindEnum.INITIAL, 0, this.boardId));
        columns.add(new BoardColumn(2L, "Coluna final", BoardColumnKindEnum.FINAL, 1, this.boardId));
        columns.add(new BoardColumn(3L, "Coluna cancelados", BoardColumnKindEnum.CANCEL, 2, this.boardId));
        blocks = new ArrayList<>();
    }
}
