pascal:: Int -> Int -> Int 
pascal n k 
    | k == 0 = 1 
    | n == k = 1 
    | k > n = 0 
    | otherwise = pascal (n-1) (k-1) + pascal (n-1) k