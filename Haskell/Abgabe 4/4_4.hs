data Rank = Seven | Eight | Nine | Ten | Jack | Queen | King | Ace deriving (Read, Show, Eq, Ord)

data Suit = Diamond | Heart | Spade | Club deriving (Read, Show, Eq, Ord)

data Card = Card Rank Suit

instance Eq Card where
    (Card r1 s1) == (Card r2 s2) = (r1 == r2) && (s1 == s2)

instance Ord Card where
    (<=) (Card r1 s1) (Card r2 s2)
     | (r1 == r2) = s1 <= s2
     | otherwise = r1 <= r2

data Hand = Hand Card Card Card

value :: Hand -> Integer
value (Hand (Card r1 s1) (Card r2 s2) (Card r3 s3))
    | (s1 == s2) && (s1 == s3) = 3
    | (r1 == r2) && (r1 == r3) = 2
    | (r1 == r2) || (r1 == r3) || (r2 == r3) = 1
    | otherwise = 0

maxCard :: Hand -> Card
maxCard (Hand c1 c2 c3)
    | c1 >= c2 && c1 >= c3 = c1
    | c2 >= c1 && c2 >= c3 = c2
    | otherwise = c3

instance Eq Hand where
    h1 == h2 = (value h1 == value h2) && (maxCard h1 == maxCard h2)

instance Ord Hand where
    h1 <= h2
        | value h1 == value h2 = maxCard h1 <= maxCard h2
        | otherwise = value h1 <= value h2