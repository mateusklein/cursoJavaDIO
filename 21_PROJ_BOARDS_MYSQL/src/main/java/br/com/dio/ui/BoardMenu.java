package br.com.dio.ui;

import br.com.dio.dto.BoardColumnInfoDTO;
import br.com.dio.exception.EntityNotFoundException;
import br.com.dio.persistence.dao.CardDAO;
import br.com.dio.persistence.entity.BoardColumnEntity;
import br.com.dio.persistence.entity.BoardColumnKindEnum;
import br.com.dio.persistence.entity.BoardEntity;
import br.com.dio.persistence.entity.CardEntity;
import br.com.dio.service.BoardColumnQuerryService;
import br.com.dio.service.BoardQuerryService;
import br.com.dio.service.CardQuerryService;
import br.com.dio.service.CardService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.Scanner;

import static br.com.dio.persistence.config.ConnectionConfig.getConnection;

@AllArgsConstructor
public class BoardMenu {
    private final BoardEntity entity;
    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public void execute(){
        try {
            System.out.printf("Bem vindo ao board %s, selecione a operação desejada: \n", entity.getId());
            var option = -1;
            System.out.println("\nWelcome to the main menu");
            while (true) {
                System.out.println("\n1. Criar um card");
                System.out.println("\n2. Mover um card");
                System.out.println("\n3. Bloquear um card");
                System.out.println("\n4. Desbloquear um card");
                System.out.println("\n5. Cancelar um card");
                System.out.println("\n6. Visualizar colunas");
                System.out.println("\n7. Visualizar coluna com cards");
                System.out.println("\n8. Ver card");
                System.out.println("\n9. Voltar para o menu anterior");
                System.out.println("\n10. Sair");
                option = scanner.nextInt();

                switch (option) {
                    case 1 -> createCard();
                    case 2 -> moveCardToNextColumn();
                    case 3 -> blockCard();
                    case 4 -> unblockCard();
                    case 5 -> cancelCard();
                    case 6 -> showBoard();
                    case 7 -> showColumn();
                    case 8 -> showCard();
                    case 9 -> System.out.println("Voltando para o menu anterior");
                    case 10 -> System.exit(0);
                    default -> System.out.println("Invalid option");
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            System.exit(0);
        }
    }

    private void createCard() throws SQLException {
        var card = new CardEntity();

        System.out.println("Digite o titulo do card: ");
        card.setTitle(scanner.next());
        System.out.println("Digite o descricao do card: ");
        card.setDescription(scanner.next());
        card.setBoardColumn(entity.getInitialColumn());

        try (var connection = getConnection()) {
            new CardService(connection).insert(card);
        }

    }

    private void moveCardToNextColumn() throws SQLException {
        System.out.println("Informe o ID do card que deseja mover para proxima coluna");
        var cardId = scanner.nextLong();
        var boardColumnsInfo = entity.getBoardColumns().stream()
                .map(bc -> new BoardColumnInfoDTO(bc.getId(), bc.getOrder(), bc.getKind()))
                .toList();
        try (var connection = getConnection()) {
            new CardService(connection).moveToNextColumn(cardId, boardColumnsInfo);
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void blockCard() throws SQLException {
        System.out.println("Informe o ID do card que deseja bloquear");
        var cardId = scanner.nextLong();
        System.out.println("Informe o motivo");
        var reason = scanner.next();
        var boardColumnsInfo = entity.getBoardColumns().stream()
                .map(bc -> new BoardColumnInfoDTO(bc.getId(), bc.getOrder(), bc.getKind()))
                .toList();
        try (var connection = getConnection()) {
            new CardService(connection).block(cardId, reason, boardColumnsInfo);
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void unblockCard() throws SQLException{
        System.out.println("Informe o ID do card que deseja desbloquear");
        var cardId = scanner.nextLong();
        System.out.println("Informe o motivo");
        var reason = scanner.next();
        try (var connection = getConnection()) {
            new CardService(connection).unblock(cardId, reason);
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }

    }

    private void cancelCard() throws SQLException {
        System.out.println("Informe o ID do card que deseja mover para a coluna de cancelamento");
        var cardId = scanner.nextLong();
        var cancelColumn = entity.getCancelColumn();
        var boardColumnsInfo = entity.getBoardColumns().stream()
                .map(bc -> new BoardColumnInfoDTO(bc.getId(), bc.getOrder(), bc.getKind()))
                .toList();
        try (var connection = getConnection()) {
            new CardService(connection).cancel(cardId, cancelColumn.getId(), boardColumnsInfo);
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void showBoard(){
        try (var connection = getConnection()) {
            var optional = new BoardQuerryService(connection).showBoardDetails(entity.getId());
            optional.ifPresent(b -> {
                System.out.printf("Board [%s, %s]", b.id(), b.name());
                b.columns().forEach(c -> {
                    System.out.printf("Coluna [%s] tipo: [%s] tem %s cards", c.name(), c.kind(), c.cardsAmount());
                });
            });
        }catch (SQLException e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void showColumn() throws SQLException {
        System.out.printf("Escolha uma coluna do board: %s \n", entity.getName());
        var columnsId = entity.getBoardColumns().stream().map(BoardColumnEntity::getId).toList();
        var selectedCounts = -1L;
        while(!columnsId.contains(selectedCounts)){
            entity.getBoardColumns().forEach(c -> {System.out.printf("%s, %s", c.getId(), c.getName());});
            selectedCounts = scanner.nextLong();
        }

        try (var connection = getConnection()){
            var column = new BoardColumnQuerryService(connection).findById(selectedCounts);
            column.ifPresent(co -> {
                System.out.printf("Coluna %s tipo %s \n", co.getName(), co.getKind());
                co.getCards().forEach(c -> {
                    System.out.printf("Card %s - %s. \nDescrição: %s", c.getId(), c.getTitle(), c.getDescription());
                });
            });
        }

    }

    private void showCard() throws SQLException {
        System.out.println("Informe o id do card que deseja visualizar");
        var selectedCardId = scanner.nextLong();
        try (var connection = getConnection()){
            new CardQuerryService(connection).findById(selectedCardId)
                    .ifPresentOrElse(
                            c -> {
                                System.out.printf("Card %s - %s. \n", c.id(), c.title());
                                System.out.printf("Descrição: %s. \n", c.description());
                                System.out.println(c.blocked() ?
                                        "Esta bloqueado por: \n" + c.blockReason() :
                                        "Não esta bloquado\n");
                                System.out.printf("Ja foi bloqueado %s vezes. \n", c.blocksAmount());
                                System.out.printf("Está na coluna %s - %s. \n", c.columnId(), c.columnName());
                            },
                            () -> System.out.printf("Não existe um card com o id %s", selectedCardId));
        }
    }
}
