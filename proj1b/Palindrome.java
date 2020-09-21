public class Palindrome {

    /**
     * Return a Deque where the characters appear
     * in the same order as in the String.
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    /**
     * Return true if the given word is a palindrome,
     * and false otherwise.
     * Any word of length 1 or 0 is a palindrome.
     */
    public boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    /**
     * Helper method for isPalindrome(String word)
     */
    private boolean isPalindrome(Deque<Character> wordDeque) {
        while (wordDeque.size() > 1) {
            return wordDeque.removeFirst() == wordDeque.removeLast()
                    && isPalindrome(wordDeque);
        }
        /** when wordDeque.size() <= 1 */
        return true;
    }

    /**
     * Return true if the word is a palindrome
     * according to the character comparison test
     * provided by the CharacterComparator passed in as argument cc.
     *
     * @param word given String word
     * @param cc   character comparator
     * @return
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(wordToDeque(word), cc);
    }

    /**
     * Helper Method for isPalidrome(String word, CharacterComparator cc)
     */
    private boolean isPalindrome(Deque<Character> wordDeque, CharacterComparator cc) {
        while (wordDeque.size() > 1) {
            return cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast())
                    && isPalindrome(wordDeque, cc);
        }
        return true;
    }
}
