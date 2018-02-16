import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 **  Test class for SortComparison.java
 **
 **  @author Gary Hyer
 **  @version HT 2018
 **/

@RunWith(JUnit4.class)
public class SortComparisonTest
{

  Comparable[] input ={2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63};
  Comparable[] output = {1518.63,1522.08,1735.31,1934.75,2377.88,2910.66,4849.83,5855.37,8106.23,8458.14};

	@Test
	public void testConstructor(){
	    new SortComparison();
	}

	@Test
	public void testEmpty(){
	}

  @Test
  public void testBubble(){
    Comparable[] bubbleSorted = SortComparison.bubbleSort(input);
    assertEquals(bubbleSorted, output);
  }
  @Test
  public void testMerge(){
    Comparable[] mergeSorted = SortComparison.mergeSort(input);
    assertEquals(mergeSorted, output);
  }
  @Test
  public void testSelection(){
    Comparable[] selectionSorted = SortComparison.selectionSort(input);
    assertEquals(selectionSorted, output);    
  }
  @Test
  public void testQuick(){
    Comparable[] quickSorted = SortComparison.quickSort(input);
    assertEquals(quickSorted, output);    
  }
  @Test
  public void testInsertion(){
    Comparable[] insertionSorted = SortComparison.insertionSort(input);
    assertEquals(insertionSorted, output);    
  }


	public static void main(String[] args){
/*   
    BufferedReader in = new BufferedReader(new FileReader("numbers1000Duplicates.txt"));


    //Improve to choose size of array based on input file
    int i = 0;
    String line;
    Comparable[] array = new Comparable[1000];
    System.out.println("Input size: "+ array.length);
    while((line = in.readLine()) != null){
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

    System.out.println("\nQuickSort");
    long quickSortBegin = System.nanoTime();   
    Comparable[] quickSorted = quickSort(array);
    long quickSortEnd = System.nanoTime(); 
    System.out.println(quickSortEnd - quickSortBegin);  

    in.close();  
*/
	}
}		
