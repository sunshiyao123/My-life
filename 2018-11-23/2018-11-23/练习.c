#define _CRT_SECURE_NO_DEPRECATE
#include <stdlib.h>
#include<stdio.h>

//int main()
//{
//	int arr[10] = { 0 };
//	printf("%d ", sizeof(arr));  //40
//	printf("%d ", sizeof(int[10]));  //40    //int [10] 是一种类型
//	printf("%d ", sizeof(int[5]));  //20
//	system("pause");
//	return 0;
//}

//int main()
//{
//	int a = 0x11223344;   //44332211   小端存储
//	system("pause");
//	return 0;
//}

//int CheckSys()    //判断大小端
//{
//	int a = 1;
//	return *(char*)&a;  //小端返回1   大端返回0
//}
//int main()
//{
//	if (CheckSys() == 1)
//		printf("小端\n");
//	else
//		printf("大端\n");
//	system("pause");
//	return 0;
//}

//union un
//{
//	int i;
//	char c;
//}u;
//
//int main()
//{
//	union un u;
//	printf("%d\n", sizeof(u));   //4  算出来
//	printf("%p\n", &(u.i));
//	printf("%p\n", &(u.c));    //地址一样   联合体成员共用一块空间
//	system("pause");
//	return 0;
//}

//int CheckSys()    //判断大小端
//{
//	union 
//	{
//		int i;
//		char c;
//	}u;
//	u.i = 1;
//	return u.c;   //占用一块空间，则c所占空间就是i第一空间
//}
//int main()
//{
//	if (CheckSys() == 1)
//		printf("小端\n");
//	else
//		printf("大端\n");
//	system("pause");
//	return 0;
//}

//int main()
//{
//	char a = -1;            
//	signed char b = -1;        //11111111   整形提升  11111111111111111111111111111111
//	unsigned char c = -1;             //11111111   整形提升  00000000000000000000000011111111   (按照符号位提升）
//	printf("%d %d %d", a, b, c);   -1 -1 255
//	system("pause");
//	return 0;
//}


//int main()
//{
//	char a = -128;             // 10000000000000000000000010000000
//	printf("%u\n", a);         // 11111111111111111111111101111111
//	system("pause");           // 11111111111111111111111110000000 
//	return 0;                  //  10000000  --a  整形提升   11111111111111111111111110000000   %u认为是无符号数
//}


//int main()
//{
//	char a = 128;  
//	printf("%u\n", a);   
//	system("pause");    
//	return 0;              
//}
//char a
//000000000     0
//000000001     1
//000000010     2
//..
//011111111    127
//100000000   -128   算不出来
//100000001   -127   
//100000010   -126
//..
//111111101    -3
//111111110    -2
//111111111    -1
//
//int main()
//{
//	char a = -128;                   // 10000000             11111111 11111111 11111111 10000000
//	unsigned char b = -128;          // 10000000             00000000 00000000 00000000 10000000
//	printf("%u   ", a);  //很大
//	printf("%u   ", b);  //128
//	printf("%d   ", a);  //-128
//	printf("%d   ", b);  //128
//	system("pause");
//	return 0;
//}

//int main()
//{
//	unsigned int i = 0;    //无符号
//	for (i = 9; i >= 0; i--)  //i=0时--当作正数处理
//	{
//		printf("%u\n", i);
//	}
//	system("pause");  //死循环
//	return 0;
//}
//
//int main()
//{
//	char a[1000];  //最小值为-128走到0时候则会停止，圈倒着走
//	int i = 0;
//	for (i = 0; i < 1000; i++)
//	{
//		a[i] = -1 - i;
//	}
//	printf("%d\n", strlen(a));   //遇到0的时候就会停止					
//	system("pause");
//	return 0;
//}
//
//int main()
//{
//	unsigned char i = 0;    //无符号得char取值范围为0到255
//	for (i = 0; i <= 255; i++)
//	{
//		printf("hehe\n");
//	}
//	system("pause");
//	return 0;
//}
