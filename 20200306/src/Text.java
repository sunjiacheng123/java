import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
* 二叉树
* */
class BTNode{
    BTNode left = null;//指向该节点的左子树
    BTNode right = null;//指向该节点的右子树
    int val;

    public BTNode(int val){
        this.val=val;
    }
}

public class Text {
    private  BTNode root=null;

    //非递归前序遍历
    public void preOrder(BTNode root){
        if (root == null) {
            return ;
        }
        Stack<BTNode> s=new Stack<>();
        s.push(root);

        while (!s.empty()){
            BTNode cur=s.peek();
            System.out.println(cur.val+"");
            s.pop();

            //如果cur存在右子树，将cur的右子树入栈
            if(null!=cur.right){
                s.push(cur.right);
            }
            //如果cur存在左子树，将cur的左子树入栈
            if(null!=cur.left){
                s.push(cur.left);
            }
        }
    }
    public void preOrder2(BTNode root){
        if(null==root){
            return;
        }
        Stack<BTNode> s=new Stack<>();
        s.push(root);
        while (!s.empty()){
            BTNode cur=s.peek();
            s.pop();

            while (null != cur){
                System.out.println(cur.val+" ");
                if(cur.right!=null){
                    s.push(cur.right);
                }
                cur=cur.left;
            }
        }
    }

    //判断完全二叉树
    public boolean isCompltetTree(){
        if(null==root){
            return true;
        }
        Queue<BTNode> q=new LinkedList<>();
        q.offer(root);
        boolean isLeafOrLeft=false;
        while (!q.isEmpty()){
            BTNode cur=q.poll();
            if(isLeafOrLeft){
                //2.第一个不饱和节点后的节点不能有子树
                if (null != cur.left || null != cur.right) {
                    return false;
                }
            }else{
                //1.按层序遍历的方式找第一个不饱和节点（叶子，只有一个孩子的节点）
                //cur节点的左右孩子均在
                if(null!=cur.right&&null!=cur.left){
                    q.offer(cur.right);
                    q.offer(cur.left);
                }else if(null !=cur.left){
                    //只要左子树
                    q.offer(cur.left);
                    isLeafOrLeft=true;
                }else if(null!=cur.right){
                    //只有右子树
                    return false;
                }
            }
        }
        return true;
    }
    public void inorder(BTNode root){
        if(null==root){
            return ;
        }
        BTNode cur=root;
        Stack<BTNode> s=new Stack<>();
        //1.找以root尾根的二叉树最左侧的节点，并保存所经路径中所有的节点--栈
        while(cur!=null || !s.empty()){
            while (cur!=null){
                s.push(cur);
                cur=cur.left;
            }
            //cur为空，认为该课树已经遍历
            //可以遍历cur的根节点，cur的根节点在栈顶；
            cur= s.peek();
            System.out.println(cur.val+" ");
            s.pop();
            //以cur为跟的二叉树：左子树已经遍历，右子树没遍历
            //右子树当成新的二叉树
            cur=cur.right;
        }
    }
}
