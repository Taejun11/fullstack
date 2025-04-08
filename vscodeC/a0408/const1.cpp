#include <stdio.h>

int main(){
    const int myNum = 15;
    // myNum = 10; //오류
    // const int minutesPerHour;
    // minutesPerHour = 60; //오류
    const int minutesPerHour = 60;
    printf("%d", myNum);
    return 0;
}
