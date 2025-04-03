package br.com.dio.dao;

import br.com.dio.model.Board;

import br.com.dio.model.BoardColumn;
import br.com.dio.model.Card;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;


@Data
public class CardDAO {
    private Long cardId = 1L;
    private Board board;

    public CardDAO(Board board) {
        this.board = board;
    }

    public void insertCard(String title, String description) {
        List<Card> cardsInicialList = board.getColumns().getFirst().getCards();
        Card newCard = new Card(cardId++, title, description, OffsetDateTime.now());

        cardsInicialList.add(newCard);
    }

    public void updateCardColumn(Long idCard){
        Card card = searchCard(idCard);
        Long idColumn = searchIdColumn(idCard);
        if(card == null) return;

        int max = board.getColumns().toArray().length;
        var isblock = board.getBlocks().stream()
                .anyMatch(block -> block.getCardId().equals(idCard) && block.getIsBlocked());
        var isFinished = board.getColumns().stream()
                .filter(c -> c.getOrder() == max - 2)
                .anyMatch(c -> c.getCards().contains(card));
        var isCancel = board.getColumns().stream()
                .filter(c -> c.getOrder() == max - 1)
                .anyMatch(c -> c.getCards().contains(card));

        if(isblock){
            System.out.println("Nao eh possivel fazer o update pois o card esta bloqueado");
            return;
        }else if(isFinished){
            System.out.println("Nao eh possivel fazer o update pois o card ja esta finalizado");
            return;
        } else if (isCancel) {
            System.out.println("Nao eh possivel fazer o update pois o card esta cancelado");
            return;
        }


        var orderColumn = 0;
        List<BoardColumn> boardColumns = board.getColumns();
        for(BoardColumn boardColumn : boardColumns) {
            if (boardColumn.getColumnId().equals(idColumn)) {
                orderColumn = boardColumn.getOrder();
                boardColumn.getCards().remove(card);
            }
        }
        for(BoardColumn boardColumn : boardColumns){
            if(boardColumn.getOrder() == orderColumn+1){
                boardColumn.getCards().add(card);
            }
        }
    }

    public void downgradeCardColumn(Long idCard){
        Card card = searchCard(idCard);
        Long idColumn = searchIdColumn(idCard);
        if(card == null) return;

        int max = board.getColumns().toArray().length;
        var isblock = board.getBlocks().stream()
                .anyMatch(block -> block.getCardId().equals(idCard) && block.getIsBlocked());
        var isFinished = board.getColumns().stream()
                .filter(c -> c.getOrder() == max - 2)
                .anyMatch(c -> c.getCards().contains(card));
        var isCancel = board.getColumns().stream()
                .filter(c -> c.getOrder() == max - 1)
                .anyMatch(c -> c.getCards().contains(card));
        var isFirst = board.getColumns().stream()
                .filter(c -> c.getOrder() == 0)
                .anyMatch(c -> c.getCards().contains(card));

        if(isblock){
            System.out.println("Nao eh possivel fazer o downgrade pois o card esta bloqueado");
            return;
        }else if(isFinished){
            System.out.println("Nao eh possivel fazer o downgrade pois ja esta finalizado");
            return;
        } else if (isCancel) {
            System.out.println("Nao eh possivel fazer o downgrade pois esta cancelado");
            return;
        } else if (isFirst) {
            System.out.println("Nao eh possivel fazer o downgrade pois ja esta no minimo");
            return;
        }

        var orderColumn = 0;
        List<BoardColumn> boardColumns = board.getColumns();
        for(BoardColumn boardColumn : boardColumns) {
            if (boardColumn.getColumnId().equals(idColumn)) {
                orderColumn = boardColumn.getOrder();
                boardColumn.getCards().remove(card);
            }
        }
        for(BoardColumn boardColumn : boardColumns){
            if(boardColumn.getOrder() == orderColumn-1){
                boardColumn.getCards().add(card);
            }
        }
    }


    public void cancelCard(Long idCard){
        Card card = searchCard(idCard);
        Long idColumn = searchIdColumn(idCard);
        if(card == null) return;


        int max = board.getColumns().toArray().length;
        var isFinished = board.getColumns().stream()
                .filter(c -> c.getOrder() == max - 2)
                .anyMatch(c -> c.getCards().contains(card));
        var isCancel = board.getColumns().stream()
                .filter(c -> c.getOrder() == max - 1)
                .anyMatch(c -> c.getCards().contains(card));

        if(isFinished){
            System.out.println("Nao eh possivel cancelar o card, pois ja foi finalizado");
            return;
        } else if (isCancel) {
            System.out.println("Nao eh possivel cancelar o card, pois ja esta cancelado");
            return;
        }

        List<BoardColumn> boardColumns = board.getColumns();
        for(BoardColumn boardColumn : boardColumns) {
            if (boardColumn.getColumnId().equals(idColumn)) {
                boardColumn.getCards().remove(card);
            }
        }
        for(BoardColumn boardColumn : boardColumns){
            if(boardColumn.getOrder() == max-1){
                boardColumn.getCards().add(card);
            }
        }
    }


    public void deleteCard(Long idCard){
        Card card = searchCard(idCard);
        Long idColumn = searchIdColumn(idCard);
        if(card == null) return;


        List<BoardColumn> boardColumns = board.getColumns();

        boardColumns.stream()
                .filter(boardColumn -> boardColumn.getColumnId().equals(idColumn))
                .findFirst()
                .ifPresent(c -> c.getCards().remove(card));
    }

    private Long searchIdColumn(Long idCard){
        List<BoardColumn> boardColumns = board.getColumns();
        for(BoardColumn boardColumn : boardColumns){
            for(Card card : boardColumn.getCards()){
                if(card.getCardId().equals(idCard)){
                    return boardColumn.getColumnId();
                }
            }
        }
        return null;
    }


    private Card searchCard(Long idCard){
        List<BoardColumn> boardColumns = board.getColumns();
        for(BoardColumn boardColumn : boardColumns){
            for(Card card : boardColumn.getCards()){
                if(card.getCardId().equals(idCard)){
                    return card;
                }
            }
        }
        return null;
    }

    public void selectAllCards(){
        List<BoardColumn> boardColumns = board.getColumns();
        List<BoardColumn> sortedColumns = boardColumns.stream()
                .sorted(Comparator.comparingInt(BoardColumn::getOrder))
                .toList();

        for (BoardColumn boardColumn : sortedColumns) {
            System.out.printf("========%s==========", boardColumn.getName());
            for(Card card : boardColumn.getCards()){
                System.out.println("\n");
                System.out.printf("ID do card: %s\n", card.getCardId());
                System.out.printf("Titulo do card: %s\n", card.getTitle());
                System.out.printf("Descricao do card: %s\n", card.getDescription());
                System.out.printf("Data de criacao do card: %s\n", card.getCreatedAt());
                var cardId = card.getCardId();
                var block = board.getBlocks().stream()
                        .filter(b -> b.getCardId().equals(cardId))
                        .findFirst()
                        .orElse(null);
                if(block != null){
                    System.out.printf("Block ID: %s\n", block.getBlockId());
                    System.out.printf("Esta bloqueado: %s\n", block.getIsBlocked());
                    if(block.getIsBlocked()){
                        System.out.printf("Causa bloqueio: %s\n", block.getBlockCause());
                        System.out.printf("Bloqueio ocorrido em: %s\n", block.getBlockIn());
                    }
                    else{
                        System.out.printf("Causa desbloqueio: %s\n", block.getUnblockCause());
                        System.out.printf("Desbloqueio ocorrido em: %s\n", block.getUnblockIn());
                    }
                }
                System.out.println("\n");
            }
            System.out.println("\n=============================================\n\n");
        }
    }

    public void selectCards() {
        List<BoardColumn> boardColumns = board.getColumns();

        // Ordena as colunas pela ordem
        List<BoardColumn> sortedColumns = boardColumns.stream()
                .sorted(Comparator.comparingInt(BoardColumn::getOrder))
                .toList();

        // Imprime os nomes das colunas
        for (BoardColumn boardColumn : sortedColumns) {
            System.out.print("| " + boardColumn.getName() + "   |   ");
        }
        System.out.println("\n==========================================================================");

        // Descobre o número máximo de cards em uma única coluna
        int maxCards = sortedColumns.stream()
                .mapToInt(column -> column.getCards().size())
                .max()
                .orElse(0);

        for (int i = 0; i < maxCards; i++) {
            boolean hasCardInRow = false;

            // ID do Card
            for (BoardColumn boardColumn : sortedColumns) {
                List<Card> cards = boardColumn.getCards();
                if (i < cards.size()) {
                    System.out.print("|      ID: " + cards.get(i).getCardId() + "       |   ");
                    hasCardInRow = true;
                } else {
                    System.out.print("|                |   ");
                }
            }
            System.out.println();

            // Título do Card
            for (BoardColumn boardColumn : sortedColumns) {
                List<Card> cards = boardColumn.getCards();
                if (i < cards.size()) {
                    System.out.print("|  Tarefa: " + cards.get(i).getTitle().substring(0, Math.min(5, cards.get(i).getTitle().length())) + "   |   ");
                } else {
                    System.out.print("|                |   ");
                }
            }
            System.out.println();

            // Descrição do Card
            for (BoardColumn boardColumn : sortedColumns) {
                List<Card> cards = boardColumn.getCards();
                if (i < cards.size()) {
                    System.out.print("| Descricao: " + cards.get(i).getDescription().substring(0, Math.min(5, cards.get(i).getDescription().length())) + " |   ");
                } else {
                    System.out.print("|                |   ");
                }
            }
            System.out.println();

            // Adiciona separador APENAS se houver mais cards abaixo
            if (i < maxCards - 1 && hasCardInRow) {
                System.out.println("==========================================================================");
            }
        }
    }

}
