#include <stdio.h>

int fact(int n){
    if (n <= 0)
    {
        return 1;
    }else{
        return n * fact(n-1);
    }
}

int main(){
    int n;
    printf("정수 입력: ");
    scanf("%d", &n);
    int result = fact(n);
    printf("입력한 숫자 %d의 팩토리얼 값: %d", n, result);
    return 0;
}
