/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Gary Hyer
 *  @version HT 2018
 */
import java.io.*;

 class SortComparison {

    /**
     * Sorts an array using InsertionSort.
     * @param a: An unsorted array
     * @return array sorted in ascending order.
     *
     */
  static Comparable[] insertionSort (Comparable[] a){
  	int i, j;
  	Comparable index;
  	for(i =1; i< a.length; i++){
  		index = a[i];
  		j=i;
   		while((j>0) && ((a[j-1]).compareTo(index))>0){
		  	a[j] = a[j-1];
		  	j = j-1;
	  	}
  		a[i] = index;
  	}
  	return a;
  }

    /**
     * Sorts an array using Quick Sort.
     * @param a: An unsorted array
     * @return array sorted in ascending order
     *
     */
  static Comparable[] quickSort (Comparable[] a){
    return recursiveQuick(a, 0, (a.length-1));
  }
  private static Comparable[] recursiveQuick(Comparable[] a, int lo, int hi){
    if(hi<=lo)
      return a;
    int pivotPos = partition(a, lo, hi);
    recursiveQuick(a, lo, pivotPos);
    return recursiveQuick(a, pivotPos+1, hi);
  }
  private static int partition(Comparable[] a, int lo, int hi){ 
    int i=lo;
    int j= hi + 1;
    Comparable pivot = a[lo];
    while(true){
      while((a[++i].compareTo(pivot)<0)){
        if(i == hi) 
          break;
      }
      while((pivot.compareTo(a[--j])<0)){
        if(j==lo)
          break;
      }
      if(i>=j)
        break;
      Comparable temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
    a[lo] = a[j];
    a[j]= pivot;
    return j;
  }


    /**
     * Sorts an array using Merge Sort.
     * @param a: An unsorted array
     * @return array sorted in ascending order
     *
     */
  static Comparable[] mergeSort (Comparable[] a){
    Comparable[] aux = new Comparable[a.length];
    return sort(a,aux,0,a.length-1);
  }
  private static Comparable[] sort(Comparable[] a, Comparable[] aux, int lo, int hi){
    if(hi<=lo) 
      return a;
    int mid = lo + (hi - lo)/2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid+1, hi);
    return merge(a, aux, lo, mid, hi);  
  }

  private static Comparable[] merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    for(int k = lo; k<= hi; k++){
      aux[k] = a[k];
    }
    int i= lo, j= mid+1;
    for(int k= lo; k<=hi; k++){
      if(i>mid)
        a[k] = aux[j++];
      else if (i>hi)
        a[k] = aux[i++];
      else if (aux[j].compareTo(aux[i])<0)
        a[k] = aux[j++];
      else
        a[k] = aux[i++];
    }
    return a;
  }

    /**
     * Sorts an array using Shell Sort.
     * @param a: An unsorted array
     * @return array sorted in ascending order
     *
     */
  static Comparable[] shellSort (Comparable[] a){

	  int increment = a.length / 2;
    int j;
    Comparable temp;
	  while (increment > 0) {
	  	for (int i = increment; i < a.length; i++) {
	   		j = i;
	  		temp = a[i];
	  		while (j >= increment && a[j - increment].compareTo(temp)>0) {
	  			a[j] = a[j - increment];
	  			j = j - increment;
	  		}
	  		a[j] = temp;
	  	}
	  	if (increment == 2)
			  increment = 1;
		  else
			increment *= (5.0 / 11);
	  }
		 return a;
  }//end shellsort

    /**
     * Sorts an array using Selection Sort.
     * @param a: An unsorted array
     * @return array sorted in ascending order
     *
     */
  static Comparable[] selectionSort (Comparable[] a){
  
    Comparable temp;
    int i, j;
    for(i=0; i<a.length; i++){
      for(j=i+1; j<a.length; j++){
        if(a[i].compareTo(a[j])>0){
          temp = a[i];
          a[i] = a[j];
          a[j] = temp;
        }
      }
    }
    return a;
  }

    /**
     * Sorts an array using Bubble Sort.
     * @param a: An unsorted array
     * @return array sorted in ascending order
     *
     */
  static Comparable[] bubbleSort (Comparable a[]){

	  Comparable temp;
	  for(int i=0; i<a.length; i++){
	  	for(int j=1; j< (a.length-i); j++){
        if(a[j-1].compareTo(a[j]) > 0){		
        temp = a[j-1];
	  		a[j-1] = a[j];
	  		a[j] = temp;
        }
	  	}
	  }
	  return a;
  }

  public static void main(String[] args) throws FileNotFoundException, IOException {

/*
    BufferedReader in = new BufferedReader(new FileReader("numbers100.txt"));
    int i = 0;
    String line;
    Comparable[] array = new Comparable[100];
    System.out.println("Input size: "+ array.length);
    while((line = in.readLine()) != null){
      //System.out.println(line);
      array[i] = line;
      i++;
    }
    System.out.println("\nBubble Sort");
    long bubbleBegin = System.nanoTime();   
    Comparable[] bubbleSorted = bubbleSort(array);
    long bubbleEnd = System.nanoTime();   
    System.out.println(bubbleEnd - bubbleBegin);

    System.out.println("\nInsertion Sort");
    long insertionBegin = System.nanoTime();   
    Comparable[] insertionSorted = insertionSort(array);
    long insertionEnd = System.nanoTime();   
    System.out.println(insertionEnd - insertionBegin);

    System.out.println("\nShell Sort");
    long shellBegin = System.nanoTime();    
    Comparable[] shellSorted = shellSort(array);
    long shellEnd = System.nanoTime();
    System.out.println(shellEnd - shellBegin);

    System.out.println("\nMerge Sort");
    long mergeBegin = System.nanoTime();   
    Comparable[] mergeSorted = mergeSort(array);
    long mergeEnd = System.nanoTime();   
    System.out.println(mergeEnd - mergeBegin);

    System.out.println("\nSelection Sort");
    long selectionBegin = System.nanoTime();   
    Comparable[] selectionSorted = selectionSort(array);
    long selectionEnd = System.nanoTime();   
    System.out.println(selectionEnd - selectionBegin);

    System.out.println("\nQuickSort");
    long quickSortBegin = System.nanoTime();   
    Comparable[] quickSorted = quickSort(array);
    long quickSortEnd = System.nanoTime(); 
    System.out.println(quickSortEnd - quickSortBegin);  

    in.close();  
*/
  }
}

