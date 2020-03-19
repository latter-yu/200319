import java.util.Arrays;
import java.lang.System;

public class T200319 {
    public static void main(String[] args) {
        //arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        //将指定源数组中的数组从指定位置复制到目标数组的指定位置
        //src - 源数组
        //srcPos - 源数组中的起始位置
        //dest - 目标数组
        //destPos - 目的地数据中的起始位置
        //length - 要复制的数组元素的数量
        int[] array = {1,2,3,4,5};
        int[] dest = new int[array.length];
        //拷贝更快一点：native方法
        System.arraycopy(array,0,dest,0,array.length);//无输出
        System.out.println(Arrays.toString(dest));
        //[1, 2, 3, 4, 5]
    }

    public static void main4(String[] args) {
        //Arrays.equals(int[] a, int[] a2):
        //如果两个指定的int数组彼此相等，则返回 true
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.equals(arr1, arr2));//true
        System.out.println(arr1 == arr2);//false
        // == 判断的是两数组地址是否相同：false
        // Arrays.equals 判断两数组内容是否相同
    }

    public static void main3(String[] args) {
        //binarySearch(int[] a, int fromIndex, int toIndex, int key)
        //使用二叉搜索算法搜索指定值的指定数组的范围
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int key = 5;
        System.out.println(Arrays.binarySearch(arr, key));//2 (下标)
    }

    public static void main2(String[] args) {
        //Arrays.sort(int[] a):按照数字顺序排列指定的数组
        //Arrays.toString(int[] a):返回指定数组的内容的字符串表示形式
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //[1, 2, 3, 4, 5, 6, 7, 8]
    }

    /* 数组的拷贝：
     * 1、for
     * 打印数组的三种方式
     * a.for循环
     * b.for-each
     * c.Arrays.toString
     *
     * 2、System.arraycopy
     * (Object src, int srcPos, Object dest, int destPos, int length)
     * 将指定源数组中的数组从指定位置复制到目标数组的指定位置。
     * Object-->是所有类的父类
     * src:源数组
     * srcPos:源数组的开始拷贝的下标
     * dest：目的数组
     * destPos：拷贝到目的数组的这个下标
     * length：拷贝多大
     *
     * 3、Arrays.copyOf(int[] original, int newLength) ；
     * 复制指定的数组，用零截取或填充（如有必要），以便复制具有指定的长度。
     * 底层调用的方法是：System.arraycopy
     *
     * 4、了解：clone()--->Object
     * clone()
     * 创建并返回此对象的副本。
     *
     * 总结：
     * 以上4中拷贝方式 全部都是浅拷贝！
     * 浅拷贝：两个引用同时引用一个对象
     *
     * 如果数组当中的元素是简单类型，那么他是深拷贝
     * 如果数组当中存放的引用类型，那么他是浅拷贝
     * ps:面试官如果问：浅拷贝*/

    public static int[] copyArray(int[] array) {
        //第一种拷贝方式
         int[] array2 = new int[array.length];
         for(int i=0; i < array.length;i++) {
              array2[i] = array[i];
         }
         return array2;
    }
    public static void main1(String[] args) {
          int[] array = {1,2,3,4,5};
          System.out.println("拷贝前array："+ Arrays.toString(array));
          //拷贝前array：[1, 2, 3, 4, 5]
          int[] ret = Arrays.copyOf(array,array.length);
          ret[0] = 999;
          System.out.println("拷贝后ret修改:"+Arrays.toString(ret));
          //拷贝后ret修改:[999, 2, 3, 4, 5]
          System.out.println("拷贝后array："+ Arrays.toString(array));
          //拷贝后array：[1, 2, 3, 4, 5]

          int[] ret1 = array.clone();
          System.out.println("ret1:"+Arrays.toString(ret1));
          //第四种拷贝方式
          //ret1:[1, 2, 3, 4, 5]

          int[] ret2 = Arrays.copyOf(array,array.length);
          System.out.println("ret2:"+Arrays.toString(ret2));
          //第三种拷贝方式
          //ret2:[1, 2, 3, 4, 5]

          int[] dest = new int[array.length];
          //拷贝更快一点：native方法
          System.arraycopy(array,0,dest,0,array.length);
          //第二种拷贝方式
          System.out.println("dest"+Arrays.toString(dest));
          //dest[1, 2, 3, 4, 5]
          int[] ret3 = copyArray(array);
          System.out.println(Arrays.toString(ret3));
          //[1, 2, 3, 4, 5]
     }
}
