#define _CRT_SECURE_NO_DEPRECATE
#include <stdlib.h>
#include<stdio.h>

//int main()
//{
//	int arr[10] = { 0 };
//	printf("%d ", sizeof(arr));  //40
//	printf("%d ", sizeof(int[10]));  //40    //int [10] ��һ������
//	printf("%d ", sizeof(int[5]));  //20
//	system("pause");
//	return 0;
//}

//int main()
//{
//	int a = 0x11223344;   //44332211   С�˴洢
//	system("pause");
//	return 0;
//}

//int CheckSys()    //�жϴ�С��
//{
//	int a = 1;
//	return *(char*)&a;  //С�˷���1   ��˷���0
//}
//int main()
//{
//	if (CheckSys() == 1)
//		printf("С��\n");
//	else
//		printf("���\n");
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
//	printf("%d\n", sizeof(u));   //4  �����
//	printf("%p\n", &(u.i));
//	printf("%p\n", &(u.c));    //��ַһ��   �������Ա����һ��ռ�
//	system("pause");
//	return 0;
//}

//int CheckSys()    //�жϴ�С��
//{
//	union 
//	{
//		int i;
//		char c;
//	}u;
//	u.i = 1;
//	return u.c;   //ռ��һ��ռ䣬��c��ռ�ռ����i��һ�ռ�
//}
//int main()
//{
//	if (CheckSys() == 1)
//		printf("С��\n");
//	else
//		printf("���\n");
//	system("pause");
//	return 0;
//}

//int main()
//{
//	char a = -1;            
//	signed char b = -1;        //11111111   ��������  11111111111111111111111111111111
//	unsigned char c = -1;             //11111111   ��������  00000000000000000000000011111111   (���շ���λ������
//	printf("%d %d %d", a, b, c);   -1 -1 255
//	system("pause");
//	return 0;
//}


//int main()
//{
//	char a = -128;             // 10000000000000000000000010000000
//	printf("%u\n", a);         // 11111111111111111111111101111111
//	system("pause");           // 11111111111111111111111110000000 
//	return 0;                  //  10000000  --a  ��������   11111111111111111111111110000000   %u��Ϊ���޷�����
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
//100000000   -128   �㲻����
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
//	printf("%u   ", a);  //�ܴ�
//	printf("%u   ", b);  //128
//	printf("%d   ", a);  //-128
//	printf("%d   ", b);  //128
//	system("pause");
//	return 0;
//}

//int main()
//{
//	unsigned int i = 0;    //�޷���
//	for (i = 9; i >= 0; i--)  //i=0ʱ--������������
//	{
//		printf("%u\n", i);
//	}
//	system("pause");  //��ѭ��
//	return 0;
//}
//
//int main()
//{
//	char a[1000];  //��СֵΪ-128�ߵ�0ʱ�����ֹͣ��Ȧ������
//	int i = 0;
//	for (i = 0; i < 1000; i++)
//	{
//		a[i] = -1 - i;
//	}
//	printf("%d\n", strlen(a));   //����0��ʱ��ͻ�ֹͣ					
//	system("pause");
//	return 0;
//}
//
//int main()
//{
//	unsigned char i = 0;    //�޷��ŵ�charȡֵ��ΧΪ0��255
//	for (i = 0; i <= 255; i++)
//	{
//		printf("hehe\n");
//	}
//	system("pause");
//	return 0;
//}
