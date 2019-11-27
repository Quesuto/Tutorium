module 55 where
----------------------------------------------------------------------------------
-- Liste
----------------------------------------------------------------------------------
data MyList = EmptyList | Item Float MyList deriving Show

rev :: MyList -> MyList
rev EmptyList = EmptyList
rev (Item n l) = append (rev l) n

append :: MyList -> Float -> MyList
append EmptyList f = Item f EmptyList
append (Item f1 l) f2 = Item f1 (append l f2)

append_list :: MyList -> MyList -> MyList
append_list l1 EmptyList = l1
append_list l1 (Item f2 l2) = append_list (append l1 f2) l2

{-
    append_list (rev (append (Item 1 (Item 2 (Item 3 (EmptyList)))) 4)) (Item 0 (EmptyList)) 
-}


----------------------------------------------------------------------------------
-- Binaerbaum
----------------------------------------------------------------------------------
data Tree = EmptyNode | Node Float Tree Tree deriving Show

depth :: Tree -> Int
depth EmptyNode = 0
depth (Node _ l r) = 1 + (max (depth l) (depth r))

insert :: Tree -> Float -> Tree
insert EmptyNode n = Node n EmptyNode EmptyNode
insert (Node m l r) n
    | n < m = Node m (insert l n) r
    | n > m = Node m l (insert r n)
    | otherwise = Node m l r

to_list :: Tree -> MyList
to_list EmptyNode = EmptyList
to_list (Node m l r) = append_list (append (to_list l) m) (to_list r)

{-
    to_list/depth (insert (Node 10 (Node 5 (Node 3 (EmptyNode)(EmptyNode))(EmptyNode))(Node 15 (EmptyNode)(Node 17 (EmptyNode)(EmptyNode))))1)
-}