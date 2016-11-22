﻿leetcode题解
----------------

1.枚举
2.高精度加法
3.找最长不含重复字符子串。逐位扫，保留最近检查位置上的子串。
4.二分查找
5.找最长回文子串
6.模拟
7.*10 %10，处理溢出问题
8.string转integer，注意处理正负，溢出问题
9.回文数字,*10,%10
10.正则匹配，用动规
11.柱状图中找最大矩形，以首尾为边界开始，往中间移动，贪心。
12.罗马数字表示，逐位转..
13.同上
14.最长公共前缀，先排序，取首尾元素比较。
15.找出数组中所有和为0的三数，先排序，再二分。
16.从数组中找出最接近给出数值的三数和，先排序，取定第一个数，再首尾取值，往中间移动，贪心。
17.回溯，无递归版。
18.同三数和，不过前两数通过枚举取定。
19.删除链表的倒数第n个元素。使用两相距n个元素的指针辅助。
20.判断括号组是否有效。使用栈，每逢组成一对就出栈。
21.合并两有序链表。使用dummy头指针，可方便操作。
22.求n组括号的所有组合数。回溯，能填左括号就先填左括号。
23.合并k个有序链表。分治，两链表两链表合并，使用21题的方法。
24.翻转链表的每两个相邻结点。模拟。
25.翻转链表的每k个相邻结点。模拟。
26.去除有序数组中的重复元素。
27.从数组中剔除指定元素值。
28.实现strStr()，两重循环，逐位匹。也可考虑用kmp。
29.不使用乘、除、取模操作下，实现除法运算。对除数进行循环累加，以指数增长的速度逼进被除数。
30.从一字符串中找出所有可由给定字符串组组合成的子串。使用字典辅助记数，逐位扫描，当某单词计划超标时，将左边界右移，至计数合理为止，然后继续扫描。
31.求一组数的下一排列。从右往左，找出第一对升序的数，然后把这对数及后面的数重排序为升序，即为下一排列。
32.
33.
34.
35.
36.
37.
38.
