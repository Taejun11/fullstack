#include <stdio.h>

int main(){
    int mynums[4];
    mynums[0] = 25;
    mynums[1] = 50;
    mynums[2] = 75;
    mynums[3] = 100;

    for (int i = 0; i < 4; i++)
    {
        printf("%d\n", mynums[i]);
    }

    return 0;
}
