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
  public void testBubble(){
    Comparable[] bubbleSorted = SortComparison.bubbleSort(input);
    assertEquals("" +bubbleSorted[5], "" +output[5]);
  }
  @Test
  public void testMerge(){
    Comparable[] mergeSorted = SortComparison.mergeSort(input);
    assertEquals("" +mergeSorted[1], "" +output[1]);
  }
  @Test
  public void testSelection(){
    Comparable[] selectionSorted = SortComparison.selectionSort(input);
    assertEquals("" +selectionSorted[7], "" +output[7]);    
  }
  @Test
  public void testQuick(){
    Comparable[] quickSorted = SortComparison.quickSort(input);
    assertEquals("" +quickSorted[8], "" +output[8]);    
  }
  @Test
  public void testInsertion(){
    Comparable[] insertionSorted = SortComparison.insertionSort(input);
    assertEquals("" +insertionSorted[5], "" +output[5]);    
  }

  public static void main(String[] args){}
}		
