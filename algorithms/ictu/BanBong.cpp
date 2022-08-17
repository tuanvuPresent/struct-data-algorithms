#include<iostream>

using namespace std;
int arr[31];
int res = 0;

void backtrack(int k,int n,int sum){
	if(k>=n){
		if(res < sum) res = sum;
		return;
	}
	//th1
	if(arr[k+1] > arr[n]){
		backtrack(k+2,n,sum+arr[k]);
	}else{
		backtrack(k+1,n-1,sum+arr[k]);
	}	
	//th2
	if(arr[k] > arr[n-1]){
		backtrack(k+1,n-1,sum+arr[n]);
	}else{
		backtrack(k,n-2,sum+arr[n]);
	}	
}

int main(){
	//input
	int n;cin>>n;
	for(int i=0;i<n;i++)cin>>arr[i];
	//handle
	backtrack(0,n - 1,0);
	//show output
	cout<<res;
	
	return 0;
}

