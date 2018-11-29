//1.写一个函数返回参数二进制中 1 的个数
//比如： 15 0000 1111 4 个 1
//程序原型：
//int count_one_bits(unsigned int value)
//{
//	// 返回 1的位数 
//}

//#define _CRT_SECURE_NO_DEPRECATE
//#include <stdlib.h>
//#include<stdio.h>
//int count_one_bits(unsigned int value)
//{
//	int c = 0;
//	int count = 0;
//	while (value)
//	{
//	c = value & 1;
//	if (c == 1)
//	{
//		count++;
//	}
//
//	value = value >> 1;
//	}
//	return count;
//}
//int main()
//{
//	int a = 0;
//	int b = 0;
//	printf("请输入一个数字：");
//	scanf("%d", &a);   
//	b = count_one_bits(a);
//	printf("这个数字二进制中1的个数为：%d\n", b);
//	system("pause");
//	return 0;
//}

//2.获取一个数二进制序列中所有的偶数位和奇数位，
//分别输出二进制序列。
//#define _CRT_SECURE_NO_DEPRECATE
//#include <stdlib.h>
//#include<stdio.h>
//int main()
//{
//	int arr1[16];
//	int arr2[16];
//	int i = 0;
//	int j = 0;
//	int num = 0;
//	printf("请输入一个数字：");
//	scanf("%d", &num);
//	for (i = 0; i < 32; i += 2)
//	{
//		arr1[j] = (num >> i) & 1;
//		j++;
//	}
//	for (i = 1,j = 0; i < 32; i += 2)
//	{
//		arr2[j] = (num >> i) & 1;
//		j++;
//	}
//	printf("该数二进制奇数位上的数字为：");
//	for (j = 0; j < 16; j++)
//	{
//		printf("%d ", arr1[j]);
//	}
//	printf("\n");
//	printf("该数二进制偶数位上的数字为：");
//	for (j = 0; j < 16; j++)
//	{
//		printf("%d ", arr2[j]);
//	}
//	printf("\n");
//	system("pause");
//	return 0;
//}

//3.输出一个整数的每一位
//#define _CRT_SECURE_NO_DEPRECATE
//#include <stdlib.h>
//#include<stdio.h>
//int main()
//{
//	int num = 0;
//	printf("请输入一个数字：");
//	scanf("%d", &num);
//	while (num)
//	{
//		printf("%d ", num % 10);
//		num /= 10;
//	}
//	system("pause");
//	return 0;
//}


//4.两个int（32位）整数m和n的二进制表达中，有多少个位(bit)不同？ 
//#define _CRT_SECURE_NO_DEPRECATE
//#include <stdlib.h>
//#include<stdio.h>
//int main()
//{
//	int a = 0;
//	int b = 0;
//	int c = 0;
//	int i = 0;
//	int count = 0;
//	printf("请输入两个数：");
//	scanf("%d %d", &a, &b);
//	c = a ^ b;
//	for (i = 0; i < 32; i++)
//	{
//		 if ((c >> i) & 1 == 1)
//			count++;
//	}
//	printf("二进制位不一样的位数有%d\n", count);
//	system("pause");
//	return 0;
//}

