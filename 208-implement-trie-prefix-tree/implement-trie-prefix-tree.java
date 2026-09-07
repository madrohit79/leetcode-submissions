class Trie {
    class TrieNode{
        TrieNode[] trieNode;
        boolean WE;
        TrieNode(){
            trieNode = new TrieNode[26];
            WE = false;
        }
        Boolean containsChar(char c){
            return trieNode[c - 'a']!=null;
        }
        TrieNode getChar(char c){
            return trieNode[c - 'a'];
        }
        void insert(char c){
            trieNode[c-'a']=new TrieNode();
        }
        void markWordEnd(){
            WE=true;
        }
        Boolean isWord(){
            return WE;
        }
    }
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for(char c: word.toCharArray()){
            if(!temp.containsChar(c)){
                temp.insert(c);
            }
            temp=temp.getChar(c);
        }
        temp.markWordEnd();
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        for(char c: word.toCharArray()){
            if(!temp.containsChar(c)){
                return false;
            }
            temp=temp.getChar(c);
        }
        return temp.isWord();
    }
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(char c: prefix.toCharArray()){
            if(!temp.containsChar(c)){
                return false;
            }
            temp=temp.getChar(c);
        }
        return temp!=null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */