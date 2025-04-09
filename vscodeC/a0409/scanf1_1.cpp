#include <stdio.h>
#include <string.h>

int main()
{
    int mynum;
    char mychar;
    printf("Type a number and char and press enter: \n");
    scanf("%d %c", &mynum, &mychar);
    printf("number: %d\n", mynum);
    printf("char: %c\n", mychar);

    return 0;
}
