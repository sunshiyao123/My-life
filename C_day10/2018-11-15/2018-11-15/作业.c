//1.дһ���������ز����������� 1 �ĸ���
//���磺 15 0000 1111 4 �� 1
//����ԭ�ͣ�
//int count_one_bits(unsigned int value)
//{
//	// ���� 1��λ�� 
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
//	printf("������һ�����֣�");
//	scanf("%d", &a);   
//	b = count_one_bits(a);
//	printf("������ֶ�������1�ĸ���Ϊ��%d\n", b);
//	system("pause");
//	return 0;
//}

//2.��ȡһ�������������������е�ż��λ������λ��
//�ֱ�������������С�
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
//	printf("������һ�����֣�");
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
//	printf("��������������λ�ϵ�����Ϊ��");
//	for (j = 0; j < 16; j++)
//	{
//		printf("%d ", arr1[j]);
//	}
//	printf("\n");
//	printf("����������ż��λ�ϵ�����Ϊ��");
//	for (j = 0; j < 16; j++)
//	{
//		printf("%d ", arr2[j]);
//	}
//	printf("\n");
//	system("pause");
//	return 0;
//}

//3.���һ��������ÿһλ
//#define _CRT_SECURE_NO_DEPRECATE
//#include <stdlib.h>
//#include<stdio.h>
//int main()
//{
//	int num = 0;
//	printf("������һ�����֣�");
//	scanf("%d", &num);
//	while (num)
//	{
//		printf("%d ", num % 10);
//		num /= 10;
//	}
//	system("pause");
//	return 0;
//}


//4.����int��32λ������m��n�Ķ����Ʊ���У��ж��ٸ�λ(bit)��ͬ�� 
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
//	printf("��������������");
//	scanf("%d %d", &a, &b);
//	c = a ^ b;
//	for (i = 0; i < 32; i++)
//	{
//		 if ((c >> i) & 1 == 1)
//			count++;
//	}
//	printf("������λ��һ����λ����%d\n", count);
//	system("pause");
//	return 0;
//}

