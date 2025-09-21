class Solution {
    public boolean equal(int nums1[] ,int nums2[]){
        int n = nums1.length ; 
        for(int i = 0 ;i < n ; i++){
            if(nums1[i] == nums2[i]) continue ; 
            else return false;
        }
        return true ; 
    }
    public boolean check(int[] nums1, int[] nums2 , int size , int curr){
        if(size == curr){
            return equal(nums1 , nums2) ? true : false ; 
        }
        for(int l = 0 ; l < nums1.length ; l++){
            for(int r = l ; r < nums1.length ; r++){
                int arr[] = new int[nums1.length - (r - l + 1)] ; 
                int st = 0 ; 
                for(int firstHalf = 0 ; firstHalf < l ; firstHalf++){
                    arr[st++] = nums1[firstHalf];   
                }
                for(int secondHalf = r + 1 ; secondHalf < nums1.length ; secondHalf++){
                    arr[st++] = nums1[secondHalf];
                }
                for(int k = 0 ; k < arr.length ; k++){
                    st = 0 ;
                    int result[] = new int[nums1.length] ;  
                    for(int f1 = 0 ; f1 < k ; f1++){
                        result[st++] = arr[f1] ; 
                    }
                    for(int f1 = l ; f1 <= r ; f1++){
                        result[st++] = nums1[f1] ; 
                    }
                    for(int f1 = k ; f1 < arr.length ; f1++){
                        result[st++] = arr[f1] ; 
                    }
                    if(check(result , nums2 , size , curr+1)) return true ; 
                }
            }
        }
        return false ; 
    }
    public int minSplitMerge(int[] nums1, int[] nums2) {
        int n = nums1.length ;
        int ch = 1 ; 
        for(int i = 0 ;i < n ;i++){
            if(nums1[i] == nums2[i])continue ; 
            else {
                ch = 0 ; 
                break; 
            }
        }
        if(ch == 1)return 0 ; 
        for(int i = 1 ; i <= n ; i++){
            if(check(nums1 , nums2 , i , 0))return i ; 
        }
        return 0 ; 
    }

}
