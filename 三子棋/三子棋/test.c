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
	int input = 0;
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
			printf("即将退出游戏");
			break;
		default:
			printf("输入错误，请重新输入：");
			break;
		}
	} while (input);
}