#include <stdio.h>

int main(){
    int mynums[] = {25, 50, 75, 100};
    // int 4바이트, mynums = 16바이트
    // printf("%d", mynums[0]);

        printf("%lu\n", sizeof(mynums));


    return 0;
}
