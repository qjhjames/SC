package com.qjhjames.shujujiegou;

/**
 * Created by qiujunhong on 2018/6/28.
 */

//二叉树
public class Node {
    public int key;
    public Node left;
    public Node right;


    public static void insert(Node root,int key){
        Node newNode=new Node();
        newNode.key=key;
        if(root==null){
            root=newNode;
        }else{
            insertNode(root,newNode);
        }
    }

    public static void insertNode(Node node,Node newNode){
        if(newNode.key<node.key){
            if(node.left==null){
                node.left=newNode;
            }else{
                insertNode(node.left,newNode);
            }
        }else{
            if(node.right==null){
                node.right=newNode;
            }else{
                insertNode(node.right,newNode);
            }
        }
    }

    public static void main(String[] args){
        int[] vals=new int[]{2,3,56,12,67,34,52,78,9898,1,45};
        Node root=null;
        for(int val:vals){
            insert(root,val);
            System.out.println(root.key);
        }
    }
}
