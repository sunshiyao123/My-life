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
			printf("游戏结束即将退出。\n");
			break;
		default:
			printf("输入有误请重新输入：\n");
			break;
		}
	} while (input);
}

