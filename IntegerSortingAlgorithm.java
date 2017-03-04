package integerSortingAlgorithm;

import homework2.LinkedDataStack;
import homework2.SingleLinkedDataQueue;

/**
 * A set of Integer Sorting Algorithm
 * @author liang dong
 *
 */
public class IntegerSortingAlgorithm {
	
	private static SingleLinkedDataQueue<Integer>[] theBuckets;// For radix sort
	private static int[] tempArray;// For merge sort

	
	/**
	 * a function that uses iterative selection sort to sort an array.
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void selectiveSortByIteration(int[] array) {
		selectiveSortByIteration(array, 0, array.length - 1);
	}

	/**
	 * a function that uses iterative selection sort to sort an array.
	 * @param array The array that to be sorted
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void selectiveSortByIteration(int[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		int indexOfSmallest;
		for(int i = firstIndex; i <= lastIndex; i++) {
			indexOfSmallest = i;
			for(int j = i; j <= lastIndex; j++) {
				if(array[indexOfSmallest] > array[j]) {
					indexOfSmallest = j;
				}
			}//end nested for
			swap(array, i, indexOfSmallest);	
		}//end for
	}//end selectiveSortByIteration
	
	
	
	/**
	 * a function that uses recursive selection sort to sort an array.
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void selectiveSortByRecursion(int[] array) {
		selectiveSortByRecursion(array, 0, array.length - 1) ;
	}
	
	
	/**
	 * a function that uses recursive selection sort to sort an array.
	 * @param array The array that to be sorted
	 * @param firstUnsorted The index of the first entry in an unsorted part of the array
	 * @param lastIndex The last index of an partial array to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void selectiveSortByRecursion(int[] array, int firstUnsorted, int lastIndex) {
		if(firstUnsorted > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		int indexOfSmallest = 0;
		indexOfSmallest = findIndexOfSmallest(array, firstUnsorted, lastIndex);
		swap(array, firstUnsorted, indexOfSmallest);
		selectiveSortByRecursion(array,firstUnsorted + 1, lastIndex);
		
	}//selectiveSortByRecursion
	
	/**
	 * a function that find the index of the smallest entry in an array
	 * @param array The target array
	 * @param indexOfCheckingElement The starting index
	 * @param lastIndex The last index of an partial array to be sorted
	 * @return Index of the smallest entry
	 */
	private static int findIndexOfSmallest(int[] array, int indexOfCheckingElement, int lastIndex) {
		if(indexOfCheckingElement >= lastIndex) {
			return indexOfCheckingElement;
		}
		else {
			 int index = findIndexOfSmallest(array, indexOfCheckingElement + 1, lastIndex);
			 if (array[index] < array[indexOfCheckingElement]) {
				 return index;
			 }
			 else
				 return indexOfCheckingElement;
		}	
	}//end findIndexOfSmallest		

	
	/**
	 * swap two entries.
	 * @param array the target array
	 * @param first Index of an entry
	 * @param last Index Of another entry
	 */
	private static void swap(int[] array, int first, int last) {
		int temp = array[first];
		array[first] = array[last];
		array[last] = temp;
	}
	
	
	
	/**
	 * a function that uses iterative insertion sort to sort an array.
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void insertionSortByIteration(int[] array) {
		insertionSortByIteration(array, 0, array.length - 1);
	}
	
	/**
	 * A function that uses iterative insertion sort to sort a partial array.
	 * @param array an array that to be sorted
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void insertionSortByIteration(int[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		for (int i = firstIndex; i <= lastIndex; i++) {
			int j = i;
			while((j > firstIndex) && (array[j] < array[j-1])) {
				int temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;
				j--;
			}//end while
		}//end for
	}//end  insertionSortByIteration
	
	
	/**
	 * a function that uses recursive insertion sort to sort an array.
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void insertionSortByRecursion(int[] array) {
		insertionSortByRecursion(array, 0, array.length - 1);
	}//end insertionSortByRecursion
	
	/**
	 * a function that uses recursive insertion sort to sort a partial array.
	 * @param array The array that to be sorted
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void insertionSortByRecursion(int[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		doInsertionSort(array, firstIndex, lastIndex, 1);
	}//end insertionSortByRecursion
	
	
	/**
	 * Do insertion sort
	 * @param array The array that to be sorted
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param firstUnsorted The index of unsorted element in the partial array.
	 */
	private static void doInsertionSort(int[] array, int firstIndex, int lastIndex, int firstUnsorted) {
		movingElement(array,firstIndex, lastIndex, firstUnsorted);	
		if(firstUnsorted < lastIndex) {
			doInsertionSort(array, firstIndex, lastIndex, firstUnsorted + 1);
		}
		
	}//end doInsertionSort
	
	/**
	 * compare and swap entries when necessary.
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param array The target array
	 * @param indexOfChekingElement Index of the entry that is being checked
	 */
	private static void movingElement(int[] array, int firstIndex, int lastIndex, int indexOfChekingElement) {
		
		if((indexOfChekingElement <= firstIndex) 
				|| (array[indexOfChekingElement] >= array[indexOfChekingElement - 1]))
			;
		else {
			int temp = array[indexOfChekingElement];
			array[indexOfChekingElement] = array[indexOfChekingElement - 1];
			array[indexOfChekingElement - 1] = temp;
			movingElement(array, firstIndex, lastIndex, indexOfChekingElement - 1);
		}//end else
		
	}//end comparingElements
	
	
	
	/**
	 * a function that uses iterative shell sort to sort an array.
	 * @param array
	 */
	public static void shellSortByIteration(int[] array) {
		shellSortByIteration(array, 0, array.length - 1);
	}
	/**
	 * a function that uses iterative shell sort to sort an array.
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void shellSortByIteration(int[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		int k = 1;
		int index = firstIndex;
		int indexWhenSwap;
		while((2 * k + 1) <= lastIndex) {
			k = 2 * k + 1;
		}
		while(k > 0) {
			indexWhenSwap = index;
			while((indexWhenSwap >= firstIndex) 
					&& ((indexWhenSwap + k) <= lastIndex) 
					&& (array[indexWhenSwap] > array[indexWhenSwap + k])) {

				int temp = array[indexWhenSwap];
				array[indexWhenSwap] = array[indexWhenSwap + 1];
				array[indexWhenSwap + 1] = temp;
				indexWhenSwap -= k;
			}//end nested while
			index++;
			if((index + k) > lastIndex) {
				k = k / 2;
				index = firstIndex;
			}
		}//end while
	}//end shellSortByIteration
	
	
	
	/**
	 * a function that uses recursive shell sort to sort an array.
	 * @param array The array that to be sorted
	 */
	public static void shellSortByRecursion(int[] array) {
		shellSortByRecursion(array, 0, array.length - 1);
	}
	
	/**
	 * a function that uses recursive shell sort to sort an array.
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void shellSortByRecursion(int[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		int k = 1;
		while((2 * k + 1) <= lastIndex) {
			k = 2 * k + 1;
		}
		traversalElements(array, firstIndex, lastIndex, k, firstIndex);	
	}//end shellSortByRecursion
	
	
	/**
	 * a function goes over all elements in the array.
	 * @param array the target array
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param k the space between the two elements
	 * @param index the entry that on the left of the other one
	 */
	private static void traversalElements(int[] array, int firstIndex, int lastIndex, int k, int index) {
		//System.out.println(index);
		if(k >= 1 && (index + k) <= lastIndex) {
			compareElements(array, firstIndex, k, index);
			traversalElements(array, firstIndex, lastIndex, k, index + 1);
		}
		else if(k > 1 && (index + k) > lastIndex) {
			traversalElements(array, firstIndex, lastIndex, k / 2, firstIndex);
		}
	}//end traversalElements
	
	/**
	 * compare and swap entries when necessary.
	 * @param array the target array
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param k the space between the two entries
	 * @param index the entry on the left of the other one
	 */
	private static void compareElements(int[] array, int firstIndex, int k, int index) {
		
		if(index >= firstIndex && array[index] > array[index + k]) {
			int temp = array[index];
			array[index] = array[index + k];
			array[index + k] = temp;
			compareElements(array, firstIndex, k, index - k);
		}
		
	}//end swapElements
	
	
	/**
	 * a function that uses iterative radix sort to sort an array.
	 * @param array The array that to be sorted
	 */
	public static void radixSortByIteration(int[] array) {
		radixSortByIteration(array, 0, array.length - 1);
	}
	
	/**
	 * a function that uses iterative radix sort to sort an array.
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void radixSortByIteration(int[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		@SuppressWarnings("unchecked")
		SingleLinkedDataQueue<Integer>[] theBuket = new SingleLinkedDataQueue[10];
		theBuckets = theBuket;
		for(int i = 0; i < theBuket.length; i++) {
			theBuket[i] = new SingleLinkedDataQueue<>();
		}
		int length = determineTheDigits(array, firstIndex, lastIndex);
		for(int position = 1; position <= length; position++) {
			int hashCode = (int) Math.pow(10,position);
			int digit = -1;
			for(int index = firstIndex; index <= lastIndex; index++) {
				digit = array[index] / (hashCode / 10);
				digit = digit % 10;
				switch(digit) {
					case 0: 
						theBuckets[0].enqueue(array[index]);
						break;
					case 1: 
						theBuckets[1].enqueue(array[index]);
						break;
					case 2: 
						theBuckets[2].enqueue(array[index]);
						break;
					case 3: 
						theBuckets[3].enqueue(array[index]);
						break;
					case 4: 
						theBuckets[4].enqueue(array[index]);
						break;
					case 5: 
						theBuckets[5].enqueue(array[index]);
						break;
					case 6: 
						theBuckets[6].enqueue(array[index]);
						break;
					case 7: 
						theBuckets[7].enqueue(array[index]);
						break;
					case 8: 
						theBuckets[8].enqueue(array[index]);
						break;
					case 9: 
						theBuckets[9].enqueue(array[index]);
						break;
				}// end switch
			}
			int indexOfTheArray = firstIndex;
			for(int indexOfTheBukets = 0; indexOfTheBukets < 10; indexOfTheBukets++) {
				while(!theBuckets[indexOfTheBukets].isEmpty()) {
						array[indexOfTheArray] = theBuckets[indexOfTheBukets].dequeue();
						indexOfTheArray++;
				}
			}
			
		}
	}// end determineTheDigits
	
	
	/**
	 * a function finds the the number of digits that the largest number has
	 * @param array the target array
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @return the number of digits that the largest number has
	 */
	private static int determineTheDigits(int[] array, int firstIndex, int lastIndex) {
		int max = findMax(array, firstIndex, lastIndex);
		String theLength = String.valueOf(max);
		return theLength.length();
	}// end determineTheDigits
	
	
	/**
	 *  a function finds the largest number in an array
	 * @param array the target array
	 * @return The largest number.
	 */
	private static int findMax(int[] array, int firstIndex, int lastIndex) {
		int max = array[firstIndex];
		for(int i = 1; i <= lastIndex; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}//end findMax
	
	/**
	 * a function that uses recursive radix sort to sort an array.
	 * @param array The array that to be sorted
	 */
	public static void radixSortByRecursion(int[] array) {
		radixSortByRecursion(array, 0, array.length - 1);
	}
	
	/**
	 * a function that uses recursive radix sort to sort an array.
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void radixSortByRecursion(int[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		@SuppressWarnings("unchecked")
		SingleLinkedDataQueue<Integer>[] theBuket = new SingleLinkedDataQueue[10];
		theBuckets = theBuket;
		for(int i = 0; i < theBuket.length; i++) {
			theBuket[i] = new SingleLinkedDataQueue<>();
		}	
		int upperbound = determineTheDigits(array, firstIndex, lastIndex);
		doRadixSort(array, firstIndex, lastIndex, 1, upperbound);
		
	}// end radixSortByRecursion
	
	/**
	 * a function that sorts entries based on decimal positions
	 * @param array the target array
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param position the decimal position
	 * @param upperbound the highest decimal position
	 */
	private static void doRadixSort(int[] array, int firstIndex, int lastIndex, int position, int upperbound) {
		if(position <= upperbound) {
			int hashCode = (int) Math.pow(10,position);
			int digit = -1;
			for(int index = firstIndex; index <= lastIndex; index++) {
				digit = array[index] / (hashCode / 10);
				digit = digit % 10;
				switch(digit) {
					case 0: 
						theBuckets[0].enqueue(array[index]);
						break;
					case 1: 
						theBuckets[1].enqueue(array[index]);
						break;
					case 2: 
						theBuckets[2].enqueue(array[index]);
						break;
					case 3: 
						theBuckets[3].enqueue(array[index]);
						break;
					case 4: 
						theBuckets[4].enqueue(array[index]);
						break;
					case 5: 
						theBuckets[5].enqueue(array[index]);
						break;
					case 6: 
						theBuckets[6].enqueue(array[index]);
						break;
					case 7: 
						theBuckets[7].enqueue(array[index]);
						break;
					case 8: 
						theBuckets[8].enqueue(array[index]);
						break;
					case 9: 
						theBuckets[9].enqueue(array[index]);
						break;
				}// end switch
			}
			int indexOfTheArray = firstIndex;
			for(int indexOfTheBukets = 0; indexOfTheBukets < 10; indexOfTheBukets++) {
				
				while(!theBuckets[indexOfTheBukets].isEmpty()) {
						array[indexOfTheArray] = theBuckets[indexOfTheBukets].dequeue();
						indexOfTheArray++;
				}
			}
			
			position++;
			doRadixSort(array, firstIndex, lastIndex, position, upperbound);

		}
		
	}//End doRadixSort
	
	
	/**
	 * a function that uses iterative merge sort to sort an array.
	 * @param array The array that to be sorted
	 */
	public static void mergeSortByIteration(int[] array) {
		mergeSortByIteration(array, 0, array.length - 1);
	}
	
	/**
	 * a function that uses iterative merge sort to sort an array.
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void mergeSortByIteration(int[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		int mid;
		int leftBoundary = 0;
		tempArray = new int[lastIndex - firstIndex + 1];
		int range = 1;
		while(range <= lastIndex) {
			while(leftBoundary < lastIndex + 1 - range) {
				mid = range + leftBoundary - 1;
				if(lastIndex < leftBoundary + range * 2 -1) {
					combineMergeParts(array, leftBoundary, lastIndex, mid);
				}
				else {
					combineMergeParts(array, leftBoundary, leftBoundary + range * 2 -1, mid);
				}
				leftBoundary += range * 2;
			}
			leftBoundary = 0;
			range *= 2;
		}

	}//end mergeSortByIteration
		
	
	/**
	 * a function that uses recursive merge sort to sort an array.
	 * @param array The array that to be sorted
	 */
	public static void mergeSortByRecursion(int[] array) {
		mergeSortByRecursion(array, 0, array.length - 1);
	}
	
	
	/**
	 * a function that uses recursive merge sort to sort an array.
	 * @param array The array that to be sorted
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void mergeSortByRecursion(int[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		tempArray = new int[lastIndex - firstIndex + 1];
		doMergeSort(array, firstIndex, lastIndex);
	}
	/**
	 * break a partial array into half
	 * @param array the target array
	 * @param firstIndex the starting point
	 * @param lastIndex the end point
	 */
	private static void doMergeSort(int[] array, int firstIndex, int lastIndex) {

		if(lastIndex - firstIndex == 1) {
			if(array[firstIndex] > array[lastIndex]) {
				swap(array,firstIndex, lastIndex);
			}
		}
		else if(lastIndex > firstIndex) {
			int mid = (firstIndex + lastIndex) / 2;
			doMergeSort(array, firstIndex, mid);
			doMergeSort(array, mid + 1, lastIndex);	
			combineMergeParts(array,firstIndex, lastIndex, mid);
		}
		
	}//end merge
	
	
	/**
	 * a function that uses merge sort to sort two sorted partial arrays of an array.
	 * @param array the target array
	 * @param firstIndex the index of the first element in the left-side array
	 * @param lastIndex the index of the first element in the right-side array
	 * @param mid the boundary of the two arrays.
	 */
	private static void combineMergeParts(int[] array, int firstIndex, int lastIndex, int mid) {

		int index = firstIndex;
		int pointer1 = firstIndex;
		int pointer2 = mid + 1;
		while(pointer1 <= mid && pointer2 <= lastIndex) {
			if(array[pointer1] <= array[pointer2]) {
				tempArray[index] = array[pointer1];
				pointer1++;
			}
			else {
				tempArray[index] = array[pointer2];
				pointer2++;
			}
			index++;
		}
		if(pointer1 > mid) {
			while(pointer2 <= lastIndex) {
				tempArray[index] = array[pointer2];
				index++;
				pointer2++;
			}
		}
		if(pointer2 > lastIndex) {
			while(pointer1 <= mid) {
				tempArray[index] = array[pointer1];
				index++;
				pointer1++;
			}
		}
		
		for(int i = firstIndex; i <= lastIndex; i++) {
			array[i] = tempArray[i];
		}
	}// end combineMergeParts
	
	/**
	 * a function that uses iterative quick sort to sort an array.
	 * @param array the target array
	 */
	public static void quickSortByIteration(int[] array) {
		quickSortByIteration(array, 0, array.length - 1);
	}
	
	/**
	 * a function that uses iterative quick sort to sort an array.
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param array the target array
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void quickSortByIteration(int[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		LinkedDataStack<Integer> stack = new LinkedDataStack<>();
		stack.push(-1);
		stack.push(lastIndex);
		stack.push(firstIndex);
		int left;
		int right;
		int leftPointer;
		int rightPointer;
		int pivot;
		while(stack.peek() != -1) {
			left = stack.pop();
			leftPointer =left;
			right = stack.pop();
			rightPointer = right;
			pivot = array[(leftPointer + rightPointer) / 2];
			while(rightPointer >= leftPointer) {
				while(array[leftPointer] < pivot) {
					leftPointer++;
				}
				while(array[rightPointer] > pivot) {
					rightPointer--;
				}
				
				if(rightPointer >= leftPointer) {
					int temp = array[leftPointer];
					array[leftPointer] = array[rightPointer];
					array[rightPointer] = temp;
					leftPointer++;
					rightPointer--;
				}
			}
			if(rightPointer > left) {
				stack.push(rightPointer);
				stack.push(left);
			}
			
			if(right > leftPointer) {
				stack.push(right);
				stack.push(leftPointer);
			}

		}
	}// end quickSortByIteration
	
	
	/**
	 * a function that uses recursive quick sort to sort an array.
	 * @param array the target array.
	 */
	public static void quickSortByRecursion(int[] array) {
		quickSortByRecursion(array, 0, array.length - 1);
	}
	
	/**
	 * a function that uses recursive quick sort to sort an array.
	 * @param array the target array
	 * @param firstIndex The index of the first unsorted element.
	 * @param lastIndex The index of the last unsorted element.
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public static void quickSortByRecursion(int[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		doQuickSort(array, firstIndex, lastIndex);
	}// end quickSortByRecursion

	
	/**
	 * a function that uses recursive quick sort to sort an array.
	 * @param array the target array
	 * @param firstIndex the lower bound
	 * @param lastIndex the upper pound
	 */
	private static void doQuickSort(int[] array, int firstIndex, int lastIndex) {
		int left = firstIndex;
		int right = lastIndex;
		int pivot = array[(firstIndex + lastIndex) / 2];
		while(right >= left) {
			while(array[left] < pivot) {
				left++;
			}
			while(array[right] > pivot) {
				right--;
			}
				
			if(right >= left) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
			
		if(left < lastIndex) {
			doQuickSort(array, left, lastIndex);
		}
			
		if(right > firstIndex) {
			doQuickSort(array, firstIndex, right);
		}
			
	}// end doQuickSort
	
}
