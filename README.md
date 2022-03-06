# CALCULATING RUNTIME

In **Main() method** we define three **long-type** variables to set 3 **timer** for algorithm. Use long type to store timers. Initialize **long-type array** with N from 1000 to 2.6e6 numbers. The array will run Random numbers.
Invoke three methods **range1, range2, range3** and use **System.nanoTime()** to calculate runtime for each version. Because the nanoTime() object return nano seconds so we need to convert mili seconds by dividing 1E6
### range1()
```
// returns the range of values in the given array;  
// the difference between elements furthest apart  
// example: range({17, 29, 11, 4, 20, 8}) is 25  
public static int range1(int[] numbers) {  
    int diff = 0, maxDiff = 0; // look at each pair of values  
  for (int i = 0; i < numbers.length; i++) {  
        for (int j = 0; j < numbers.length; j++) {  
            diff = Math.abs(numbers[j] - numbers[i]);  
 if (diff > maxDiff) {  
                maxDiff = diff;  
  }  
        }  
    }  
    return maxDiff;  
}
```
**Runtime: N*N = N^2 times
Algorithm range1() run O(N^2) times**
### range2()
```
public static int range2(int[] numbers) {  
    int diff = 0, maxDiff = 0; // look at each pair of values  
  for (int i = 0; i < numbers.length; i++) {  
        for (int j = i + 1; j < numbers.length; j++) {  
           diff = Math.abs(numbers[j] - numbers[i]);  
 if (diff > maxDiff) {  
                maxDiff = diff;  
  }  
        }  
    }  
    return maxDiff;  
}
```
**Runtime: N*N = N^2 times
Algorithm range2() run O(N^2) times**

### range3()
```
public static int range3(int[] numbers) {  
    int max = numbers[0]; // find max/min values  
  int min = max;  
 for (int i = 1; i < numbers.length; i++) {  
        if (numbers[i] < min) {  
            min = numbers[i];  
  }  
        if (numbers[i] > max) {  
            max = numbers[i];  
  }  
    }  
    return max - min;  
}
```
**Runtime: N times
Algorithm range3() run O(N) times**

### Report Algorithm Runtime
```
Numbers (N) – Runtime (ms)  
Numbers(N)= 1000 Runtime1: 8.864916 Runtime2: 5.911583 Runtime3: 0.039042
Numbers(N)= 2000 Runtime1: 10.931958 Runtime2: 4.800041 Runtime3: 0.077
Numbers(N)= 4000 Runtime1: 31.722708 Runtime2: 24.097916 Runtime3: 0.14375
Numbers(N)= 8000 Runtime1: 140.38575 Runtime2: 89.211292 Runtime3: 0.284917
Numbers(N)= 16000 Runtime1: 604.995 Runtime2: 362.287166 Runtime3: 0.570125
Numbers(N)= 32000 Runtime1: 2422.011625 Runtime2: 1359.42175 Runtime3: 1.0765
Numbers(N)= 64000 Runtime1: 9779.737875 Runtime2: 5396.086125 Runtime3: 0.436417
Numbers(N)= 128000 Runtime3: 0.711167
Numbers(N)= 256000 Runtime3: 0.620375
Numbers(N)= 521000 Runtime3: 1.1965
Numbers(N)= 1000000 Runtime3: 0.7485
Numbers(N)= 2000000 Runtime3: 0.944167
Numbers(N)= 4000000 Runtime3: 1.710542
Numbers(N)= 8000000 Runtime3: 2.939333
Numbers(N)= 16700000 Runtime3: 6.306875
Numbers(N)= 33000000 Runtime3: 11.8745
Numbers(N)= 65000000 Runtime3: 23.722292
Numbers(N)= 130000000 Runtime3: 46.335667
Numbers(N)= 260000000 Runtime3: 95.483042

```
### Conclusion
From three Algorithms above, __range3() run O(n) times__ is the best way to run less complexity because O(n) < O(n^2).  
Through **Report Algorithm Runtime**, we can compare directly three Algorithms with N numbers. When N = 64000 numbers, range1() gets ~ 9800s and range2() gets ~ 5000s and range3() gets ~ 0.4s. When N = 2.6E6 numbers **range3()** just runs ~95s so this algorithm is the **perfect 👍** to apply. 




```
