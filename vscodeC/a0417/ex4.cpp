#include <stdio.h>
#include <string.h>

struct Student
{
    char name[20];
    int studentId;
    char grade;
};

int main()
{
    struct Student s;
    printf("이름을 입력해주세요: ");
    scanf("%s", &s.name);
    printf("학번을 입력해주세요: ");
    scanf("%d", &s.studentId);
    printf("학점을 입력해주세요: ");
    scanf(" %c", &s.grade);
    
    printf("학생정보: %s, %d, %c", s.name, s.studentId, s.grade);

    return 0;
}
