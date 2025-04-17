#include <stdio.h>

int main(){
    int a, b;
    printf("두 수 입력: ");
    scanf("%d %d", &a, &b);
    printf("두 수의 합: %d\n", a+b);
    printf("두 수의 차: %d\n", a-b);
    printf("두 수의 곱: %d\n", a*b);
    printf("두 수의 나누기 몫: %d\n", a/b);
    printf("두 수의 나누기 나머지: %d\n", a%b);
    return 0;
}