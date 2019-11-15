data Point = MakePoint Float Float deriving Show
data Vector = MakeVector Float Float deriving Show

translate :: Point -> Vector -> Point
translate (MakePoint x y) (MakeVector vx vy) = (MakePoint (x+vx) (y+vy))

scale :: Point -> Float -> Point
scale (MakePoint x y) s = (MakePoint (x * s) (y * s))
class Polygon p where
    area :: p -> Float
    translate_poly :: p -> Vector -> p
    scale_poly :: p -> Float -> p

data Triangle = MakeTriangle Point Point Point deriving Show

data Quad = MakeQuad Point Point Point Point deriving Show

instance Polygon Triangle where
    area (MakeTriangle (MakePoint ax ay) (MakePoint bx by) (MakePoint cx cy)) = abs ((ax-bx)*(ay+by)+(bx-cx)*(by+cy)+(cx-ax)*(cy+ay))/ 2
    translate_poly (MakeTriangle a b c) v = (MakeTriangle (translate a v) (translate b v) (translate c v))
    scale_poly (MakeTriangle a b c) f = (MakeTriangle (scale a f) (scale b f) (scale c f))

instance Polygon Quad where
    area (MakeQuad (MakePoint ax ay) (MakePoint bx by) (MakePoint cx cy) (MakePoint dx dy)) = abs ((ax-bx)*(ay+by)+(bx-cx)*(by+cy)+(cx-dx)*(cy+dy)+(dx-ax)*(dy+ay)) / 2
    translate_poly (MakeQuad a b c d) v = (MakeQuad (translate a v) (translate b v) (translate c v) (translate d v))
    scale_poly (MakeQuad a b c d) f = (MakeQuad (scale a f) (scale b f) (scale c f) (scale d f))

-- Formel eines beliebigen Vielecks:
-- ((x1-x2)*(y1+y2) + (x2-x3)*(y2+y3) + ... + (xn-x1)*(yn+y1))/2 (Punkte gegen den Uhrzeigersinn angeben!)