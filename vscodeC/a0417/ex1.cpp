#include <stdio.h>

int main()
{
    int num;
    int sum = 0;
    printf("양의 정수를 입력해주세요: ");
    scanf("%d", &num);

    if (num < 0)
    {
        printf("양의 정수를 입력해주십시오. \n");
        return 1;
    }

    while (num > 0)
    {
        sum = sum + (num % 10);
        num = num / 10;
    }
    printf("%d", sum);
    
    

    return 0;
}
