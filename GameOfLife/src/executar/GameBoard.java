package executar;

import java.util.Random;

class GameBoard {

    private int[][] board;

    public GameBoard(int tamanho) {
        board = new int[tamanho][tamanho];
    }

    public int[][] getBoard() {
        return board;
    }
    
    public int getTamanho(){
        return board.length;
    }

    public int getField(int x, int y) {
        return board[x][y];
    }

    public void setField(int x, int y, int valor) {
        board[x][y] = valor;
    }

    public void initGameBoard(double density) {
        Random random = new Random();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                if (random.nextDouble() > density) {
                    board[x][y] = 1;
                }
            }
        }
    }

    public void proximaPopulacao() {
        int[][] novoBoard = new int[board.length][board.length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                novoBoard[x][y] = getField(x, y); //Copy value into new board
                checarBoard(x, y, novoBoard);
            }
        }
        board = novoBoard;
    }

    private void checarBoard(int x, int y, int[][] novoBoard) {

        int[] indexX = {-1,0 ,1 ,-1,1 ,-1,0 ,1 };
        int[] indexY = {1 ,1 ,1 ,0 ,0 ,-1,-1,-1};
         
        int valorField = board[x][y];
         
        int vizinhanca = 0;
        for(int i=0;i<8;i++) {
            if(x+indexX[i]>=0 && y+indexY[i]>=0 && x+indexX[i]<board.length && y+indexY[i]<board.length) {
                vizinhanca = vizinhanca + getField(x+ indexX[i], y+indexY[i]);
            }
        }
        
        if(valorField == 0 && vizinhanca == 3){
            novoBoard[x][y] = 1;
            return;
        }
        
        if(valorField == 1 && (vizinhanca == 2 || vizinhanca == 3)){
            return;
        }
        
        if(valorField == 1 && vizinhanca > 3){
            novoBoard[x][y] = 0;
            return;
        }
        
        if(valorField == 1 && vizinhanca < 2){
            novoBoard[x][y] = 0;
            return;
        }
    }

}
