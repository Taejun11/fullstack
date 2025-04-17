#include <stdio.h>

int main(){
    int a, b, c, d, e;
    printf("다섯 수 입력: ");
    scanf("%d %d %d %d %d", &a, &b, &c, &d, &e);
    int max = a;
    if (max < b)
    {
        max = b;
    }
    if (max < c)
    {
        max = c;
    }
    if (max < d)
    {
        max = d;
    }
    if (max < e)
    {
        max = e;
    }

    printf("가장 큰 수: %d", max);
    
    return 0;
}