#include <stdio.h>
#include <string.h>

int main()
{
    char str1[] = "hello";
    char str2[20]= "hello";
    char str3[] = "hi";
    
    printf("%d\n", strcmp(str1, str2));
    printf("%d\n", strcmp(str1, str3));

    return 0;
}
