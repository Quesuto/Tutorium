-- a)
theoTriangle::Int -> Float
theoTriangle n
    | n == 1 = sqrt(2)
    | otherwise = sqrt((theoTriangle (n-1))^2 + 1)

-- b)
theoArea::Int -> Float
theoArea n
    | n == 1 = 0.5
    | otherwise = 0.5 * (theoTriangle (n-1)) + theoArea (n-1)

-- c)
theoSimple::Int -> Float
theoSimple n = sqrt (fromIntegral n + 1)