package Day42;

public class Solution implements Password{

    //加密过程
    @Override
    public void Encrypt(char[] aucPassword, char[] aucResult) {
        for (int i = 0;i < aucPassword.length;i++) {
            int data = aucPassword[i];
            if (data >= 'a' && data <= 'z'); {
                if (data == 'z') {
                    aucResult[i] = changeString('a');
                } else {
                    aucResult[i] = changeString((char)(aucPassword[i]+1));
                }
            }
            if (data >= 'A' && data <= 'Z'); {
                if (data == 'Z') {
                    aucResult[i] = changeString('A');
                } else {
                    aucResult[i] = changeString((char)(aucPassword[i]+1));
                }
            }
            if (data >= '0' && data <= '9'); {
                if (data == '9') {
                    aucResult[i] = '0';
                } else {
                    aucResult[i] = (char)(aucPassword[i]+1);
                }
            }
        }
    }
    //解密过程
    @Override
    public void unEncrypt(char[] Result, char[] Password) {

    }

    private static char changeString(char data) {
        if (data >= 'a' && data <= 'z') {
            return (char)(data-32);
        }
        if (data >= 'A' && data <= 'Z') {
            return (char)(data+32);
        }
        return 'a';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String string = "abcd1234ACD";
        char[] chars = string.toCharArray();
        char[] result = new char[12];
        s.Encrypt(chars,result);
        for (char c : result) {
            System.out.println(c);
        }
    }
}
