#include <stdio.h>

int main(){
    int mynums[] = {25, 50, 75, 100};
    mynums[0] = 33;
    // printf("%d", mynums[0]);

    for (int i = 0; i < 4; i++)
    {
        printf("%d\n", mynums[i]);
    }

    return 0;
}
