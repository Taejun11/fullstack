#include <iostream>
using namespace std;

class Calculator {
    public:
        int num1, num2;
        int plus(){
            return num1 + num2;
        };
        int minus(){
            return num1 - num2;
        };
        int multi(){
            return num1 * num2;
        };
        double div(){
            // if (num2 == 0)
            // {
            //     cout << "에러: 0으로 나눌 수 없음" << endl;
            //     return 0.0;
            // }
            
            return (double)(num1) / num2;
        };
        void setNum(int n1, int n2){
            num1 = n1;
            num2 = n2;
        }
};


int main()
{
    Calculator calc;
    int n1, n2;
    char op;
    cout << "두 개의 정수를 입력하세요:";
    cin >> n1 >> n2;
    calc.setNum(n1, n2);
    cout << "수행할 연산을 입력하세요(+, -, *, /):";
    cin >> op;
    // double result;
    // switch (op)
    // {
    //     case '+':
    //         result = calc.plus();
    //         break;
    //     case '-':
    //         result = calc.minus();
    //         break;
    //     case '*':
    //         result = calc.multi();
    //         break;
    //     case '/':
    //         result = calc.div();
    //         break;
    //     default:
    //         cerr << "에러: 기호 오류" << endl;
    //         break;
    // }

    try {
        double result;

        switch (op) {
            case '+':
                result = calc.plus();
                break;
            case '-':
                result = calc.minus();
                break;
            case '*':
                result = calc.multi();
                break;
            case '/':
                result = calc.div();  // 예외 발생 가능
                break;
            default:
                throw invalid_argument("Error: Invalid operation!");  // std:: 없이 사용
        }

        cout << "결과: " << result << endl;
    }
    catch (const exception& e) {
        cerr << "예외 발생: " << e.what() << endl;
        return 1;
    }


    // cout << "결과: " << result << endl;

    return 0;
}
