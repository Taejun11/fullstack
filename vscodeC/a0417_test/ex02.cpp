#include <stdio.h>

int main(){
    int a;
    printf("정수 입력: ");
    scanf("%d", &a);

    if (a % 2 == 0)
    {
        printf("입력한 숫자는 짝수\n");
    }else{
        printf("입력한 숫자는 홀수\n");
    }
    
    return 0;
}