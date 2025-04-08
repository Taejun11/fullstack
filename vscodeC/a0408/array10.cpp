#include <stdio.h>

int main(){
    int matrix[2][3] = {
        {1,4,2},
        {3,6,8}
    };
    for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            printf("%d\n", matrix[i][j]);
        }
        
    }
    

    return 0;
}
