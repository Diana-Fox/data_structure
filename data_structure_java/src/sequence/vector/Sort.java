package sequence.vector;

/**
 * 排序算法，多种排序
 */
public class Sort {
    //起泡排序
    public int[] BubbleSort(int[] elem, int lo, int hi) {
        boolean sorted = true;
        int temp = 0;
        while (++lo < hi) {
            if (elem[lo - 1] > elem[lo]) {
                sorted = false;
                temp = elem[lo - 1];
                elem[lo - 1] = elem[lo];
                elem[lo] = temp;
            }
        }
        return elem;
    }

    //选择排序
    public void SelectionSort() {

    }

    //归并排序
    public void MergeSort() {

    }

    //堆排序
    public void HeapSort() {

    }

    //快速排序
    public void QuickSort() {

    }
}
