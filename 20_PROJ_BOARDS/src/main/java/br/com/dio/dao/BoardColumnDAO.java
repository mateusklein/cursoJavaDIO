package br.com.dio.dao;

import br.com.dio.model.BoardColumn;
import br.com.dio.model.Board;
import br.com.dio.model.BoardColumnKindEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class BoardColumnDAO extends BoardDAO {
    private Long columnId = 4L;
    Board board;

    public BoardColumnDAO(Board board) {
        this.board = board;
    }

    public void insertColumnBoard(String name, int order) {
        if(board.getColumns()==null) return;
        List<BoardColumn> boardColumns = board.getColumns();
        if(order==0 || order==boardColumns.size() || order==boardColumns.size()-1){
            System.out.println("Não é possível inserir nessa posição");
            return;
        }
        for(BoardColumn boardColumn : boardColumns){
            if(boardColumn.getOrder() >= order){
                boardColumn.setOrder(boardColumn.getOrder()+1);
            }
        }
        board.getColumns().add(new BoardColumn(columnId++, name, BoardColumnKindEnum.PENDING, order, board.getBoardId()));
    }

    public void deleteColumnBoard(Long columnId){
        BoardColumn boardColumn = searchColumn(columnId);
        if (boardColumn == null) return;
        if(boardColumn.getOrder()==0 || boardColumn.getOrder()>=board.getColumns().size()-1){
            System.out.println("Não é possível remover a borda, ela é fixa");
            return;
        }else{
            int remov = boardColumn.getOrder();
            board.getColumns().remove(boardColumn);
            for(BoardColumn boardColumn1 : board.getColumns()){
                if(boardColumn1.getOrder() > remov){
                    boardColumn.setOrder(boardColumn.getOrder()-1);
                }
            }
        }
    }

    public void updateOrderColumnBoard(Long columnId, int newOrder){
        BoardColumn boardColumn = searchColumn(columnId);
        if (boardColumn == null) return;
        if(boardColumn.getOrder()==0 || boardColumn.getOrder()>=board.getColumns().size()-1){
            System.out.println("Não é possível mover a coluna, ela é fixa");
            return;
        }
        if(newOrder == 0 || newOrder>=board.getColumns().size()-1){
            System.out.println("Não é possível mover a coluna para essa posição");
            return;
        }
        int oldOrder = boardColumn.getOrder();
        if (newOrder > oldOrder) {
            for (BoardColumn col : board.getColumns()) {
                if (col.getOrder() > oldOrder && col.getOrder() <= newOrder) {
                    col.setOrder(col.getOrder() - 1);
                }
            }
        } else if (newOrder < oldOrder) {
            for (BoardColumn col : board.getColumns()) {
                if (col.getOrder() >= newOrder && col.getOrder() < oldOrder) {
                    col.setOrder(col.getOrder() + 1);
                }
            }
        } else {
            System.out.println("A coluna já está na posição desejada.");
            return;
        }
        boardColumn.setOrder(newOrder);
    }

    public void updateNameColumnBoard(Long columnId, String name){
        BoardColumn boardColumn = searchColumn(columnId);
        if (boardColumn == null) return;
        if(boardColumn.getOrder()==0 || boardColumn.getOrder()>=board.getColumns().size()-2){
            System.out.println("Não é possível renomear a coluna, ela é fixa");
            return;
        }
        boardColumn.setName(name);
    }

    private BoardColumn searchColumn(Long id){
        for(BoardColumn boardColumn : board.getColumns()){
            if(boardColumn.getColumnId().equals(id)){
                return boardColumn;
            }
        }
        return null;
    }

    public void selectColumns(){
        for(BoardColumn boardColumn : board.getColumns()){
            System.out.println("Nome da coluna: " + boardColumn.getName());
            System.out.println("Ordem da coluna: " + boardColumn.getOrder());
            System.out.println("ID da coluna: " + boardColumn.getColumnId());
        }
    }


}
