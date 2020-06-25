import java.util.LinkedList;
import java.util.Queue;

/*
* 二叉树的基本实现：
* 存储：链式存储 ----在内存中怎么存
* 表现形式：孩子表示法
*
*
*
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

    //先序遍历
    public void preOrder(BTNode root){
        if(null != root){
            System.out.println(root.val+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历
    public void inOrder(BTNode root){
        if(null != root){
            inOrder(root.left);
            System.out.println(root.val+" ");
            inOrder(root.right);
        }
    }

    //后序遍历
    public  void lastOrder(BTNode root){
        if(null!=root){
            lastOrder(root.left);
            lastOrder(root.right);
            System.out.println(root.val+" ");
        }
    }

    //  求节点个数
    public int getNodecount(BTNode root){

        if(root==null){
            return 0;
        }
        return getNodecount(root.right)+getNodecount(root.left)+1;

    }

    //求叶子节点个数
    public int getLeafcount(BTNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        return getNodecount(root.right)+getNodecount(root.left);

    }

    //第K层中节点的个数
    public int getKcount(BTNode root,int k){
        if(root==null || k<1){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKcount(root.left,k-1)+getKcount(root.right,k-1);
    }

    //求二叉树的高度
    public int getHeight(BTNode root){
        if(null == root){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return leftHeight>rightHeight ?leftHeight+1:rightHeight+1;
    }

    //获取val在树中的节点，没找到返回null
    public BTNode find(BTNode root,int val){
        if (null == root) {
            return null;
        }
        if(root.val==val){
            return root;
        }
        BTNode ret=null;
        if(null != (ret=find(root.left,val)) || null!=(ret=find(root.right,val))){
            return ret;
        }
        return  null;
    }
    //层序遍历
    public void LeveOrder(BTNode root){
        if(null==root){
            return ;
        }
        Queue<BTNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            BTNode cue =q.poll();
            System.out.println(cue.val);
            if(null!=cue.left){
                q.offer(cue.left);
            }
            if(null!=cue.right){
                q.offer(cue.right);
            }
        }
        System.out.println();
    }
}
