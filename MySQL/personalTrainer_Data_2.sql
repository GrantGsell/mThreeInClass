USE personaltrainer;

-- Activity 1
SELECT *
FROM ExerciseCategory
INNER JOIN exercise USING(ExerciseCategoryId);

-- Activity 2
SELECT
	ExerciseCategory.Name,
    Exercise.Name
FROM ExerciseCategory
INNER JOIN Exercise USING(ExerciseCategoryId)
WHERE ExerciseCategory.ParentCategoryId IS NULL;

-- Activity 3
SELECT
	ExerciseCategory.Name AS CategoryName,
    Exercise.Name AS ExerciseName
FROM ExerciseCategory
INNER JOIN Exercise USING(ExerciseCategoryId)
WHERE ExerciseCategory.ParentCategoryId IS NULL;

-- Activity 4
SELECT
	firstName,
    lastName,
    BirthDate,
    login.emailaddress as Email
FROM client
INNER JOIN login USING(ClientId)
WHERE BirthDate BETWEEN '1990-01-01' AND '1999-12-31';

-- Activity 5
SELECT
	workout.Name,
    client.firstName,
    client.lastName
FROM client
INNER JOIN clientworkout USING(clientId)
INNER JOIN workout USING(workoutId)
WHERE client.lastName LIKE "C%";

-- Activity 6
SELECT 
	workout.name,
    goal.name
FROM workout
INNER JOIN workoutGoal USING(workoutId)
INNER JOIN goal USING(goalId);

-- Activity 7 Part 1
SELECT 
	firstName,
    lastName,
    login.clientId,
    emailAddress
FROM client
LEFT JOIN login USING(clientId);

-- Activty 7 part 2
SELECT 
	firstName,
    lastName,
    login.clientId,
    emailAddress
FROM client
LEFT OUTER JOIN login USING(clientId);
-- WHERE emailAddress is NULL OR clientId is NULL;

-- Activity 8
SELECT
	firstName,
    lastName,
    login.clientId,
    emailAddress
FROM client
LEFT JOIN login USING(clientId)
WHERE firstName = "Romeo" AND lastName = "Seaward";

-- Activity 9
SELECT 
	parent.exerciseCategoryId,
    parent.name AS Parent_Name,
    child.exerciseCategoryId,
    child.name AS Child_Name
FROM exercisecategory AS parent
INNER JOIN exercisecategory AS child ON (parent.ExerciseCategoryId = child.ParentCategoryId);

-- Activity 10
SELECT 
	parent.exerciseCategoryId,
    parent.name AS Parent_Name,
    child.exerciseCategoryId,
    child.name AS Child_Name
FROM exercisecategory AS parent
RIGHT JOIN exercisecategory AS child ON (parent.ExerciseCategoryId = child.ParentCategoryId);

-- Activity 11
SELECT
	* 
FROM client
LEFT JOIN clientWorkout AS cw USING(clientId)
WHERE cw.workoutId IS NULL;

-- Activity 12
SELECT 
	workout.name,
    workout.levelId
FROM workout
INNER JOIN workoutGoal USING (workoutId)
INNER JOIN goal USING (goalId)
INNER JOIN clientGoal USING (goalId)
INNER JOIN client USING (clientId)
WHERE client.firstName = "Shell" AND client.lastName = "Creane" AND workout.levelId = 1;

-- Activity 13

-- Activity 14


-- Activity 15