#include <stdio.h>
// #include <iostream>
// using namespace std;


// 정수 n을 구하여 n!(팩토리얼)을 구하시오
// 재귀함수 이용
int pact(int n){
    if (n <= 0)
    {
        return 1;
    }else{
        return n * pact(n-1);
    }
    
}

int main()
{
    int n;
    printf("숫자 1개를 입력하세요: ");
    scanf("%d", &n);
    int result = pact(n);
    printf("%d의 팩토리얼: %d", n, result);
    
    return 0;
}
