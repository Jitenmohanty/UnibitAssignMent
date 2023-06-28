import java.util.*;

class Jitu {
    // Returns number of pairs in arr[0..n-1]
    // with sum equal to 'sum'
    static void printPairs(int arr[], int n, int sum, ArrayList<ArrayList<Integer>> a) {
        // Store counts of all elements in map m
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

        // Traverse through all elements
        for (int i = 0; i < n; i++) {
            // Search if a pair can be formed with arr[i].
            int rem = sum - arr[i];
            if (mp.containsKey(rem)) {
                int count = mp.get(rem);
                for (int j = 0; j < count; j++) {
                    a.add(new ArrayList<>(List.of(rem, arr[i])));
                }
            }
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            } else {
                mp.put(arr[i], 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 7, -1, 5 };
        int n = arr.length;
        int sum = 6;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        printPairs(arr, n, sum, ans);
        System.out.println(ans);
        // Sorting the elements in ascending order
        ArrayList<Integer> sortedElements = new ArrayList<>();
        for (ArrayList<Integer> list : ans) {
            for (int element : list) {
                sortedElements.add(element);
            }
        }
        Collections.sort(sortedElements);

        // Printing the sorted elements
        for (int element : sortedElements) {
            System.out.print(element+" ");
        }
    }
}
