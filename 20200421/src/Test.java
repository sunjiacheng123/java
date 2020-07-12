import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;

public class Test {
    public static class BSTNode{
        BSTNode left=null;
        BSTNode right=null;
        int val;
        BSTNode(int val){
            this.val=val;
        }

    }
    private BSTNode root=null;
    boolean conotains(int val){
        BSTNode cur=root;
        while(cur!=null){
            if(val==cur.val){
                return true;
            }else if(val<cur.val){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return false;
    }
    //将val插入到二叉搜索树中，插入成功
    public boolean put(int val){
        //空树
        if(null==root){
            root=new BSTNode(val);
            return true;
        }
        //非空
        //找到插入元素在二叉搜索树中的插入位置，并保存其双亲
        BSTNode cur=root;
        BSTNode parent=null;
        while (cur!=null){
            parent=cur;
            if(val<cur.val){
                cur=cur.left;

            }else if(val>cur.val){
                cur=cur.right;

            }else {
                return false;
            }
        }
        cur=new BSTNode(val);
        if(val<parent.val){
            parent.left=cur;
        }else{
            parent.right=cur;
        }
        return true;
    }

    public void inOrder(BSTNode root){
        if(null!=root){
            inOrder(root.left);
            System.out.println(root.val+" ");
            inOrder(root.right);
        }
    }
    //z最左侧节点--最小的节点
    public int leftMost(){
        if(null==root){
            //抛异常--
        }
        BSTNode cur=root;
        while (cur.left!=null){
            cur=cur.left;
        }
        return cur.val;
    }


    boolean remove (int val){
        if(root==null){
            return false;
        }
        //非空
        //找待删除节点在树中的位置
        BSTNode cur=root;
        BSTNode parent=null;
        while(cur!=null){

            if(val==cur.val){
                break;
            }else  if(val<cur.val){
                parent=cur;
                cur=cur.left;
            }else {
                parent=cur;
                cur=cur.right;
            }
        }
        if(cur==null){
            return false;
        }
        //已经找到待删除节点在树中的位置---删除该节点
        //必须要对cur的孩子节点分情况
        //1.
        //2.
        //3.
        //4.
        if(null==cur.left){
            //cur只有右孩子||cur就是叶子节点
            if(null==parent){
                //cur双亲不存在--根节点
                root=cur.right;
            }else {
                //双亲存在
                if(cur==parent.left){
                    parent.left=cur.right;
                }else {
                    parent.right=cur.right;
                }
            }
        }else if(null==cur.right){
            //只有左孩子
            if(null==parent){
                root=cur.left;
            }else {
                if(cur==parent.left){
                    parent.left=cur.left;
                }else{
                    parent.right=cur.left;
                }
            }
        }else{
            //左右孩子都在---不能直接删除
            //在cur子树中找一个替代节点删除
            //方式一：在其右子树中找最小的节点；即最左侧的节点
            //方式二：在其左子树中找最大的节点：即最右侧的节点
            BSTNode del=cur.right;
            parent=cur;
            while(null!=del.left){
                parent=del;
                del=del.left;
            }
            //替代节点找到
            cur.val=del.val;
            //删除代替节点；
            if(del==parent.left){
                parent.left=del.right;
            }else {
                parent.right=del.right;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int[] array={5,3,4,1,7,8,2,6,0,9};
        Test b=new Test();
        for(int e:array) {
            b.put(e);
        }
        b.inOrder();
    }
}
