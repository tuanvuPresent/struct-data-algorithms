#include <iostream>
#include <string.h>

using namespace std;
void longestCommonSubstring()
{
    int F[20][20] = { 0 };
    char s1[20] = "abc1def2ghi3a";
    char s2[20] = "abcdefghi3";
    //ouput : abcdefghi3
    int lenA = strlen(s1);
    //    while (s1[lenA] != '\0') {
    //        lenA++;
    //    }
    int lenB = strlen(s2);
    //    while (s2[lenB] != '\0') {
    //        lenB++;
    //    }
    //dynamic program
    /*
		F[i][j] : day 1 co i phan tu, day 2 co j phan tu
					F[i][j] = max (F[i-1][j], F[i][j-1])  neu s1[i] != s2[j]
							= F[i-1][j-1] + 1
		*/
    int pos = 0;
    for (int i = 1; i <= lenA; i++) {
        for (int j = 1; j <= lenB; j++) {
            if (s1[i - 1] != s2[j - 1]) {
                F[i][j] = max(F[i][j - 1], F[i - 1][j]);
            }
            else {
                F[i][j] = F[i - 1][j - 1] + 1;
            }
            cout << F[i][j] << " ";
        }
        cout << "\n";
    }
    //show output
    cout << F[lenA][lenB] << "\n";
    //truy vet
    int x = lenA, y = lenB;
    while (F[x][y] != 0) {
        if (F[x][y - 1] == F[x - 1][y] && F[x - 1][y - 1] == F[x][y - 1] && s1[x - 1] == s2[y - 1]) {
            cout << s1[x - 1] << " ";
        }
        if (F[x][y - 1] == F[x - 1][y] && F[x - 1][y - 1] == F[x][y - 1]) {
            x--;
            y--;
        }
        else if (F[x][y - 1] < F[x - 1][y]) {
            x--;
        }
        else {
            y--;
        }
    }
}

int main()
{
    longestCommonSubstring();

    return 0;
}