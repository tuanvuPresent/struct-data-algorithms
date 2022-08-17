#include<iostream>

using namespace std;
	
	int stair[100001]={0};
	long long res[100001]={0};
	

int main(){
	//initial
	int stairNumber; cin>>stairNumber;
	int brokenStairNumber; cin>>brokenStairNumber;
	for(int i=0; i<brokenStairNumber; i++){
		int pos; cin>>pos;
		stair[pos]=1;
	}
	//Dynamic planning
	res[0]=0;
	res[1]=1;
	for(int i=2; i<=stairNumber; i++){
		if(stair[i]==0){
			res[i]= res[i-1]+ res[i-2];
			res[i]=res[i]%14062008;
		}
	}
	//output
	cout<<res[stairNumber];
	
	return 0;
}
