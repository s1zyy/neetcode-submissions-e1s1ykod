class Solution {

    public String encode(List<String> strs) {
        String answer = "";
        for(int i = 0; i < strs.size(); i++){
            answer = answer + strs.get(i).length() + "%" + strs.get(i);
        }
        System.out.println(answer);
        return answer;
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
