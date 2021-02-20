public String removeOuterParentheses(String str){
    int n = str.length();
    StringBuilder sb = new StringBuilder();

    int idx = 0;
    for( int i=0; i<n; i++ ){
        if( str.charAt(i) == '(' && idx++ > 0 ){
            sb.append( '(' );
            //idx++;
        }else if( str.charAt(i) == ')' && idx-- > 1 ){
            sb.append( ')' );
            //idx--;
        }
    }
    return sb.toString();
}

public int[] ngor( int[] arr ){
    int[] ans = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    for( int i=0; i<arr.length; i++ ){
        while(st.size() != 0 && arr[i] > arr[st.peek()] ){
            ans[st.pop()] = i;
        }st.push(i);
    }
    return ans;
}

public int[] ngol(int[] arr){
    int n = arr.length;
    Stack<Integer> st = new Stack<>();
    int[] ans = new int[n];

    for( int i=n-1; i>=0; i-- ){
        while( st.size() != 0 && arr[i] > arr[st.peek()] ){
            ans[st.pop()] = i;
        }
        st.push(i);
    }
    return ans;
}

public int[] nsor(int[] arr){
    int n = arr.length;
    Stack<Integer> st = new Stack<>();
    int[] ans = new int[n];

    for( int i=0; i<arr.length; i++ ){
        while(st.size() != 0 && arr[i] < arr[st.peek()] ){
            ans[st.pop()] = i;
        }st.push(i);
    }
    return ans;
}

public int[] nsol(int[] arr){
    int n = arr.length;
    Stack<Integer> st = new Stack<>();
    int[] ans = new int[n];

    for( int i=n-1; i>=0; i-- ){
        while( st.size() != 0 && arr[i] < arr[st.peek()] ){
            ans[st.pop()] = i;
        }
        st.push(i);
    }
    return ans;
}

public int[] nextGreaterElements(int[] arr){
    int n = arr.length;
    int[] ans = new int[n];
    Stack<Integer> st = new Stack<>();
    Arrays.fill(ans,-1);

    for( int i=0; i<2*n; i++ ){
        int idx = i % n;
        while( st.size() != 0 && arr[idx] > arr[st.peek()] ){
            ans[st.pop()] = arr[idx];
        }
        st.push(idx);
    }return ans;
}

public int minAddToMakeValid(String str){
    int n = str.length();
    int obr = 0;
    int cbr = 0;
    for( int i=0; i<n; i++ ){
        char ch = str.charAt(i);
        if( ch == '(' ) cbr++;
        else if( cbr > 0 ) cbr--;
        else obr++;
    }
    return obr + cbr;
}

public int minAddToMakeValid_02(String str){
    int n = str.length();
    Stack<Character> st = new Stack<>();

    for( int i=0; i<n; i++ ){
        if( st.size() > 0 && st.peek() == '(' && str.charAt(i) == ')' ) st.pop();
        else st.push(str.charAt(i));
    }
    return st.size();
}

public int longestValidParentheses(String str){
    int n = str.length();
    Stack<Integer> st = new Stack<>();
    st.push(-1);
    int len = 0;

    for( int i=0; i<n; i++ ){
        if( st.peek() != -1 && str.charAt(st.peek()) == '(' && str.charAt(i) == ')' ){
            st.pop();
            len = Math.max(len, i-st.peek());
        }else{
            st.push(i);
        }
    }return len;
}

public String minRemoveToMakeValid(String str){
    int n = str.length();
    StringBuilder sb = new StringBuilder(str);
    Stack<Integer> st = new Stack<>();

    for( int i=0; i<n; i++ ){
        char ch = str.charAt(i);
        if( ch == ')' ){
            if( st.size() != 0 ) st.pop();
            else sb.setCharAt(i, '#');
        }else if( ch == '(' ) st.push(i);
    }

    while( st.size() != 0 ){
        int i = st.pop();
        sb.setCharAt(i,'#');
    }

    StringBuilder ans = new StringBuilder();
    for( int i=0; i<n; i++ ){
        char ch = sb.charAt(i);
        if(ch!='#') sb.append(ch);
    }
    return ans.toString();
}