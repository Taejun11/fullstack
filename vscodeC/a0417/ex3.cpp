#include <stdio.h>
#include <string.h>

int main()
{
    char str[100];
    int length;
    char temp;
    printf("문자열을 입력하세요: ");
    scanf("%s", str);
    length = strlen(str);
    printf("문자 개수: %d\n", length);

    for (int i = 0; i < length/2; i++)
    {
        temp = str[i];
        str[i] = str[length-1-i];
        str[length-1-i] = temp;
    }
    printf("바뀐 문자열: %s", str);

    return 0;
}
