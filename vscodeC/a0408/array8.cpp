#include <stdio.h>

int main(){
    int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};
    // int min = 100;
    int min = ages[0];
    int length = sizeof(ages) / sizeof(ages[0]);

    for (int i = 0; i < length; i++)
    {
        if (ages[i] < min)
        {
            min = ages[i];
        }
        
    }
    printf("최소나이: %d", min);

    return 0;
}
