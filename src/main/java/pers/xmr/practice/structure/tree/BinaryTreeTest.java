package pers.xmr.practice.structure.tree;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xmr
 * @date 2019/12/2 15:05
 * @description
 */
public class BinaryTreeTest {
    private static DateFormat sdf2 = new SimpleDateFormat("yyyyMMdd"); // 精确到天的时间戳
    /*
        二叉树的遍历策略
        遍历 : 按照某种次序访问树中的所有结点,并且每个结点恰好访问一次
        规定 : 先遍历左子树,再遍历右子树(思路:递归)
        先序遍历DLR : 根,左子树,右子树
        中序遍历LDR : 左子树, 根,右子树
        后续遍历LRD : 左子树,右子树,根
        层次遍历 : 从根节点开始,按照从左到右的顺序按照层次对二叉树进行遍历

        二叉排序树进行中序遍历,得到有序队列
        二叉查找树: 左边小于根,根小于右边,左右子树也为二叉排序树
        平衡二叉树: 左子树,右子树高度之差不超过1,AVL树,左右两个子树都是一棵二叉平很熟
        平衡因子 : 结点的平衡因子是结点的左子树的高度减去右子树的高度
        平衡二叉树 : 每个结点的平衡因子都为-1,0,1的二叉排序树,每个结点的左右子树的高度最多差1的二叉排序树
        目的 : 减少二叉查找树层次,提高查找速度
     */
    public static void main(String[] args) {
        String remark = "05|01000016|20191202|6217233400001058994|||||||||1051000|2220|中国建设银行大连市分行|6217000780017482457|杨雪|||Y|2.0|JS|11|105222000015|0.0||";
        String [] remarks = remark.split("\\|");
        if (remarks.length >= 22) {
            System.out.println(remarks[21]);
        }
        System.out.println(Long.valueOf(sdf2.format(new Date())) - Long.valueOf("20191203") < 3);
    }

}
