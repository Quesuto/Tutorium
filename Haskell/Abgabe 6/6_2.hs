-- Signatur
module Set (Set(EmptySet,MkSet), isEmpty, contains, add, remove) where
  data Set a = EmptySet | MkSet (Set a) a
  isEmpty :: Set a -> Bool -- testet, ob Menge leer ist
  contains :: Eq a => Set a -> a -> Bool -- testet, ob Element in Menge enthalten
  add :: Eq a => Set a -> a -> Set a -- fugt Element der Menge hinzu
  remove :: Eq a =>  Set a -> a -> Set a -- entfernt Element aus der Menge

  -- Semantik
  isEmpty EmptySet = True
  isEmpty (MkSet as a) = False

  contains EmptySet a = False
  contains (MkSet as a) b
    | (a==b) = True
    | otherwise = contains as b

  add EmptySet a = MkSet EmptySet a
  add as a
    | contains as a = as
    | otherwise = (MkSet as a)

  remove EmptySet a = error "Set Empty"
  remove (MkSet as a) b
    | contains as b && (a==b) = remove as b
    | contains as b && (a/=b) = (MkSet (remove as b) a)
    | (a == b) = as
    | otherwise = error "as enthält b nicht und a!=b"