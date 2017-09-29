package java07;

public class ex07_11_자리예약2차원 {
    public static void main(String[] args){
        int [][] seat= new int[5][4];
        int s = 1;
        int a = 0;
        int b = 0;
        
        for(int i = 0; i<5; i++){
            for(int j=0; j<4; j++){
                seat[i][j] = s++;
            }
        }
        for(int i = 0; i<5; i++){
            for(int j=0; j<4; j++){
                System.out.print(seat[i][j]+", ");
            }
        }
        System.out.println();
        for(int i=0; i<5; i++){
            for(int j=0; j<4; j++){
                a = (int)(Math.random()*5);
                b = (int)(Math.random()*4);
                
                int tmp = seat[a][b];
                seat[a][b] = seat[i][j];
                seat[i][j] = tmp;
                
            }
        }
        
        System.out.format("                        |-------------------|                     \n" );
        System.out.format("                        |      스크린       |                     \n" );
        System.out.format("                        |-------------------|                     \n" );
        System.out.format("                                                                  \n" );
        System.out.format("|---------|---------|---------|    |---------|---------|---------|\n", 0, 0, 0, 0, 0, 0 );
        System.out.format("|    %2d   |   %2d    |   %2d    |    |   %2d    |   %2d    |   %2d    |\n", seat[0][0], seat[0][1], seat[0][2], seat[0][3], seat[1][0], seat[1][1] );
        System.out.format("|---------|---------|---------|    |---------|---------|---------|\n", 0, 0, 0, 0, 0, 0 );
        System.out.format("|    %2d   |   %2d    |   %2d    |    |   %2d    |   %2d    |   %2d    |\n", seat[1][2], seat[1][3], seat[2][0], seat[2][1], seat[2][2], seat[2][3] );
        System.out.format("|---------|---------|---------|    |---------|---------|---------|\n", 0, 0, 0, 0, 0, 0 );
        System.out.format("          |   %2d    |   %2d    |    |   %2d    |   %2d    |   %2d    |\n", seat[3][0], seat[3][1], seat[3][2], seat[3][3], seat[4][0], 0 );
        System.out.format("          |---------|---------|    |---------|---------|---------|\n", 0, 0, 0, 0    );
        System.out.format("                                   |   %2d    |   %2d    |   %2d    |\n", seat[4][1], seat[4][2], seat[4][3]          );
        System.out.format("                                   |---------|---------|---------|\n" );
    }
    
}
