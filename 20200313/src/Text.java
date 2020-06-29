/*
* 后序遍历
*1.二叉树的创建方式：按照概念来进行创建-->递归创建根节点的左子树，递归创建根节点的右子树
* 2.节点中的数据序列应该怎么提供：
* 创建规则——>类似二叉树的前序遍历规则
* */


import java.util.Stack;
class BinTree{
    private  BTNode root=null;
    private  int index=0;

    public BinTree(int[] array, int invalid) {
        root = create(array,invalid);
        this.index = index;
    }

    //按前序遍历的规则穿件二叉树
    BTNode create(int[] array,int invalid){
        BTNode newRoot=null;
        if(index<array.length && array[index]!=invalid){
            //创建根节点
            newRoot=new BTNode(array[index]);
            //递归创建根节点的左子树
            ++index;
            newRoot.left=create(array,invalid);

            ++index;
            newRoot.right=create(array,invalid);
        }
        return newRoot;
    }
}


class BTNode{
    BTNode left = null;//指向该节点的左子树
    BTNode right = null;//指向该节点的右子树
    int val;

    public BTNode(int val){
        this.val=val;
    }
}

public class Text {
    public static void main(String[] args) {
        int[] array={1,2,3,-2,-2,-2,4,5,-2,-2,6};
        BinTree b=new BinTree(array,-2);


    }

    //非递归后续遍历
    public void postorder(BTNode root){

        Stack<BTNode> s=new Stack<>();
        BTNode cur=root;
        BTNode pre=null;
        while(cur!=null || !s.empty()){
            while(cur!=null){
                s.push(cur);
                cur=cur.left;
            }
            BTNode top=s.peek();
            //需要考虑右子树是否已经遍历过
            //使用pre标记刚刚遍历的节点
            if(top.right==null || pre==top.right ){
                pre=top;
                System.out.println(top.val + " ");
                s.pop();
            }else{
                cur=top.right;
            }
        }
    }
}
