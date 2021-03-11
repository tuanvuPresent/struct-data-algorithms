#include <iostream>
#include <string.h>

using namespace std;
int a[1001];
int b[1001];
int F[1001][1001] = { 0 };
void dayConChungDaiNhat(int n,int m)
{
    /*
		F[i][j] : day 1 co i phan tu, day 2 co j phan tu
					F[i][j] = max (F[i-1][j], F[i][j-1])  neu s1[i] != s2[j]
							= F[i-1][j-1] + 1
		*/
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (a[i] != b[j]) {
                F[i][j] = max(F[i][j - 1], F[i - 1][j]);
            }
            else {
                F[i][j] = F[i - 1][j - 1] + 1;
            }
//            cout << F[i][j] << " ";
        }
//        cout << "\n";
    }
    //show output
    cout << F[n][m] << "\n";

}

int main()
{
    int n,m;cin>>n>>m; 
    for(int i=1;i<=n;i++) cin>>a[i];
    for(int i=1;i<=m;i++) cin>>b[i];
    dayConChungDaiNhat(n,m);

    return 0;
}
