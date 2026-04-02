class Solution {

    public String encode(List<String> strs) {
        StringBuilder st = new StringBuilder();

        for(String word : strs){
            st.append(word.length()).append("%").append(word);
        }
        return st.toString();
    }
                                            //.0123456789
    public List<String> decode(String str) { //5§Hello5§World
        List<String> newList = new ArrayList<>();

        while(!str.equals("")){
            int index = str.indexOf("%");//1
            int lenOfWord = Integer.parseInt(str.substring(0, index));//5
            String word = str.substring(index +1, index + lenOfWord + 1);
            newList.add(word);
            
            str = str.substring(index + lenOfWord + 1);
        }
        return newList;
    }
}
