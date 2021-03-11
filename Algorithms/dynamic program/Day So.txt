#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n; cin >> n;
    int s[n+1];
    s[0] = 0;
    for (int i=1; i<=n; i++) {
        cin >> s[i];
        s[i] += s[i-1];
    }

    bool f[n+1];
    for (int i=n, smin = s[n]; i>0; i--) {
        f[i] = s[i-1] < smin;
        smin = min(smin, s[i-1]);
    }

    bool g[n+1];
    for (int i=1, smin = s[n]; i<=n; i++) {
        g[i] = s[i-1] < smin;
        smin = min(smin, s[i] + s[n]);
    }

    int count = 0;
    for (int i=1; i<=n; i++) count += f[i] && g[i];
    cout << count;

    return 0;
}
