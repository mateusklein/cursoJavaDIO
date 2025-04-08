package br.com.dio.ui;

import br.com.dio.persistence.entity.BoardColumnEntity;
import br.com.dio.persistence.entity.BoardColumnKindEnum;
import br.com.dio.persistence.entity.BoardEntity;
import br.com.dio.service.BoardQuerryService;
import br.com.dio.service.BoardService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static br.com.dio.persistence.config.ConnectionConfig.getConnection;

public class MainMenu {
    private final Scanner scanner = new Scanner(System.in);


    public void execute() throws SQLException {
        var option = -1;
        System.out.println("\nWelcome to the main menu");
        while (true){
            System.out.println("\n1. Criar um novo board");
            System.out.println("\n2. Selecionar um board");
            System.out.println("\n3. Excluir um board");
            System.out.println("\n4. Sair");
            option = scanner.nextInt();

            switch (option){
                case 1 -> createBoard();
                case 2 -> selectBoard();
                case 3 -> deleteBoard();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void deleteBoard() throws SQLException {
        System.out.println("\nDigite o id do board a ser excluido: ");
        var id = scanner.nextLong();
        try (var connection = getConnection()) {
            var service = new BoardService(connection);
            if(service.delete(id)){
                System.out.println("Board excluido com sucesso!");
            }else{
                System.out.println("Erro ao excluir o board");
            }
        }
    }

    private void selectBoard() throws SQLException {
        System.out.println("\nDigite o id do board que deseja selecionar: ");
        var id = scanner.nextLong();

        try (var connection = getConnection()) {
            var querryService = new BoardQuerryService(connection);
            var optional = querryService.findById(id);
            optional.ifPresentOrElse(
                    b -> new BoardMenu(b).execute(),
                    () -> System.out.println("Erro ao selecionar o board")
            );
        }

    }

    private void createBoard() throws SQLException {
        var entity = new BoardEntity();
        System.out.println("\nDigite o nome do novo board: ");
        entity.setName(scanner.next());

        System.out.println("\nSeu board terá colunas além das 3 padrões? Se sim informe quantas, senão informe 0");
        var additionalColumns = scanner.nextInt();

        List<BoardColumnEntity> columns = new ArrayList<>();

        System.out.println("\nDigite o nome da coluna inicial do board: ");
        var initialColumnName = scanner.next();
        var initialColumn = createColumn(initialColumnName, BoardColumnKindEnum.INITIAL, 0);
        columns.add(initialColumn);

        for(int i = 0; i < additionalColumns; i++){
            System.out.println("\nDigite o nome da coluna de tarefa pendente: ");
            var pendingColumnName = scanner.next();
            var pendingColumn = createColumn(pendingColumnName, BoardColumnKindEnum.PENDING, i+1);
            columns.add(pendingColumn);
        }

        System.out.println("\nDigite o nome da coluna final do board: ");
        var finalColumnName = scanner.next();
        var finalColumn = createColumn(finalColumnName, BoardColumnKindEnum.FINAL, additionalColumns+1);
        columns.add(finalColumn);

        System.out.println("\nDigite o nome da coluna de cancelados do board: ");
        var cancelColumnName = scanner.next();
        var cancelColumn = createColumn(cancelColumnName, BoardColumnKindEnum.CANCEL, additionalColumns+2);
        columns.add(cancelColumn);

        entity.setBoardColumns(columns);

        try (var connection = getConnection()) {
            var service = new BoardService(connection);
            service.insert(entity);
        }
    }

    private BoardColumnEntity createColumn(final String name, final BoardColumnKindEnum kind, final int order) {
        var boardColumnEntity = new BoardColumnEntity();
        boardColumnEntity.setName(name);
        boardColumnEntity.setKind(kind);
        boardColumnEntity.setOrder(order);
        return boardColumnEntity;
    }
}
