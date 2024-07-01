using System;

public class TreeNode
{
    public int Value;
    public TreeNode Left;
    public TreeNode Right;

    public TreeNode(int value)
    {
        Value = value;
        Left = null;
        Right = null;
    }
}

public class BinarySearchTree
{
    public TreeNode Root;

    public BinarySearchTree()
    {
        Root = null;
    }

    public void Insert(int value)
    {
        Root = InsertRec(Root, value);
    }

    private TreeNode InsertRec(TreeNode root, int value)
    {
        if (root == null)
        {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.Value)
            root.Left = InsertRec(root.Left, value);
        else if (value > root.Value)
            root.Right = InsertRec(root.Right, value);

        return root;
    }

    public bool Search(int value)
    {
        return SearchRec(Root, value) != null;
    }

    private TreeNode SearchRec(TreeNode root, int value)
    {
        if (root == null || root.Value == value)
            return root;

        if (value < root.Value)
            return SearchRec(root.Left, value);

        return SearchRec(root.Right, value);
    }

    public void InOrder()
    {
        InOrderRec(Root);
        Console.WriteLine();
    }

    private void InOrderRec(TreeNode root)
    {
        if (root != null)
        {
            InOrderRec(root.Left);
            Console.Write(root.Value + " ");
            InOrderRec(root.Right);
        }
    }

    public void PreOrder()
    {
        PreOrderRec(Root);
        Console.WriteLine();
    }

    private void PreOrderRec(TreeNode root)
    {
        if (root != null)
        {
            Console.Write(root.Value + " ");
            PreOrderRec(root.Left);
            PreOrderRec(root.Right);
        }
    }

    public void PostOrder()
    {
        PostOrderRec(Root);
        Console.WriteLine();
    }

    private void PostOrderRec(TreeNode root)
    {
        if (root != null)
        {
            PostOrderRec(root.Left);
            PostOrderRec(root.Right);
            Console.Write(root.Value + " ");
        }
    }

    public void Delete(int value)
    {
        Root = DeleteRec(Root, value);
    }

    private TreeNode DeleteRec(TreeNode root, int value)
    {
        if (root == null)
            return root;

        if (value < root.Value)
            root.Left = DeleteRec(root.Left, value);
        else if (value > root.Value)
            root.Right = DeleteRec(root.Right, value);
        else
        {
            if (root.Left == null)
                return root.Right;
            else if (root.Right == null)
                return root.Left;

            root.Value = MinValue(root.Right);
            root.Right = DeleteRec(root.Right, root.Value);
        }

        return root;
    }

    private int MinValue(TreeNode root)
    {
        int minv = root.Value;
        while (root.Left != null)
        {
            minv = root.Left.Value;
            root = root.Left;
        }
        return minv;
    }
}

class Program
{
    static void Main(string[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();
        bst.Insert(50);
        bst.Insert(30);
        bst.Insert(20);
        bst.Insert(40);
        bst.Insert(70);
        bst.Insert(60);
        bst.Insert(80);

        Console.WriteLine("InOrder traversal of the BST:");
        bst.InOrder();

        Console.WriteLine("PreOrder traversal of the BST:");
        bst.PreOrder();

        Console.WriteLine("PostOrder traversal of the BST:");
        bst.PostOrder();

        Console.WriteLine("Search for 40 in the BST: " + (bst.Search(40) ? "Found" : "Not Found"));
        Console.WriteLine("Search for 100 in the BST: " + (bst.Search(100) ? "Found" : "Not Found"));

        Console.WriteLine("Delete 20");
        bst.Delete(20);
        Console.WriteLine("InOrder traversal of the BST after deleting 20:");
        bst.InOrder();

        Console.WriteLine("Delete 30");
        bst.Delete(30);
        Console.WriteLine("InOrder traversal of the BST after deleting 30:");
        bst.InOrder();

        Console.WriteLine("Delete 50");
        bst.Delete(50);
        Console.WriteLine("InOrder traversal of the BST after deleting 50:");
        bst.InOrder();
    }
}
