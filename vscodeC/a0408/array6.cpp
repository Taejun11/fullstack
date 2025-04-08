#include <stdio.h>

int main(){
    int mynums[] = {25, 50, 75, 100};
    int length = sizeof(mynums) / sizeof(mynums[0]);
    // int 4바이트, mynums = 16바이트
    // printf("%d", mynums[0]);

        printf("%d\n", length);


    return 0;
}
