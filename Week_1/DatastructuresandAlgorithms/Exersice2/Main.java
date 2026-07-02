package DatastructuresandAlgorithms.Exersice2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Product[] inventory = {
            new Product(105, "Wireless Headphones", "Electronics"),
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(108, "Coffee Mug", "Kitchen"),
            new Product(102, "Desk Mat", "Office"),
            new Product(109, "Gaming Mouse", "Electronics")
        };

        int targetId = 108;

        //linear Search
        System.out.println("---Linear Search---");
        System.out.println(linearSearch(inventory, targetId));

        
        //Binary Searchh
        System.out.println("---Binary Search---");
        Arrays.sort(inventory);
        System.out.println(binarySearch(inventory, targetId));

    }

    public static int linearSearch(Product[] arr, int target){
       for( int i =0; i<arr.length; i ++){
        if(arr[i].productID == target){
            return i;
        }
       }
       return -1;
    }

    public static int binarySearch(Product[] arr, int targetId){
        int left = 0;
        int right = arr.length -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid].productID == targetId) {
                return mid; // Found it
            }
            if (arr[mid].productID < targetId) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }
        return -1;

        
    }

    public static void printResult(int index, Product[] arr) {
        if (index != -1) {
            System.out.println("Product found: " + arr[index].toString());
        } else {
            System.out.println("Product not found.");
        }
    }   
}
