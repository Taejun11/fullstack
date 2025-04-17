#include <stdio.h>

int main()
{
    int arr[10] = {5, 12, 8, 3, 15, 7, 9, 20, 1, 18};
    int sum = 0;
    int max = arr[0];
    int min = arr[0];
    double avg;
    int size = sizeof(arr) / sizeof(arr[0]);
    for (int i = 0; i < size; i++)
    {
        sum += arr[i];
        if (arr[i] > max)
        {
            max = arr[i];
        }
        if (arr[i] < min)
        {
            max = arr[i];
        }
        
    }
    avg = (double)sum / size;

    printf("합계: %d, 최대값: %d, 최소값: %d, 평균: %.2f", sum, max, min, avg);
    
    

    return 0;
}
