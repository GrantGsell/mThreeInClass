use trackit;

-- Exercise 1
SELECT *
FROM worker 
ORDER BY lastName ASC;

-- Exercise 2
SELECT
    w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY w.LastName ASC;

-- Exercise 3
SELECT
    w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY w.LastName ASC, p.Name ASC;

-- Exercise 4
SELECT
    w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY w.LastName DESC, p.Name ASC;

-- Exercise 5: Null
SELECT
    t.Title,
    s.Name StatusName
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
ORDER BY s.Name ASC;

-- Exercise 6: LIMIT
SELECT *
FROM worker
ORDER BY LastName DESC
LIMIT 0, 10;

-- Exercise 7: Distinct 
SELECT DISTINCT
    p.Name ProjectName,
    p.ProjectId
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
ORDER BY p.Name;

