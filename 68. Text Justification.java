// 68. Text Justification


// Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

// For the last line of text, it should be left justified and no extra space is inserted between words.

// For example,
// words: ["This", "is", "an", "example", "of", "text", "justification."]
// L: 16.

// Return the formatted lines as:
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]
// Note: Each word is guaranteed not to exceed L in length.

// click to show corner cases.

// Corner Cases:
// A line other than the last line might contain only one word. What should you do in this case?
// In this case, that line should be left-justified.
// ------------------------------------------------------------------------------------------------------------
// go through every word, if not filled line, add into line; or add space into string.

// consider two special cases when add space into string,
//     only one word in line,
//     has more than one word in line.

// remember to handle last line, since only filled with previous line, if there is more word after that can know the 
// previous one is filled, thus the last one has no more line to check for it. Has to handle the last line.


public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int linenum = 0;
        for(int i = 0;i<words.length;i++){
            if(linenum + words[i].length() + line.size()<=maxWidth){
                line.add(words[i]);
                linenum += words[i].length();
            }else{
                if(line.size()==1){
                    sb.append(line.get(0));
                    for(int k = 0;k<(maxWidth-linenum);k++) sb.append(' ');
                    res.add(sb.toString());
                }else if(line.size()>1){
                    int spaceblock = (maxWidth - linenum)/ (line.size() - 1);
                    int mod =  (maxWidth - linenum) % (line.size() - 1);
                    sb.append(line.get(0));
                        for(int j = 1;j<line.size();j++){
                            if(j<=mod) for(int k = 0;k<(spaceblock+1);k++) sb.append(' ');
                            else for(int k = 0;k<spaceblock;k++) sb.append(' ');
                            sb.append(line.get(j));
                        }
                    res.add(sb.toString());
                }
                line.clear();
                line.add(words[i]);
                linenum = words[i].length();
                sb.setLength(0);
            } 
        }
        //lastline
        sb.append(line.get(0));
        for(int i = 1;i<line.size();i++) sb.append(' ' + line.get(i));
        int spacenum = maxWidth-sb.length();//this should be out of the loop because sb is changing
        for(int k = 0;k<spacenum;k++) sb.append(' ');
        res.add(sb.toString());
        return res;
    }
}