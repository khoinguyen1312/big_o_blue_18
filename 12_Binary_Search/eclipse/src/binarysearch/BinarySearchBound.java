package binarysearch;

public class BinarySearchBound {
	int[] array;
	int left;
	int right;
	int findingNumber;
	
	private BinarySearchBound(int[] array, int left, int right, int findingNumber) {
		this.array = array;
		this.left = left;
		this.right = right;
		this.findingNumber = findingNumber;
	}
	
	public static BinarySearchBound createInstance(int[] array, int left, int right, int findingNumber) {
		return new BinarySearchBound(array, left, right, findingNumber);
	}
	
	public int findLowerBound() {
		int position = right;
		while (left < right) {
			int mid = left + (right - left) / 2;
			
			if (array[mid] >= findingNumber) {
				position = mid;
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return position;
	}
	
	public int findUpperBound() {
		int position = right;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (array[mid] > findingNumber) {
				position = mid;
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return position;
	}
}
