1.去除字符串尾端空格
trim()方法去掉的是首尾空格（含tab等），如果只去掉尾端，可以考虑遍历字符串，找到最后一个非' '的位置idx，然后取s.substring(0, idx+1)
=====================
2.split方法注意
复数的分割：int r1 = Integer.valueOf(a.split("\\+")[0]);

