use personaltrainer;

-- Exercise 1
SELECT 
	COUNT(*)
FROM client;


-- Exercise 2
SELECT 
	COUNT(birthdate)
FROM client;

-- Exercise 2a  counts the number of entries with no birthday
SELECT
	COUNT(IFNULL(client.birthdate, 1)) as 'No Birthdate Entered'
FROM client
WHERE birthdate is null;


-- Exercise 3
SELECT
	city,
    COUNT(clientId) as Client_Count
FROM client
GROUP BY city
ORDER BY Client_Count desc;


-- Exercise 4
SELECT
	invoiceId,
    SUM(price * quantity)
FROM invoicelineitem
GROUP BY invoiceID;


-- Exercise 5
SELECT
	invoiceId,
    SUM(price * quantity) AS Invoice_Total
FROM invoicelineitem
GROUP BY invoiceID
HAVING Invoice_Total > 500
ORDER BY Invoice_Total ASC;


-- Exercise 6
SELECT 
	invoiceLineItem.description,
    AVG(price * quantity)
FROM invoiceLineItem
GROUP BY invoiceLineItem.description;


-- Exercise 7
SELECT 
	client.clientId,
    firstName,
    lastName, 
    SUM(price * quantity) AS Total
FROM client
INNER JOIN invoice USING (clientId)
INNER JOIN invoiceLineItem USING (invoiceId)
WHERE invoiceStatus = 2
GROUP BY client.clientID
HAVING Total > 1000
ORDER BY lastName, firstName;


-- Exercise 8 Correct number of rows, wrong count
SELECT
	exercisecategory.Name,
    COUNT(exercise.exerciseCategoryId) AS ExerciseCount
FROM exercise
INNER JOIN exercisecategory USING(exerciseCategoryId)
GROUP BY exerciseCategory.Name
ORDER BY ExerciseCount DESC;


-- Exercise 9
SELECT
	exercise.Name,
    MIN(sets) AS MinSets,
    MAX(sets) AS MaxSets,
    Cast(AVG(sets) AS DECIMAL(5, 2)) AS AvgSets
FROM exercise
INNER JOIN exerciseInstance USING (exerciseId)
GROUP BY exercise.Name
ORDER BY exercise.Name;


-- Exercise 10
SELECT
	workout.name,
    MIN(birthdate) AS EarliestBirthday,
    Max(birthdate) AS LatestBirthday
FROM client
INNER JOIN clientWorkout USING (clientId)
INNER JOIN workout USING (workoutId)
GROUP BY workout.name
ORDER BY workout.name;


-- Exercise 11
SELECT
	client.clientId,
    SUM(goalId) AS GoalCount
FROM client
LEFT JOIN clientGoal USING (clientId)
LEFT JOIN goal USING (goalId)
GROUP BY client.clientId
ORDER BY ISNULL(GoalCount) DESC, GoalCount;


-- Exercise 12 WRONG NUMBER Of rows (expected 82, got 64)
SELECT
	exercise.name AS ExerciseName, 
    unit.name AS UnitName,
    Min(exerciseInstanceUnitValue.value) AS MinValue,
    Max(exerciseInstanceUnitValue.value) AS 'MaxValue'
FROM exercise
INNER JOIN exerciseInstance USING (exerciseId)
INNER JOIN exerciseInstanceUnitValue USING (exerciseInstanceId)
INNER JOIN unit USING (unitId)
GROUP BY exercise.exerciseId
ORDER BY ExerciseName, UnitName;


-- Exercise 13
SELECT
	exerciseCategory.name AS CategoryName,
	exercise.name AS ExerciseName, 
    unit.name AS UnitName,
    Min(exerciseInstanceUnitValue.value) AS MinValue,
    Max(exerciseInstanceUnitValue.value) AS 'MaxValue'
FROM exercise
INNER JOIN exerciseCategory USING (exerciseCategoryId)
INNER JOIN exerciseInstance USING (exerciseId)
INNER JOIN exerciseInstanceUnitValue USING (exerciseInstanceId)
INNER JOIN unit USING (unitId)
GROUP BY exercise.exerciseId
ORDER BY CategoryName, ExerciseName, UnitName;


-- Exercise 14 -- SLIGHTLY off ages numbers from exercise sheet
SELECT
	level.name AS LevelName,
    DATEDIFF(CURDATE(), MAX(client.birthDate)) / 365 AS MinAge,
    DATEDIFF(CURDATE(), MIN(client.birthDate)) / 365 AS MaxAage
FROM level
INNER JOIN workout USING (levelId)
INNER JOIN clientWorkout USING (workoutId)
INNER JOIN client USING (clientId)
GROUP BY LevelName;


-- Exercise 15
SELECT
	RIGHT(emailAddress, LOCATE(".", REVERSE(emailAddress)) - 1) AS Extension,
    COUNT(RIGHT(emailAddress, LOCATE(".", REVERSE(emailAddress))) - 1) AS Count
FROM login
GROUP BY Extension;


-- Exercise 16
SELECT
	firstName,
    lastName,
    workout.name,
    goal.goalId
	-- COUNT(goal.goalId) AS NumberClientGoals
FROM client
INNER JOIN clientGoal USING (clientId)
INNER JOIN goal USING (goalId)
INNER JOIN workoutGoal USING (goalId)
INNER JOIN workout USING(workoutId)
-- GROUP BY clientGoal.goalId, workout.name
ORDER BY lastName, firstName;

