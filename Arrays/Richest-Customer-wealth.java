//T: O(mn)
//S: O(1)

//https://leetcode.com/problems/richest-customer-wealth/

  //Variation 1: Using loops

public int maximumWealth(int[][] accounts) {
	int max = 0;
	for (int[] customer : accounts) {
		int wealth = 0;
		for (int account : customer)
			wealth += account;
		max = Math.max(max, wealth);
	}
	return max;
}

//Variation 2: Using Loop and Stream

public int maximumWealth(int[][] accounts) {
	int max = 0;
	for (int[] customer : accounts) {
		int wealth = Arrays.stream(customer).sum();
		max = Math.max(max, wealth);
	}
	return max;
}

//Variation 3: Using Streams

public int maximumWealth(int[][] accounts) {
	return Arrays.stream(accounts)
				 .mapToInt(customerAccount -> Arrays.stream(customerAccount).sum())
				 .max()
				 .getAsInt();
}
