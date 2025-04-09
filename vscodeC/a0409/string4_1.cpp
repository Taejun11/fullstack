#include <stdio.h>

int main()
{
    char car[] = "Volvo";
    int length = sizeof(car) / sizeof(car[0]);
    for (int i = 0; i < length; i++)
    {
        printf("%c", car[i]);
    }
    
    
    return 0;
}
