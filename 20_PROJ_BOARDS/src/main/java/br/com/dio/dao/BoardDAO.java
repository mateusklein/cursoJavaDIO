package br.com.dio.dao;

import br.com.dio.model.Board;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BoardDAO {
    private final List<Board> boards = new ArrayList<>();
    private Long contId = 1L;

    public void insertBoard(String name){
        boards.add(new Board(contId++, name));
    }

    public Board updateBoard(Long boardId, String name){
        for(Board board : boards){
            if(board.getBoardId().equals(boardId)){
                board.setName(name);
                return board;
            }
        }
        System.out.println("Não existe o id enviado");
        return null;
    }

    public Boolean deleteBoard(Long boardId){
        for(Board board : boards){
            if(board.getBoardId().equals(boardId)){
                boards.remove(board);
                return true;
            }
        }
        System.out.println("Não existe o id enviado");
        return false;
    }


    public void selectBoards(){
        if(boards.isEmpty()){
            System.out.println("Não há boards encontrados");
            return;
        }
        for(Board board : boards) {
            System.out.println("================");
            System.out.println("Board ID: " + board.getBoardId());
            System.out.println("Board name: " + board.getName());
            System.out.println("================");
        }
    }
}
