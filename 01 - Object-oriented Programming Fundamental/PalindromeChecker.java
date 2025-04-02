class PalindromeChecker{
	private String text;
	public PalindromeChecker(String text){
		this.text=text;
	}
	public boolean isPalindrome(){
		String cleanedText=text.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
		int length=cleanedText.length();
		for(int i=0;i<length/2;i++){
			if(cleanedText.charAt(i)!=cleanedText.charAt(length-1-i)){
				return false;
			}
		}
		return true;
	}
	public void displayResult(){
		System.out.println("Text: "+text);
		if(isPalindrome()){
			System.out.println("Text is palindrome.");
		}else{
			System.out.println("Text is not palindrome.");
		}
	}
	public static void main(String[] args){
		PalindromeChecker checker=new PalindromeChecker("Madam");
		checker.displayResult();
	}
}