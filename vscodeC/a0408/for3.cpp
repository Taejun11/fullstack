#include <stdio.h>

int main(){
    // 2의 거듭제곱을 512까지 출력
    int s = 2;
    for (int i = 0; i <= 8; i++)
    {
        printf("%d\n", s);
        s *= 2;
    }

    return 0;
}
