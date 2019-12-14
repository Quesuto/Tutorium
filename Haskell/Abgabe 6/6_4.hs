type StudentName = String
type CourseName  = String
type ExamScore   = (CourseName, Float)
type StudentData = [(StudentName, [ExamScore])]

students :: StudentData
students = [
 ("Tim Berners-Lee", [("Mathe", 1.3), ("Algorithmen und Datenstrukturen", 2.0)]), 
 ("Ada Lovelace",[("Info 1", 3.0), ("Lambda-Kalkül", 1.7), ("Mustererkennung", 2.3), ("Data Mining", 2.7)]),
 ("Alan Turing", [("Mathe", 1.7), ("Betriebssysteme", 2.0), ("Lambda-Kalkül", 1.7)]),
 ("Alonzo Church", [("Info 2", 2.7), ("Eingebettete Systeme", 2.3), ("Lambda-Kalkuel", 1.0), ("Algorithmen und Datenstrukturen", 3.0)]),
 ("Bjarne Stroustrup", [("Info 1", 2.7), ("Info 2", 1.3), ("Betriebssysteme", 2.0), ("Algorithmische Topologie", 2.3)]),
 ("Bjarne Stroustrup", [("Info 1", 2.7), ("Info 2", 1.3), ("Betriebssysteme", 2.0), ("Algorithmische Topologie", 2.3)]),
 ("Donald E. Knuth", [("Mathe", 3.3), ("Info 2", 1.7), ("Lambda-Kalkül", 2.0), ("Mustererkennung", 4.0)]),
 ("Grace Hopper", [("Info 3", 1.0), ("Betriebssysteme", 2.3), ("Eingebettete Systeme", 1.7)]),
 ("Annie Easley", [("Mathe", 1.0), ("Info 2", 1.7)]),
 ("Edsger W. Dijkstra", [("Algorithmische Topologie", 3.3), ("Algorithmen und Datenstrukturen", 2.7), ("Eingebettete Systeme", 4.0)]),
 ("John von Neumann", [("Mathe", 3.3), ("Algoritmische Topologie", 1.0), ("Betriebssysteme", 1.3), ("Eingebettete Systeme", 5.3)])
 ]

courses :: [CourseName]
courses = ["Mathe", "Info 1", "Info 2", "Algorithmen und Datenstrukturen", "Betriebssysteme", "Algorithmische Topologie", "Lambda-Kalkül", "Eingebettete Systeme", "Mustererkennung", "Data Mining"]

examResults :: [ExamScore]
examResults = [("Mathe", 3.3), ("Algoritmische Topologie", 1.0), ("Betriebsysteme", 1.3), ("Eingebettete Systeme", 5.3), ("Info 1", 1.7), ("Info 2", 1.7), ("Data Mining", 0.3)]

---------------------------------------------------------------------------
-- Aufgabe a
---------------------------------------------------------------------------
getNames :: StudentData -> [StudentName]
getNames stuDa = map (\stu -> fst stu) stuDa

addNoDuplicates :: StudentData -> (StudentName, [ExamScore]) -> StudentData
addNoDuplicates list stu
    | (fst stu) `elem` (getNames list) = list
    | otherwise = list ++ [stu]

filterDuplicates :: StudentData -> StudentData
filterDuplicates stuDa =
    foldr (\stu list -> (addNoDuplicates list stu)) [] stuDa

---------------------------------------------------------------------------
-- Aufgabe b
---------------------------------------------------------------------------
isValid :: ExamScore -> [CourseName] -> Bool
isValid examEntry courseNames =
    ((fst examEntry) `elem` courseNames) &&
    ((snd examEntry) >= 1.0 && (snd examEntry) <= 5.0)

filterValidEntries :: [ExamScore] -> [CourseName] -> [ExamScore]
filterValidEntries examEntries courseNames =
    filter (\examEntry -> isValid examEntry courseNames) examEntries
    
filterAllValidEntries :: StudentData -> [CourseName] -> StudentData
filterAllValidEntries stuDa courseNames =
    map (\stu -> (fst stu, filterValidEntries (snd stu) courseNames)) stuDa
---------------------------------------------------------------------------
-- Aufgabe c
---------------------------------------------------------------------------
getMarks :: [ExamScore] -> [Float]
getMarks examEntries = map (\examEntry -> snd examEntry) examEntries

avg :: [Float] -> Float
avg values = (foldr (\x sum -> sum + x) 0 values)
    / fromIntegral (length values)

calculateAverages :: StudentData -> [CourseName] -> [(StudentName, Float)]
calculateAverages stuDa courseNames =
    map (\stu -> (fst stu, avg (getMarks(snd stu)))) stuDaClean
    where 
    stuDaClean = filterAllValidEntries noDuplStuDa courseNames
    noDuplStuDa = filterDuplicates stuDa
---------------------------------------------------------------------------
-- Aufgabe d
---------------------------------------------------------------------------
collectCourseGrades :: StudentData -> CourseName -> [Float]
collectCourseGrades stuDa course =
    map (\exam -> snd exam)
    (filter (\cou -> (fst cou) == course) 
    (foldr (\stu list -> list ++ (snd stu)) [] stuDa))

variance :: StudentData -> CourseName -> [CourseName] -> Float
variance stuDa course courseNames =
    (foldr (\mark sum -> (mark - (avg marks))^2 + sum) 0 marks)
    / fromIntegral (length marks) 
    where 
    marks = collectCourseGrades stuDaClean course
    stuDaClean = filterAllValidEntries noDuplStuDa courseNames
    noDuplStuDa = filterDuplicates stuDa