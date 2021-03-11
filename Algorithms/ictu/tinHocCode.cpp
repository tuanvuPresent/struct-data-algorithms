#include <iostream>
#include <string.h>

using namespace std;
char s[101][64];

int soSanh(char s1[] , char s2[]){
	int n = strlen(s1);
	int m = strlen(s2);
	if(n!=m)return 0;
	int i=0;
	while(i<n){
		if(s1[i]!=s2[i]) return 0;
		i++;	
	}
	
	return 1;
}


int main(){
	int n;cin>>n;
	cin>>s[0];
	cout<<"OK\n";
	for(int i=1; i<n;i++){
		//so sanh
		cin>>s[i];
		int count = 0;
		for(int j=0;j<i;j++){
			if(soSanh(s[j],s[i])){
				count++;
			}
		}
		if(count==0){
			cout<<"OK\n";
		}else{
			cout<<s[i]<<count<<"\n";
		}
	}
	
	return 0;
}

