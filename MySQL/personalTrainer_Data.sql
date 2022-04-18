use PersonalTrainer;
-- Activity 1
SELECT 
	exerciseId, 
	`name`, 
    exerciseCategoryId
FROM exercise;
    
-- Activity 2
SELECT * 
FROM client;

-- Activty 3
SELECT * 
FROM client 
WHERE city = "Metairie";
    
    
-- Activity 4
SELECT * 
FROM client 
where clientId = '818u7faf-7b4b-48a2-bf12-7a26c92de20c';
    
-- Activity 5
SELECT COUNT(*) FROM goal;

-- Activity 6
SELECT 
	`name`,
    levelId
FROM workout;

-- Activity 7
SELECT 
	`name`,
    levelId,
    notes
FROM workout
WHERE levelId = 2;

-- Activity 8
SELECT 
	firstName, 
    lastName,
    city
FROM client
WHERE (city = "Metairie" OR city = "Kenner" OR city = "Gretna");

-- Activity 9
SELECT 
	firstName,
    lastName,
    birthDate
FROM client
WHERE (birthdate >= "1980-01-01" AND birthdate < "1990-01-01");

-- Activity 10
SELECT 
	firstName, 
    lastName,
    birthDate
FROM client
WHERE birthdate BETWEEN "1980-01-01" AND "1989-12-31";

-- Activity 11
SELECT COUNT(*)
FROM login
WHERE EmailAddress LIKE "%.gov";

-- Activity 12
SELECT COUNT(*)
FROM login
WHERE EmailAddress NOT LIKE "%.com";
	

-- Activity 13
SELECT
	firstName,
    lastName
FROM client
WHERE birthdate IS NULL;

-- Activity 14
SELECT 
	`name`
FROM exercisecategory
WHERE ParentCategoryId IS NOT NULL;

-- Acvitity 15
SELECT 
	`name`,
    notes
FROM workout
WHERE levelId = 3 AND notes LIKE "%you%";

-- Activty 16
SELECT
	firstName,
    lastName,
    city
FROM client
WHERE city = "LaPlace" AND (lastName LIKE "L%" OR lastName LIKE "M%" Or LastName LIKE "N%");

-- Activity 17
SELECT
	invoiceId,
    `Description`,
    price,
    quantity,
    serviceDate,
    (price * quantity) AS Line_Item_Total
FROM invoicelineitem
WHERE (price * quantity) BETWEEN 15 AND 25;

-- Activity 18
SELECT * 
FROM client AS C 
INNER JOIN login AS L ON (C.ClientId = L.ClientId)
WHERE firstName = "Estrella" AND lastName = "Bazely";

-- Activity 19
SELECT Name 
FROM Goal WHERE GoalId IN(
	SELECT GoalId
    FROM WorkoutGoal
    WHERE WorkoutId In(
		SELECT workoutId
        FROM workout
        WHERE Name = "This is Parkour"
    )
);

-- Activity 19 using Joins
SELECT 
	w.WorkoutId,
	goal.Name
FROM workout AS w
INNER JOIN workoutGoal USING(workoutId)
INNER JOIN goal USING(goalId)
WHERE w.Name = "This Is Parkour";