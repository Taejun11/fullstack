#include <stdio.h>

int main(){
    for (int i = 0; i <= 2; i++)
    {
        for (int j = 0; j <= 3; j++)
        {
            printf("inner : %d\n", j);
        }
        printf("outer : %d\n", i);
    }

    return 0;
}
