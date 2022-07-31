package darren.gong.leetcode;

public class WordDictionary211 {
  private WordDictionary211[] dictionary = new WordDictionary211[26];
  private boolean end = false;
  /** Initialize your data structure here. */
  public WordDictionary211() {

  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    if (word.length() == 0) {
      end = true;
      return;
    }
    int next = word.charAt(0)-'a';
    if (dictionary[next] == null) {
      dictionary[next] = new WordDictionary211();
    }
    dictionary[next].addWord(word.substring(1));
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    if (word.length() == 0) {
      if (end == true) {
        return true;
      } else {
        return false;
      }
    }

    if (word.charAt(0) == '.') {
      for (WordDictionary211 one : dictionary) {
        if (one != null && one.search(word.substring(1))) {
          return true;
        }
      }
      return false;
    }

    int next = word.charAt(0)-'a';
    if (dictionary[next] == null) {
      return false;
    }
    return dictionary[next].search(word.substring(1));
  }
}
