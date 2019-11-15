data Currency = Euro Integer Integer | Dollar Integer Integer | Yen Integer

hShow :: Integer -> String
hShow i
    | (i < 10) = "0" ++ show i
    | otherwise = show i

instance Show Currency where
    show (Euro euro cent) = (show euro) ++ "," ++ (hShow cent) ++ "€"
    show (Dollar dollar cent) = (show dollar) ++ "," ++ (hShow cent) ++ "$"
    show (Yen yen) = (show yen) ++ "¥"

normalize :: Currency -> Currency
normalize (Euro euro cent) = (Euro (euro + floor (fromIntegral cent / 100)) (mod cent 100))
normalize (Dollar dollar cent) = (Dollar (dollar + floor (fromIntegral cent / 100)) (mod cent 100))
normalize (Yen yen) = (Yen yen)

toEuro :: Currency -> Currency
toEuro (Euro e c) = (Euro e c)
toEuro (Dollar d c) = (Euro (floor (fromIntegral d * 0.9)) (floor (fromIntegral c * 0.9)))
toEuro (Yen y) = (Euro 0 (floor ( fromIntegral y * 0.83)))

instance Eq Currency where
    (==) (Euro e1 c1) (Euro e2 c2) = (e1 == e2) && (c1 == c2)
    (==) c1 c2 = (toEuro c1 == toEuro c2)

instance Ord Currency where
    (<=) (Euro e1 c1) (Euro e2 c2)
        | (e1 == e2) = (c1 <= c2)
        | otherwise = (e1 <= e2)
    (<=) c1 c2 = (toEuro c1 <= toEuro c2)