#include <stdio.h>

int main(){
    int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};
    float avg, sum = 0;
    int length = sizeof(ages) / sizeof(ages[0]);

    for (int i = 0; i < length; i++)
    {
        sum += ages[i];
    }
    avg = sum / length;
    printf("평균나이: %.2f", avg);

    return 0;
}
