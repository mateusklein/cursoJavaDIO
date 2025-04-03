package br.com.dio.dao;

import java.time.OffsetDateTime;

import br.com.dio.model.Block;
import br.com.dio.model.Board;
import br.com.dio.model.Card;

public class BlockDAO {
    private Long blockId = 1L;
    private final Board board;

    public BlockDAO(Board board) {
        this.board = board;
    }

    public void insertBlock(Long cardId, String blockCause) {
        Card card = searchCard(cardId);
        if (card == null) {
            System.out.println("Card not found");
            return;
        }

        var block = board.getBlocks().stream()
                .filter(b -> b.getCardId().equals(cardId))
                .findFirst()
                .orElse(null);

        if (block != null) {
            if (block.getIsBlocked()) {
                System.out.println("Card is already blocked");
            } else {
                block.setIsBlocked(true);
                block.setBlockCause(blockCause);
                block.setBlockIn(OffsetDateTime.now());
                block.setUnblockCause(null);
                block.setUnblockIn(null);
                System.out.println("Card re-blocked successfully!");
            }
            return;
        }

        board.getBlocks().add(new Block(blockId++, blockCause, null, OffsetDateTime.now(), null, true, cardId));
    }

    public void insertUnblock(Long cardId, String unblockCause) {
        Card card = searchCard(cardId);
        if (card == null) {
            System.out.println("Card not found");
            return;
        }

        var block = board.getBlocks().stream()
                .filter(b -> b.getCardId().equals(cardId))
                .findFirst()
                .orElse(null);

        if (block == null) {
            System.out.println("Bloqueio nesse card não existe");
        } else {
            block.setIsBlocked(false);
            block.setBlockCause(null);
            block.setBlockIn(null);
            block.setUnblockCause(unblockCause);
            block.setUnblockIn(OffsetDateTime.now());
            System.out.println("Card desbloqueado com sucesso!");
        }
    }

    private void deleteBlock(Long cardId) {
        Card card = searchCard(cardId);
        if (card == null) {
            System.out.println("Card not found");
            return;
        }

        boolean removed = board.getBlocks().removeIf(b -> b.getCardId().equals(cardId));

        if (removed) {
            System.out.println("Block removed successfully!");
        } else {
            System.out.println("No block found for this card.");
        }
    }

    private Card searchCard(Long cardId) {
        var listColumns = this.board.getColumns();
        for (var column : listColumns) {
            var card = column.getCards().stream()
                    .filter(c -> c.getCardId().equals(cardId))
                    .findFirst();

            if (card.isPresent()) {
                return card.get();
            }
        }
        return null;
    }

}
