package TrieGroup;

import java.util.HashMap;

/**
 * Created by baiwe on 2017/5/4.
 */
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // insert into the trie
    public void insert(String str) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = root.children;
        char[] strArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++){
            char c = strArray[i];
            if (children.containsKey(c)){
                cur = children.get(c);
            } else {
                TrieNode newNode = new TrieNode(c);
                cur.children.put(c,newNode);
                cur = newNode;
            }
            children = cur.children;

            if (i == str.length() - 1){
                cur.hasWord = true;
            }
        }
    }

    public boolean search (String word){
        if (findPos(word) == null){
            return false;
        } else if(findPos(word).hasWord){
            return true;
        } else {
            return false;
        }
    }

    public boolean findPrefix(String prefix){
        if (findPos(prefix) == null){
            return false;
        } else {
            return true;
        }
    }

    // search position
    public TrieNode findPos(String str){
        HashMap<Character, TrieNode> children = root.children;
        TrieNode cur = null;
        char[] strArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++){
            if (children.containsKey(strArray[i])){
                cur = children.get(strArray[i]); //keypoint
                children = cur.children;
            } else {
                return null;
            }
        }
        return cur;
    }
}

class TrieNode{
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean hasWord;

    public TrieNode(){}

    public TrieNode(char c){
        this.c = c;
    }
}
