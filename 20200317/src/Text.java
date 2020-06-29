import javax.swing.tree.TreeNode;
//import java.util.Scanner;
//import java.util.Scanner;
import java.util.Scanner;
import java.util.Stack;
public class Text {
    public static void main(String[] args) {
        java.util.Scanner s=new java.util.Scanner(System.in);
        Scanner s1=new Scanner(System.in)
    }
}
/*
public class Text {
    private boolean egtNodepath(TreeNode root, TreeNode node , Stack<TreeNode> sPath){
        if(null== root){
            return false;
        }
        sPath.push(root);
        if(root==node){
            return true;
        }
        //
        //if(egtNodepath(root.left))
    }

}
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null|| q==null){
            return null;
        }
        Stack<TreeNode> pPath=new Stack<>();
        Stack<TreeNode> qPath=new Stack<>();
        egtNodepath(root,p,pPath);
        egtNodepath(root,q,qPath);
        //两个路径对应栈：
        //1.应该让节点个数多的栈，先出栈到节点个数相同
        //2.依次比较两个栈顶元素
        //  a.相等---->即最近公共祖先节点
        //  b.不相等---->
        int sizep=pPath.size();
        int sizeq=qPath.size();
        while(sizep != 0 && sizeq!=0){
            if(sizep>sizeq){
                pPath.pop();
                sizep--;
            }else if(sizep<sizeq){
                qPath.pop();
                sizeq--;
            }else{
                if(pPath.peek()==qPath.peek()){
                    return pPath.peek();
                }else{
                    qPath.pop();
                    pPath.pop();
                    sizeq--;
                    sizep--;
                }
            }
        }
        return null;
    }
    private boolean egtNodepath(TreeNode root, TreeNode node , Stack<TreeNode> sPath){
        if(null== root){
            return false;
        }
        sPath.push(root);
        if(root==node){
            return true;
        }
        //递归到root的左子树||右子树中找到弄得路径
        if(egtNodepath(root.left,node,sPath)||egtNodepath(root.right,node,sPath)){
            return true;
        }
        sPath.pop();
        return false;
    }
}

class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null|| q==null){
            return null;
        }
        //如果有一个节点在根的位置，最近公共祖先一定是根节点
        if(root==p || root ==q){
            return root;
        }
        //检测p和q在root子树中的情况
        boolean ispleft=false;
        boolean ispright=false;
        boolean isqleft=false;
        boolean isqright=false;
        //检测p是否在左子树
        if(isNodeTree(root.left,p)){
            ispright=false;
            ispleft=true;
        }else{
            ispright=true;
            ispleft=false;
        }

        if(isNodeTree(root.left,q)) {
            isqright=false;
            isqleft=true;
        }else{
            isqright=true;
            isqleft=false;
        }
        //p和q分别在root的左右子树中
        if(ispleft && isqright || ispright && isqleft){
            return root;
        }else if(ispleft && isqleft){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return lowestCommonAncestor(root.right,p,q);
        }
    }
    //检测是否在一棵子树中
    private boolean isNodeTree(TreeNode root,TreeNode s){
        if(root == null){
            return false;
        }
        if(root == s){
            return true;
        }
        if(isNodeTree(root.left,s) || isNodeTree(root.right,s)){
            return true;
        }
        return false;
    }
}
*/