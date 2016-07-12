// 157. Read N Characters Given Read4 

// The API: int read4(char *buf) reads 4 characters at a time from a file.
// The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

// Note:
// The read function will only be called once for each test case.

// read char to temp array, step 4 every time.
// copy temp array to buf, to record current store data place, 
// if read length is less than 4, reading is over, return back.
// if not return back in the if statement, means is read times of 4 of data.
	
public class Solution extends Reader4 {
    public int read(char[] buf, int n) {
    	int res = 0;
    	if(buf==null||buf.length==0) return res;
    	for(int i = 0;i<n;i += 4){
			char[] tmp = new char[4];
    		int len = read4(tmp);// read data to tmp
    		System.arraycopy(tmp,0,buf,i,Math.min(len, n - i ));
    		if(len<4) return Math.min(i+len, n);
    	}
    	return n;
    }
}