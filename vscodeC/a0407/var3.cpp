#include <stdio.h>

int main()
{
    int myNum = 15;
    float myFloatNum = 5.99;
    char myC = 'd';
    // printf(myNum); 안됨
    printf("%d\n", myNum);
    printf("%f\n", myFloatNum);
    printf("%c\n", myC); //됨
    return 0;
}
