// #include <stdio.h>
#include <iostream>
using namespace std;

int main()
{
    int a,b,c;
    int max;
    // printf("세 수를 입력하세요: ");
    // scanf("%d %d %d", &a, &b, &c);
    cout << "세 수를 입력하세요: ";
    cin >> a >> b >> c;
    max = a;
    if (b > max)
    {
        max = b;
    }
    if (c > max)
    {
        max = c;
    }
    // printf("가장 큰 수: %d\n" , max);
    cout << "가장 큰 수: " << max;
    
    return 0;
}
