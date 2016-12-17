package conceito;

public class Matriz{
    
    int[][] mat;
    int x;
    
    public Matriz(int x){
        this.x = x;
        mat = new int[x][x];
        int y,z;
        
        for(y=0;y<x;y++){
            for(z=0;z<x;z++){
                mat[y][z] = 0;
            }
        }
        
    }
    
    public void inserirMatriz(boolean x,int lin,int col){
            if(x)mat[lin][col] = 1;
            else mat[lin][col] = -1;
    }
    
    public void imprimirMatriz(){
        int y,z;
        System.out.println("\n");
        for(y=0;y<x;y++){
            
            for(z=0;z<x;z++){
                System.out.print(" | "+tratar(mat[z][y]));
            }
            System.out.println(" |");
        }
    }
    
    public char tratar(int x){
        if(x == 1) return 'X';
        else if(x == -1) return 'O';
        return ' ';
    }
    
    public int winner(){
        int lin,col,z;
        int[] dia,soma;
        dia = new int[2];
        soma =new int[6];
        
        for(col = 0;col<x;col++){
            
            for(lin = 0;lin<x;lin++){
                
                soma[col] = soma[col] + mat[lin][col];
                
                if(lin == col){
                    dia[0] = dia[0] + mat[lin][col];
                }
                if((lin + col) == (x-1)){
                    dia[1] = dia[1] + mat[lin][col];
                }
                
            }
            
        }
        
        for(col = 0;col<x;col++){
            for(z=0;z<x;z++){
                    soma[z+x] = soma[z+3] + mat[z][col];
            }
        }
        
        
        for(z=0;z<(x*2);z++){
            if(soma[z] == 3) return 3;
            if(soma[z] == -3) return -3;
        }
        
        for(z=0;z<2;z++){
            if(dia[z] == 3) return 3;
            if(dia[z] == -3) return -3;
        } 
        
            
        return 0;
    }
    
    public boolean verificar(int lin,int col){
        
        return mat[lin][col] != 0;
    }
    
}
