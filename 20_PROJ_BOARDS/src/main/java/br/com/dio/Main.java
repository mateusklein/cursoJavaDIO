package br.com.dio;

import br.com.dio.dao.BlockDAO;
import br.com.dio.dao.BoardDAO;
import br.com.dio.dao.CardDAO;
import br.com.dio.model.Board;
import br.com.dio.dao.BoardColumnDAO;
import java.util.Scanner;


public class Main {
    public static Board board;
    public static BoardDAO boardDAO = new BoardDAO();
    public static BoardColumnDAO columnDAO;
    public static CardDAO cardDAO;
    public static BlockDAO blockDAO;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int option = 1;
        do{
            System.out.println("Informe a opção desejada: ");
            System.out.println("1 - Criar novo board");
            System.out.println("2 - Selecionar board");
            System.out.println("3 - Excluir board");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            switch(option){
                case 1:
                    System.out.println("Informe o nome do novo board: ");
                    var name = scanner.next();
                    boardDAO.insertBoard(name);
                    break;
                case 2:
                    if(boardDAO.getBoards().isEmpty()){
                        System.out.println("Não há boards cadastrados");
                        break;
                    }else {
                        System.out.println("Informe o id do board desejado: ");
                        boardDAO.selectBoards();
                        var selectedBoard = scanner.nextLong();
                        board = boardDAO.getBoards().stream()
                                .filter(b -> b.getBoardId().equals(selectedBoard))
                                .findFirst()
                                .orElse(null);
                        if(board==null){
                            System.out.println("ID não encontrado");
                        }else{
                            columnDAO = new BoardColumnDAO(board);
                            cardDAO = new CardDAO(board);
                            blockDAO = new BlockDAO(board);
                            menuBoard(board);
                        }
                        break;
                    }
                case 3:
                    if(boardDAO.getBoards().isEmpty()){
                        System.out.println("Não há boards cadastrados");
                        break;
                    }else{
                        System.out.println("Informe o id do board que deseja excluir: ");
                        boardDAO.selectBoards();
                        var selectedId = scanner.nextLong();
                        boardDAO.deleteBoard(selectedId);
                        break;
                    }
                default:
                    break;
            }
        }while(option != 0);
    }

    public static void menuBoard(Board board){
        Scanner scanner = new Scanner(System.in);
        var option = 1;
        var id = 0L;

        do{
            System.out.println("\n===== MENU BOARD: " + board.getName() + " =====");
            System.out.println("1 - Listar Colunas");
            System.out.println("2 - Adicionar Coluna");
            System.out.println("3 - Remover Coluna");
            System.out.println("4 - Alterar Ordem da Coluna");
            System.out.println("5 - Renomear Coluna");
            System.out.println("6 - Listar Cards");
            System.out.println("7 - Adicionar Card");
            System.out.println("8 - Remover Card");
            System.out.println("9 - Mover Card");
            System.out.println("10 - Cancelar Card");
            System.out.println("11 - Bloquear/Desbloquear Card");
            System.out.println("12 - Relatorio de todos os Cards");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("============Listar Colunas==============");
                    columnDAO.selectColumns();
                    System.out.println("=================================");
                    break;
                case 2:
                    System.out.println("============Adicionar colunas==============");
                    System.out.print("Digite o nome do coluna: ");
                    var name = scanner.next();
                    System.out.print("Digite a ordem da coluna: ");
                    var order = scanner.nextInt();
                    columnDAO.insertColumnBoard(name, order);
                    System.out.println("=================================");
                    break;
                case 3:
                    System.out.println("============Remover colunas==============");
                    System.out.print("Digite o ID do coluna: ");
                    id = scanner.nextLong();
                    columnDAO.deleteColumnBoard(id);
                    System.out.println("=================================");
                    break;
                case 4:
                    System.out.println("============Alterar ordem da coluna==============");
                    System.out.print("Digite o ID do coluna: ");
                    id = scanner.nextLong();
                    System.out.print("Digite a ordem que deseja colocar a coluna: ");
                    var newOrder = scanner.nextInt();
                    columnDAO.updateOrderColumnBoard(id, newOrder);
                    System.out.println("=================================");
                    break;
                case 5:
                    System.out.println("============Renomear Coluna==============");
                    System.out.print("Digite o ID do coluna: ");
                    id = scanner.nextLong();
                    System.out.print("Digite o novo nome: ");
                    var newName = scanner.next();
                    columnDAO.updateNameColumnBoard(id, newName);
                    System.out.println("=================================");
                    break;
                case 6:
                    System.out.println("============Listar Cards==============");
                    cardDAO.selectCards();
                    System.out.println("=================================");
                    break;
                case 7:
                    System.out.println("============Adicionar Card==============");
                    System.out.print("Digite o titulo do novo card: ");
                    var title = scanner.next();
                    System.out.print("Digite a descricao: ");
                    var desc = scanner.next();
                    cardDAO.insertCard(title, desc);
                    System.out.println("=================================");
                    break;
                case 8:
                    System.out.println("============Remover Card==============");
                    System.out.print("Digite o ID do card: ");
                    id = scanner.nextLong();
                    cardDAO.deleteCard(id);
                    System.out.println("=================================");
                    break;
                case 9:
                    System.out.println("============Mover Card==============");
                    System.out.print("Digite 0 para fazer o downgrade ou 1 para update: ");
                    var mov = scanner.nextInt();
                    while (mov!=1 && mov!=0){
                        System.out.print("Opção incorreta, digite 0 para fazer o downgrade ou 1 para update: ");
                        mov = scanner.nextInt();
                    }
                    System.out.print("Digite o ID do card: ");
                    id = scanner.nextLong();
                    if(mov==1){
                        cardDAO.updateCardColumn(id);
                    }else{
                        cardDAO.downgradeCardColumn(id);
                    }
                    System.out.println("=================================");
                    break;
                case 10:
                    System.out.println("============Cancelar Card==============");
                    System.out.print("Digite o ID do card: ");
                    id = scanner.nextLong();
                    cardDAO.cancelCard(id);
                    System.out.println("=================================");
                    break;
                case 11:
                    System.out.println("============Bloquear/desbloquear card==============");
                    System.out.print("Digite 0 para bloquear ou 1 para desbloquear: ");
                    var block = scanner.nextInt();
                    while (block!=1 && block!=0){
                        System.out.print("Opção incorreta, Digite 0 para bloquear ou 1 para desbloquear: ");
                        block = scanner.nextInt();
                    }
                    System.out.print("Digite o ID do card: ");
                    id = scanner.nextLong();
                    var cause = "";
                    if(block==1){
                        System.out.print("Digite a causa do desbloqueio: ");
                        cause = scanner.next();
                        blockDAO.insertUnblock(id, cause);
                    }else{
                        System.out.print("Digite a causa do bloqueio: ");
                        cause = scanner.next();
                        blockDAO.insertBlock(id, cause);
                    }
                    System.out.println("=================================");
                    break;
                case 12:
                    System.out.println("===========Relatorio Cards==============");
                    cardDAO.selectAllCards();
                    System.out.println("=======================================");
                default:
                    break;
            }


        }while(option != 0);
    }

}
