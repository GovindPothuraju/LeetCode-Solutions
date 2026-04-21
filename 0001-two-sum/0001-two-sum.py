class Solution:
    def twoSum(self, arr: List[int], target: int) -> List[int]:
        
        l = len(arr)
        for i in range(l):
            for j in range(i+1,l):
                sum = arr[i]+arr[j]
                if sum==target:
                    return [i,j]
        return [-1,-1]