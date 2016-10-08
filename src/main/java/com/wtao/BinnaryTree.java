package com.wtao;

import java.util.Stack;

/**
 * 树的数据结构
 * 0、某一个节点的度：所有直接子节点的个数是多少，某一棵树的度=所有节点中度最大的那个节点的度
 * 1、树的深度：也就是树的最大层数是多少
 * 2、完全二叉树：所有的非叶子节点都有两个子节点
 * 3、叶子节点数+1 = 度为2的节点的个数
 */

public class BinnaryTree {
    public TreeNode<String> root;

    //构建一棵树
    public void createTree(){
        TreeNode<String> nodeA = new TreeNode<>("A",1);
        TreeNode<String> nodeB = new TreeNode<>("B",2);
        TreeNode<String> nodeC = new TreeNode<>("C",3);
        TreeNode<String> nodeD = new TreeNode<>("D",4);
        TreeNode<String> nodeE = new TreeNode<>("E",5);
        TreeNode<String> nodeF = new TreeNode<>("F",6);
        TreeNode<String> nodeG = new TreeNode<>("G",7);
        TreeNode<String> nodeH = new TreeNode<>("H",8);
        TreeNode<String> nodeI = new TreeNode<>("I",9);
        TreeNode<String> nodeJ = new TreeNode<>("J",10);
        TreeNode<String> nodeK = new TreeNode<>("K",11);

        root = nodeA;
        nodeA.leftNode = nodeB;
        nodeA.rightNode = nodeC;

        nodeB.leftNode = nodeD;
        nodeB.rightNode = nodeE;

        nodeC.leftNode = nodeF;
        nodeC.rightNode = nodeG;

        nodeD.leftNode = nodeH;

        nodeE.leftNode = nodeI;

        nodeG.leftNode = nodeJ;
        nodeG.rightNode = nodeK;
    }

    //获取数的节点个数
    public int getNodeCount(){
        return getNodeCount(root);
    }

    private int getNodeCount(TreeNode  root) {
        if(root==null){
            return 0;
        }
        return 1+getNodeCount(root.leftNode)+getNodeCount(root.rightNode);
    }

    //获取数的深度
    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(TreeNode  root) {
        if(root==null){
            return 0;
        } else{
            int leftCount = getHeight(root.leftNode);
            int rightCount = getHeight(root.rightNode);
            return 1+Math.max(leftCount,rightCount);
        }
    }


    //前序遍历（递归方式）
    public void preShow(TreeNode root){
        if(root == null){
            return;
        }else{
            //根节点  左边子树  右子树
            System.out.println("preShwo:"+root.data);
            preShow(root.leftNode);
            preShow(root.rightNode);
        }
    }
    //中序遍历（递归方式）
    public void midShow(TreeNode node){
        //左边的子树  根节点  右边子树
        if(node==null){
            return;
        }else{
            midShow(node.leftNode);
            System.out.println(node.data);
            midShow(node.rightNode);
        }
    }
    //后序遍历（递归方式）
    public void postShow(TreeNode node){
        if(node==null){
            return;
        }else{
            //左边子树  右边子树  根节点
            postShow(node.leftNode);
            postShow(node.rightNode);
            System.out.println(node.data);
        }
    }

    //前序遍历（非递归，使用Stack方式）
    //思路：一个Stack，先放入根节点，只要栈不为空，就执行如下的操作：弹出一个元素并输出节点的内容，然后压入这个节点的右节点，再压入左边节点（先右节点在左节点是因为Stack是先进后出，这样才能先遍历左子树再遍历右子树）
    public void nonRecShow(TreeNode<String> node){
        Stack<TreeNode<String>>stack = new Stack<>();
        if(node!=null){
            stack.push(node);
        }
        while(!stack.isEmpty()){
            TreeNode<String> topNode = stack.pop();
            System.out.println("stack输出："+topNode.data);
            if(topNode.rightNode!=null){
                stack.push(topNode.rightNode);
            }
            if(topNode.leftNode!=null){
                stack.push(topNode.leftNode);
            }
        }
    }
    public class TreeNode<T>{
        public TreeNode<T>leftNode;
        public TreeNode<T>rightNode;
        public T data;
        public int index;

        public TreeNode( T data,int index) {
            this.data = data;
            this.index = index;
        }

        public TreeNode<T> getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode<T> leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode<T> getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode<T> rightNode) {
            this.rightNode = rightNode;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
    public static void main(String[]args){
        BinnaryTree tree = new BinnaryTree();
        tree.createTree();
        System.out.println("tree的深度："+tree.getHeight());
        System.out.println("tree的节点数："+tree.getNodeCount());
        //tree.preShow(tree.root);
        //tree.midShow(tree.root);
        //tree.postShow(tree.root);
        tree.nonRecShow(tree.root);
    }
}
