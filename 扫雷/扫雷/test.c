#define _CRT_SECURE_NO_DEPRECATE
#include "game.h"
int main()
{
	test();
	system("pause");
	return 0;
}

void test()
{
	srand((unsigned int)time(NULL));
	int input = 1;
	do
	{
		menu();
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("��Ϸ���������˳���\n");
			break;
		default:
			printf("�����������������룺\n");
			break;
		}
	} while (input);
}

