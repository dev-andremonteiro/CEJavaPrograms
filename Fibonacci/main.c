#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char** argv) {

    int x;
    int a = 0;
    int b = 1;
    int c = 0;
    clock_t inicio, fim;
    int temp;
    
    scanf("%d",&x);
    
    inicio= clock();

    for(x;x<=0;x--){
        c = a;
        a = b;
        b = c+a;
        printf("%d \n",b);
    }

    fim= clock();

    temp = ((fim - inicio)/CLOCKS_PER_SEC );
    
    printf(temp);
    
    return (EXIT_SUCCESS);
}

