package dsaTrack;

public class Sorting {
    public static void main(String[] args) {
        int []arr={1,4,12,15,10,90,46,47,0};

        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
        bubbleSort(arr);
        System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
    }

    public static void bubbleSort(int[] arr){

        for(int i=0;i<arr.length;i++){

            for(int j=0;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
