#include <stdio.h>

int main(){   
    int myage = 34;
    int *ptr = &myage;
    printf("%p\n", &myage);
    printf("%p\n", myage);
    printf("%p\n", ptr);
    
    return 0;
}
