#ifndef _GMAE_H__
#define _GAME_H__

#define _CRT_SECURE_NO_DEPRECATE
#include<stdlib.h>
#include<stdio.h>
#include<time.h>
#include<string.h>
#define ROW 9     //棋盘行数
#define COL 9     //棋盘列数
#define ROWS ROW+2
#define COLS COL+2  
#define COUNT 10   //布置的雷的个数

void InitBoard(char board[ROWS][COLS], int rows, int cols, char ret);         //初始化棋盘
void DisplayBoard(char board[ROWS][COLS], int row, int col);                  //打印棋盘
void SetMine(char board[ROWS][COLS], int row, int col);                       //布雷
void FindMine(char mine[ROWS][COLS], char show[ROWS][COLS], int row, int col);//扫雷
int GetMine(char a[ROWS][COLS], int x, int y);                                //获得周围八个格子雷的个数
void SpreadBoard(char mine[ROWS][COLS], char show[ROWS][COLS], int row, int col, int x, int y);//展开函数
void RemarkBoard(char show[ROWS][COLS], int row, int col);                    //标记函数
int CountShow(char mine[ROWS][COLS], int row, int col);                       //判断当前剩余未判断的格子

void game();
void test();
void menu();

#endif  //_TEST_H__