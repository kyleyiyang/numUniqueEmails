class Solution {
    public int numUniqueEmails(String[] emails) {
        List<String> lst = new ArrayList<String>(emails.length);
        for (int i=0;i<emails.length;i++) {
            lst.add(new_email(emails[i]));
        }
        
        List<Integer> l = new ArrayList<Integer>();
        for (int j=0;j<lst.size()-1;j++) {
            String x = lst.get(j);
            if (!lst.subList(j+1,lst.size()).contains(x)) {
                l.add(j);
            }
        }
        return l.size()+1;
    }
    public static String new_email(String s) {
        String left = s.substring(0, s.indexOf("@"));
        String right = s.substring(s.indexOf("@"));
        String lleft;
        if (left.indexOf("+")>=0) {
            lleft = left.substring(0,left.indexOf("+"));
        } else {
            lleft=left;
        }
        String final_left="";
        if (lleft.indexOf(".")>=0) {
            for (String f : lleft.split("\\.")) {
                final_left += f;
            }
        } else {
            final_left=lleft;
        }
        String f_s = final_left + right;
        return f_s;
    }
}
