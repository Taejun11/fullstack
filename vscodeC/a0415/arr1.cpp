#include <stdio.h>
// #include <iostream>
// using namespace std;

int main()
{
    int arr[5] = {};
    int max;
    printf("숫자 5개를 입력하세요: ");
    for (int i = 0; i < 5; i++)
    {
        scanf("%d", &arr[i]);
    }
    max = arr[0];

    for (int i = 0; i < 5; i++)
    {
        if (arr[i] > max)
        {
            max = arr[i];
        }
    }
    printf("가장 큰 수: %d\n" , max);
    
    return 0;
}
