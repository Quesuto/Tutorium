checkerFunc :: Float -> Float -> Bool
checkerFunc n m = if(n < m) then
    if (n * m) > 25
        then True
    else if (n * m) == 25
        then True
    else
        False
    else if (n == m) then 
        if (n * m) > 25
            then True
        else if (n * m) == 25
            then True
        else
            False
    else
        if (n * m) < 25
            then False
        else if (n * m) == 25
            then False
        else
            False