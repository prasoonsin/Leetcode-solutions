class Solution {
    class Node {
        int l, r, pre, suf, max, len;

        Node(int l, int r, int pre, int suf, int max, int len) {
            this.l = l;
            this.r = r;
            this.pre = pre;
            this.suf = suf;
            this.max = max;
            this.len = len;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(String str, String qc, int[] qi) {
        s = str.toCharArray();
        tree = new Node[4 * s.length];
        build(1, 0, s.length - 1);

        int[] ans = new int[qi.length];

        for (int i = 0; i < qi.length; i++) {
            s[qi[i]] = qc.charAt(i);
            update(1, 0, s.length - 1, qi[i]);
            ans[i] = tree[1].max;
        }

        return ans;
    }

    void build(int p, int l, int r) {
        if (l == r) {
            tree[p] = new Node(s[l], s[l], 1, 1, 1, 1);
            return;
        }

        int m = (l + r) / 2;
        build(p * 2, l, m);
        build(p * 2 + 1, m + 1, r);
        tree[p] = merge(tree[p * 2], tree[p * 2 + 1]);
    }

    void update(int p, int l, int r, int idx) {
        if (l == r) {
            tree[p] = new Node(s[idx], s[idx], 1, 1, 1, 1);
            return;
        }

        int m = (l + r) / 2;

        if (idx <= m)
            update(p * 2, l, m, idx);
        else
            update(p * 2 + 1, m + 1, r, idx);

        tree[p] = merge(tree[p * 2], tree[p * 2 + 1]);
    }

    Node merge(Node a, Node b) {
        Node c = new Node(a.l, b.r, a.pre, b.suf,
                Math.max(a.max, b.max), a.len + b.len);

        if (a.r == b.l) {
            c.max = Math.max(c.max, a.suf + b.pre);

            if (a.pre == a.len)
                c.pre += b.pre;

            if (b.suf == b.len)
                c.suf += a.suf;
        }

        return c;
    }
}