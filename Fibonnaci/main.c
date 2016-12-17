#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {

    int x;
    int a = 0;
    int b = 1;
    int c = 0;
    
    scanf("%d",&x);
    
    for(x;x<=0;x--){
        c = a;
        a = b;
        b = c+a;
        printf("%d \n",b);
    }
    
    
    return (EXIT_SUCCESS);
}

