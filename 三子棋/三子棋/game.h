#ifndef _GMAE_H__
#define _GAME_H__

#define _CRT_SECURE_NO_DEPRECATE
#include <stdlib.h>
#include<stdio.h>
#include<time.h>
#include<string.h>
#define ROW 3
#define COL 3

void InitBoard(char Board[ROW][COL], int row, int col);   //初始化数组
void DisplayBoard(char Board[ROW][COL], int row, int col);
void PlayerMove(char Board[ROW][COL], int row, int col);
void ComputerMove(char Board[ROW][COL], int row, int col);
char IsWin(char Board[ROW][COL], int row, int col);

void game();
void test();
void menu();



#endif  //_TEST_H__