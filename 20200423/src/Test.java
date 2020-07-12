public class Test {
    public static class BSTNode {
        BSTNode left = null;
        BSTNode right = null;
        int val;

        BSTNode(int val) {
            this.val = val;
        }
    }
    private BSTNode root=null;
    BSTNode BSTreeList(){
        if(null==root){
            return null;
        }
        //.1.找连标配的首节点----就是树中最小的节点----最小的节点就是树中最左侧节点
        BSTNode head=root;
        while(head.left!=null){
            head=head.left;
        }
        //2.修改每个节点的left和right的指向
        //标记刚刚遍历的节点
        BSTree2DList(root);
        return head;
    }
    BSTNode prev=null;
    public void BSTree2DList(BSTNode root){
        if(null==root){
            return;
        }
        //转化根节点左子树
        BSTree2DList(root.left);
        //转化根节点
        root.left=prev;
        if(null!=prev){
            prev.right=root;
        }
        //用prev将刚刚遍历的 节点保存起来
        prev=root;
        //转化根节点右子树
        BSTree2DList(root.right);
    }
}
