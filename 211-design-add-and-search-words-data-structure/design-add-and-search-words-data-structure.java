class WordDictionary {
    class TrieNode{
        TrieNode[] trieNode;
        boolean WE;

        TrieNode(){
            trieNode = new TrieNode[26];
            WE = false;
        }
        Boolean containsChar(char c){
            return trieNode[c-'a']!=null;
        }
        void insert(char c){
            trieNode[c-'a']=new TrieNode();
        }
        TrieNode getChar(char c){
            return trieNode[c-'a'];
        }
        void markWordEnd(){
            WE=true;
        }
        Boolean isWord(){
            return WE;
        }
    }
    TrieNode root;
    public WordDictionary() {
        root =new TrieNode();
    }
    public void addWord(String word) {
        TrieNode temp = root;
        for(char c : word.toCharArray()){
            if(!temp.containsChar(c)){
                temp.insert(c);
            }
            temp=temp.getChar(c);
        }
        temp.markWordEnd();
    }
    
    public boolean search(String word) {
        return searchhelper(root,word,0);
    }
    public boolean searchhelper(TrieNode temp, String word,int index){
        if(index==word.length()){
            return temp.isWord();
        }
        char c = word.charAt(index);
        if(c!='.'){
            if(!temp.containsChar(c)){
                return false;
            }
            return searchhelper(temp.getChar(c),word,index+1);
        }
        for(int i=0;i<26;i++){
            if(temp.trieNode[i]!=null){
                if(searchhelper(temp.trieNode[i],word,index+1)){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */